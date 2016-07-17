package com.marketshare.ms360

import com.ActivityTracking.ActivityTrackerHostNameVerifier
import com.ActivityTracking.ActivityTrackerTrustManager
import grails.converters.JSON
import groovy.json.JsonSlurper
import org.apache.commons.codec.binary.Base64
import org.codehaus.groovy.grails.web.json.JSONObject

import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.text.SimpleDateFormat

class ActivityTrackerService {

    private static final activityTrackerProcessLog = org.apache.commons.logging.LogFactory.getLog("activity_tracker")
    private final static String USER_AGENT = "Mozilla/5.0";
    def mailService

    /**
     * This method sends the data to Elastic search module for indexing
     *
     * @author mourya.balla
     * @since 24/09/2015
     * @param body
     * @return response code
     */
    public int sendRequestToES(String body,String url){
        HttpURLConnection conn = null;
        OutputStream osw = null;
        int responseCode;
        try {
            // String urlString = "http://localhost:9200/testactivity/_bulk"
            String urlString = /*MappingConstants.ELASTIC_SEARCH_URL*/url+"/_bulk"
            activityTrackerProcessLog.info "ES url:"+urlString
            String name = "MSElasticSearchAdmin";
            String password = "ElasticSearch@2016";
            String authString = name + ":" + password;
            activityTrackerProcessLog.info("auth string: " + authString);
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            activityTrackerProcessLog.info("Base64 encoded auth string: " + authStringEnc);
            trustAllCertificates()
            conn = getHttpURLConnection(urlString);
            //conn.setRequestProperty(Constants.AUTHORIZATION, authorization);
            conn.setRequestProperty("Content-Type","application/json");
            conn.setRequestMethod("PUT");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Basic " + authStringEnc);

            osw = conn.getOutputStream();
            osw.write(body.getBytes());
            osw.close();

            BufferedReader br = null ;
            int code = conn.getResponseCode();
            responseCode=code
            activityTrackerProcessLog.info "Response Code from ES : "+responseCode
            activityTrackerProcessLog.info "Response Message from ES : " + conn.getResponseMessage()
            conn.disconnect();

            if(code !=200){
                activityTrackerProcessLog.info "Response Code not 200: Submit failed to Elastic search"
            } else{
                activityTrackerProcessLog.info "submitted successfully to ES"
            }

        }catch(Exception e){
            activityTrackerProcessLog.info("Exception occured while sending request to ES "+e.getMessage());
        }finally{
            try {
                if(conn!=null)
                    conn.disconnect();
                if(osw!=null)
                    osw.close();
            } catch (Exception e) {
                activityTrackerProcessLog.info("Exception occured while sending request to ES "+e.printStackTrace());
            }
        }
        return responseCode;
    }

    /**
     * This method sends the data to logstash input filter with json_lines codec
     * @author mourya.balla
     * @since 24/09/2015
     * @param body
     * @return response code
     */
    private static int sendRequestToLogstash(String urlParameters,String logstashUrl) throws Exception {
        // String url = "http://ec2-52-21-121-161.compute-1.amazonaws.com/activityTrackerAction";

        HttpURLConnection con=null
        DataOutputStream wr=null
        int responseCode
        String url = logstashUrl
        String name = MappingConstants.LOGSTASH_USERNAME
        String password = MappingConstants.LOGSTASH_PASSWORD
        try {
            String authString = name + ":" + password;
            System.out.println("auth string: " + authString);
            byte[] authEncBytes = Base64.encodeBase64(authString.getBytes());
            String authStringEnc = new String(authEncBytes);
            System.out.println("Base64 encoded auth string: " + authStringEnc);

            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();

            // add reuqest header
            con.setRequestMethod("PUT");
            con.setRequestProperty("Authorization", "Basic " + authStringEnc);
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            activityTrackerProcessLog.info("\nSending 'PUT' request to URL : " + url);
            activityTrackerProcessLog.info("PUT parameters : " + urlParameters);

            // Send post request
            con.setDoOutput(true);
            wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            responseCode = con.getResponseCode();
            activityTrackerProcessLog.info("Response Code : " + responseCode);

            activityTrackerProcessLog.info(con.toString());
        }catch(Exception ex){
            activityTrackerProcessLog.info("Exception occured while sending request to logstash "+ex.getMessage());
        }finally{
            try {
                if(con!=null)
                    con.disconnect();
                if(wr!=null)
                    wr.close();
            } catch (Exception e) {
                activityTrackerProcessLog.info("Exception occured while sending request to logstash "+e.printStackTrace());
            }

        }
        return responseCode
    }

    public void trustAllCertificates(){
        TrustManager[] trustManager = new TrustManager[1];

        trustManager[0] = new ActivityTrackerTrustManager()
        //{new ActivityTrackerTrustManager()};

        // Let us create the factory where we can set some parameters for the connection
        SSLContext sslContext = null;
        try {
            sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustManager, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            // do nothing
        }catch (KeyManagementException e) {
            // do nothing
        }

        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
    }




    public HttpURLConnection getHttpURLConnection(String uri){
        //HttpURLConnection conn = null;
        try {
            URL url = new URL(uri);
            String urlProtocol = getURLProtocol(url);
            if(urlProtocol.equals("https")){
                HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
                conn.setHostnameVerifier(new ActivityTrackerHostNameVerifier())
                return conn
            }else{
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                return conn
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

        //return conn;
    }

    public String getURLProtocol(URL url){
        return url.getProtocol();
    }

    /**
     * This method process the Activity tracking logs and Submit data to Elastic search module
     *
     * @author mourya.balla
     * @since 24/09/2015
     * @param dir
     * @param pattern
     */
    public void processActivityLog(String dir,String pattern) {
        BufferedReader br=null;
        long start = System.currentTimeMillis();
        def date = new Date()
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd")
        String currentDateString = sdf.format(date)
        try {

            File inFile = new File(dir)
            //process all files in dir matching the given pattern
            File[] listFiles = inFile.listFiles(new ActivityTrackerFileNameFilter(pattern));
            if(!listFiles){
                activityTrackerProcessLog.info(dir + " doesn't have any file with pattern "+pattern)
            }else {
                for (File tempFile : listFiles) {
                    activityTrackerProcessLog.info("Processing..File: " + dir + File.separator + tempFile.getName());

                    br = new BufferedReader(new FileReader(tempFile.getAbsolutePath()));

                    String line = null;
                    int batchCount = 0;
                    Map<String, Object> data = new HashMap<String, Object>()
                    StringBuilder sb = new StringBuilder()
                    List<String> sbErrorMsgList = new ArrayList<>()
                    JSONObject json = new JSONObject()
                    int response;
                    while ((line = br.readLine()) != null) {
                        //processing the line
                        try {
                            String[] tokens = line.split(",")
                            if(tokens.length == 1 || tokens.length != 9){
                                String errorMessage = (String)data.get("errorMessage");
                                StringBuilder errorBuilder = new StringBuilder();
                                errorBuilder.append(errorMessage).append(line);
                                data.put("errorMessage",errorBuilder.toString().replaceAll(" ",""));
                            }
                            else{
                                if(data.keySet().size() > 0){
                                    json.putAll(data);
                                   /* if(MappingConstants.IS_PRODUCTION){
                                        sb.append("{\"create\":{\"_index\" : \"activitytracker-${currentDateString}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                                    }else{
                                        sb.append("{\"create\":{\"_index\" : \"${MappingConstants.ELASTIC_SEARCH_INDEX}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                                    }*/
                                    sb.append(json.toString()).append("\n")
                                    //save all error messages to send in mail
                                    String errorMsg=data.get("errorMessage")
                                    if(errorMsg != null && !errorMsg.equals("NA") && !errorMsg.equals(" ") && MappingConstants.IS_ACTIVITY_TRACKER_MAIL_ENABLED){
                                        activityTrackerProcessLog.info("saving error msg..")
                                        sbErrorMsgList << (json.toString()+("\n"))

                                    }
                                    json.clear()
                                    data.clear()
                                }
                                batchCount++
                                //apiResponse(1), userInfo(2), sid(3), module(4), actionName(5), scenarioId(6), reportName(7), errorMessage(8)
                                String[] domainName=tokens[2].split("@")
                                data.put("@timestamp", tokens[0]);
                                data.put("apiResponseTime", Long.parseLong(tokens[1]));
                                data.put("userid", domainName[0]);
                                data.put("domain", domainName[1]);
                                data.put("sid", tokens[3]);
                                data.put("controller", tokens[4]);
                                data.put("action", tokens[5]);
                                data.put("scenarioid", Integer.parseInt(tokens[6]));
                                data.put("reportCode",tokens[7]);
                                data.put("errorMessage",tokens[8]);
                                data.put("popularSequence","na");
                                String instanceDetails = MappingConstants.SAML_USER_GROUP.replaceAll("-","").replaceAll("_","")
                                data.put("instanceDetails",instanceDetails)
                                data.put("documentType",MappingConstants.SAML_USER_GROUP)
                                data.put("deploymentEnvironment",MappingConstants.DEPLOYMENT_ENVIRONMENT)
                                data.put("releaseVersion",MappingConstants.RELEASE_VERSION)
                            }

                        } catch (Exception ex) {
                            activityTrackerProcessLog.info("not valid line,hence skipping :"+line)
                            continue;
                        }

                        if (batchCount % 1000 == 0) {
                            //POST to ES
                            List elasticUrls = Arrays.asList(MappingConstants.ELASTIC_SEARCH_URL)
                            elasticUrls.each {
                                activityTrackerProcessLog.info("the input JSON "+ sb.toString())
                                response=sendRequestToLogstash(sb.toString(),it)
                            }
                            activityTrackerProcessLog.info("Records submitted to Logstash:" + batchCount)
                            //clear stringBuilder
                            sb.setLength(0)
                            if(response!=200)
                                break;
                            //send mail
                            sendMail(sbErrorMsgList)
                            //empty error msg
                            sbErrorMsgList.clear()
                        }
                    }
                    if(data.keySet().size() > 0){
                        json.putAll(data);
                       /* if(MappingConstants.IS_PRODUCTION){
                            sb.append("{\"create\":{\"_index\" : \"activitytracker-${currentDateString}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                        }else{
                            sb.append("{\"create\":{\"_index\" : \"${MappingConstants.ELASTIC_SEARCH_INDEX}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                        }*/
                        sb.append(json.toString()).append("\n")
                        //save all error messages to send in mail
                        String errorMsg=data.get("errorMessage")
                        if(errorMsg != null && !errorMsg.equals("NA") && !errorMsg.equals(" ") && MappingConstants.IS_ACTIVITY_TRACKER_MAIL_ENABLED){
                            activityTrackerProcessLog.info("saving error msg..")
                            sbErrorMsgList << (json.toString()+("\n"))
                        }
                        json.clear()
                        data.clear()
                    }
                    // activityTrackerProcessLog.info("the String to be put to ES : "+sb.toString())
                    if (sb.length() > 0) {
                        //post to ES the remaining lines
                        List elasticUrls = Arrays.asList(MappingConstants.ELASTIC_SEARCH_URL)
                        elasticUrls.each {
                            activityTrackerProcessLog.info("the input JSON "+ sb.toString())
                            response=sendRequestToLogstash(sb.toString(),it)
                        }
                        //clear stringBuilder
                        sb.setLength(0)
                        if(response!=200)
                            break;
                        //send mail
                        sendMail(sbErrorMsgList)
                        sbErrorMsgList.clear()
                        activityTrackerProcessLog.info("Records submitted to Logstash:" + batchCount)
                    }
                    br.close();

                    //Delete the file only if all lines sucessfully submitted to ES
                    if(response==200){
                        if (!tempFile.delete()) {
                            activityTrackerProcessLog.error("Could not delete file:"+tempFile.getAbsolutePath());
                            throw new Exception("Could not delete File")
                        }
                    }
                    activityTrackerProcessLog.info("File Processed: " + dir + File.separator + tempFile.getName());

                }
            }

            activityTrackerProcessLog.info("Time taken for activity tracking::" + (System.currentTimeMillis() - start)/1000 +"s")
            activityTrackerProcessLog.info("Activity tracking process completed..")


        }
        catch (FileNotFoundException ex) {
            activityTrackerProcessLog.error("FileNotFoundException :"+ex.printStackTrace())
        }
        catch (IOException ex) {
            activityTrackerProcessLog.error("IOException :"+ex.printStackTrace())
        }
        catch (Exception ex){
            activityTrackerProcessLog.error("Exception occurred in activity tracking :"+ex.printStackTrace())
            activityTrackerProcessLog.error("Exception occurred in activity tracking :"+ex.message)
        } finally{
            if(br!=null){
                br.close()
            }

        }
    }


    public void sendMail(List<String> errorMsgList) {
        activityTrackerProcessLog.info("in send mail..")
        //activityTrackerProcessLog.info("sending mail..with contents:" + errorMsgList)
        //String mailMessage = "PFA the Exceptions occured in Action"
        String instanceDetails = MappingConstants.SAML_USER_GROUP.replaceAll("-","").replaceAll("_","")
        String emailSubject = "Re: Activity Tracker - Exceptions in ${instanceDetails} of Action"
        String[] emailIds = MappingConstants.ACTIVITY_MONITOR_MAILID_LIST//["mourya.balla@neustar.biz","mourya.balla@marketshare.com"/*, "Vedaprakash.Nidumolu@neustar.biz"*/]
        activityTrackerProcessLog.info("activity tracker emailIds:"+emailIds)
        errorMsgList?.each{
            //byte[] outArray = it.getBytes()
            String errorLog=it
            // String[] errorText = errorLog.split("\\\\t")
            //activityTrackerProcessLog.info("errorText:"+errorText.join("\n"))
            def jsonSlurper = new JsonSlurper()
            def obj=jsonSlurper.parseText(errorLog)
            def json = obj as JSON
            //Mail scenario using Grails Plugin
            mailService.sendMail {
                //async true
                multipart true
                from "no-reply@marketshare.com"
                to emailIds
                subject emailSubject.toString()
                text json.toString(true)
                // attach("${filename}", 'text/plain', outArray)
            }
        }

    }


    /**
     * This method process the Activity sequence logs and Submit data to Elastic search module
     *
     * @author mourya.balla
     * @since 20/01/2016
     * @param dir
     * @param pattern
     */
    public void processSequenceLog(String dir,String pattern){
        BufferedReader br=null;
        long start = System.currentTimeMillis();
        def date = new Date()
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd")
        String currentDateString = sdf.format(date)
        Map<String,String> sidActionSeqMap=new HashMap<>()
        try {
            File inFile = new File(dir)
            //process all files in dir matching the given pattern
            File[] listFiles = inFile.listFiles(new ActivityTrackerFileNameFilter(pattern));
            //sort files from oldest to latest to preserve activity sequence
            Arrays.sort(listFiles, new Comparator<File>() {
                public int compare(File f1, File f2) {
                    return Long.valueOf(f1.lastModified()).compareTo(f2.lastModified());
                }
            });
            if (listFiles.length == 0) {
                activityTrackerProcessLog.info(dir + " doesn't have any file with pattern " + pattern)
            } else {
                for (File tempFile : listFiles) {
                    activityTrackerProcessLog.info("Processing..File: " + dir + File.separator + tempFile.getName());

                    br = new BufferedReader(new FileReader(tempFile.getAbsolutePath()));

                    String line = null;
                    int batchCount = 0;
                    Map<String, Object> data = new HashMap<String, Object>()
                    StringBuilder sb = new StringBuilder()
                    JSONObject json = new JSONObject()
                    int response;
                    while ((line = br.readLine()) != null) {
                        //processing the line
                        try {
                            String[] tokens = line.split(",")
                            /*    if(tokens.length == 1 || tokens.length != 9){
                                    String errorMessage = (String)data.get("errorMessage");
                                    StringBuilder errorBuilder = new StringBuilder();
                                    errorBuilder.append(errorMessage).append(line);
                                    data.put("errorMessage",errorBuilder.toString());
                                    data.put("action", tokens[5]);
                                    data.put("scenarioid", Integer.parseInt(tokens[6]));
                                }
                                else {*/
                            // if (data.keySet().size() > 0) {
                            data.put("sid", tokens[1]);
                            data.put("action", tokens[2]);
                            data.put("apiResponseTime", Long.parseLong(tokens[3]));


                            if (sidActionSeqMap.containsKey(tokens[1])) {
                                String sequence = sidActionSeqMap.get(tokens[1])
                                sequence = sequence + "_" + tokens[2]
                                sidActionSeqMap.put(tokens[1], sequence)
                            } else {
                                sidActionSeqMap.put(tokens[1], tokens[2])
                            }

                            /*json.putAll(data);
                            if (MappingConstants.IS_PRODUCTION) {
                                sb.append("{\"index\":{\"_index\" : \"activitytracker-${currentDateString}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                            } else {
                                sb.append("{\"index\":{\"_index\" : \"${MappingConstants.ELASTIC_SEARCH_INDEX}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                            }
                            sb.append(json.toString()).append("\n")
                            json.clear()*/
                            data.clear()
                            // }
                            batchCount++
                            //}

                        } catch (Exception ex) {
                            activityTrackerProcessLog.info("not valid line,hence skipping :" + line)
                            continue;
                        }

                        /* if (batchCount % 1000 == 0) {
                             //POST to ES
                             response=sendRequestToES(sb.toString())
                             log.debug("Records submitted to ES:" + batchCount)
                             //clear stringBuilder
                             sb.setLength(0)
                             if(response!=200)
                                 break;
                         }*/

                    }
                    activityTrackerProcessLog.info("Number of sids found: " + sidActionSeqMap.size())
                    /*if (sb.length() > 0) {
                        //post to ES the remaining lines
                        response = sendRequestToES(sb.toString())
                        //clear stringBuilder
                        sb.setLength(0)
                        activityTrackerProcessLog.info("Records submitted to ES:" + batchCount)
                    }*/


                    br.close();

                    //Delete the file

                    if (!tempFile.delete()) {
                        activityTrackerProcessLog.error("Could not delete file:" + tempFile.getAbsolutePath());
                        throw new Exception("Could not delete File")
                    }
                    activityTrackerProcessLog.info("File Processed: " + dir + File.separator + tempFile.getName());

                }
            }
            Map<String, String> popularSeqMap = new HashMap<>()
            sidActionSeqMap.each {
                String popularSeq = sequenceGenerator(Arrays.asList(it.value.split("_")))
                activityTrackerProcessLog.info("popular seq for sid:" + it.key + " is " + popularSeq)
                popularSeqMap.put(it.key, popularSeq)
            }

            //send to ES
            Map<String, Object> data = new HashMap<String, Object>()
            StringBuilder sb = new StringBuilder()
            JSONObject json = new JSONObject()
            int batchCount=0
            popularSeqMap.each {
                if (data.keySet().size() > 0) {
                    json.putAll(data);
                    sb.append("{ \"create\" :")
                    if (MappingConstants.IS_PRODUCTION) {
                        sb.append("{\"index\":{\"_index\" : \"activitytracker-${currentDateString}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                    } else {
                        sb.append("{\"index\":{\"_index\" : \"${MappingConstants.ELASTIC_SEARCH_INDEX}\", \"_type\" : \"${MappingConstants.SAML_USER_GROUP}\"}}").append("\n")
                    }
                    sb.append(json.toString()).append("}").append("\n")
                    json.clear()
                    data.clear()
                }
                batchCount++
                //String[] domainName=tokens[2].split("@")
                data.put("@timestamp", System.currentTimeMillis());
                data.put("apiResponseTime", 0);
                data.put("userid", "na");
                data.put("domain", "na");
                data.put("sid",it?.key);
                data.put("controller", "na");
                data.put("action", "na");
                data.put("scenarioid", 0);
                data.put("reportCode", "na");
                data.put("errorMessage", "na");
                data.put("popularSequence",it?.value);
                data.put("instanceDetails",MappingConstants.SAML_USER_GROUP);
            }


            /*  if (batchCount % 100 == 0) {
                  //POST to ES
                  response=sendRequestToES(sb.toString())
                  log.debug("Records submitted to ES:" + batchCount)
                  //clear stringBuilder
                  sb.setLength(0)
                  if(response!=200)
                      break;
              }*/


            //activityTrackerProcessLog.info("the String to be submit to ES : "+sb.toString())
            if (sb.length() > 0) {
                //post to ES
                int response
                List elasticUrls = Arrays.asList(MappingConstants.ELASTIC_SEARCH_URL)
                elasticUrls.each {
                    activityTrackerProcessLog.info("the input JSON "+ sb.toString())
                    response=sendRequestToES(sb.toString(),it)
                }
                activityTrackerProcessLog.info("response from ES after submitting popular sequence :"+response)
                //clear stringBuilder
                sb.setLength(0)
                activityTrackerProcessLog.info("Records submitted to ES:" + batchCount)
            }

            activityTrackerProcessLog.info("Time taken for activity sequence generation::" + (System.currentTimeMillis() - start)/1000 +"s")
            activityTrackerProcessLog.info("Activity sequence process completed..")

        }
        catch (FileNotFoundException ex) {
            activityTrackerProcessLog.error("FileNotFoundException :"+ex.printStackTrace())
        }
        catch (IOException ex) {
            activityTrackerProcessLog.error("IOException :"+ex.printStackTrace())
        }
        catch (Exception ex){
            activityTrackerProcessLog.error("Exception occurred in activity seq process :"+ex.printStackTrace())
            activityTrackerProcessLog.error("Exception occurred in activity seq process :"+ex.message)
        } finally{
            if(br!=null){
                br.close()
            }

        }
    }


    public static String sequenceGenerator(List<String> s) {

        // form the N suffixes
        int N  = s.size();
        //String[] suffixes = new String[N];
        Map<Integer,String> suffixes=new HashMap<Integer,String>()
        for (int i = 0; i < N; i++) {
            // suffixes[i] = s.substring(i, N);
            ArrayList<String> sub=s.subList(i,N)
            // println "strings:"+sub.join("-")
            String seq=sub.join("_")
            suffixes.put(i,seq)
        }

        // sort them
        // Arrays.sort(suffixes);
        Map sortedSuffixes=suffixes.sort {it.value}
        //println("suffixes Map:"+sortedSuffixes)
        String[] suffixArray=sortedSuffixes.values().toArray()
        Integer[] suffixIndex=sortedSuffixes.keySet().toArray()

        // find longest repeated substring by comparing adjacent sorted suffixes
        String lrs = ""
        Map<String,Integer> sequenceMap=new HashMap<>()
        for (int i = 0; i < N - 1; i++) {
            //String x = lcp(suffixArray[i], suffixArray[i+1],suffixes.find { it.value == suffixArray[i] }?.key ,suffixes.find { it.value == suffixArray[i+1] }?.key ) ;
            ArrayList<String> x = lcp(suffixArray[i], suffixArray[i+1],suffixIndex[i],suffixIndex[i+1]) ;
            //String x = lcp(suffixes.get(i), suffixes.get(i+1));
            if(x.size() > 1) {
                String sequence=x.join("_")
                Integer counter = sequenceMap.get(sequence)
                if (counter == null)
                    counter = 0
                sequenceMap.put(sequence, ++counter)
                //println("match:" + sequence)

                if (sequence.split("_").size() > lrs.split("_").size())
                    lrs = sequence;
            }
        }
        sequenceMap.each {
            it.value++
        }
        Map<String,Integer> ansMap=new HashMap<>()
        //println("sequenceMap:"+lrs)
        int lrsLength=lrs.split("_").size()
        while(--lrsLength > 1){
            //println("iteration:"+lrsLength)
            Map<String,Integer> ans=findOccurences(s,lrsLength)//1239123939139
            ansMap<<ans
        }
        ansMap.put(lrs,sequenceMap.get(lrs))
        //activityTrackerProcessLog.info("Final Map:"+ansMap.sort{a, b -> b.value <=> a.value})
        //activityTrackerProcessLog.info("Final Map:"+ansMap.sort{a, b -> b.key.length() <=> a.key.length()})
        //mapping sequences by frequency of occurence
        List<Integer> frequency=ansMap.values().toSet().sort{a,b -> b.value <=> a.value}.asList()
        List<String> sequences=new ArrayList<>()
        frequency.each { a ->
                sequences << ansMap.findAll {it.value == a}.max{it.key.length()}.key
        }
        //sequences.sort {-it.length()}

        //ansMap.values().asList().get(0)
        activityTrackerProcessLog.info("sequences detected :"+sequences)
        return sequences[0];
    }

    // return the longest common prefix of s and t
    public static ArrayList<String> lcp(String s, String t , Integer index1 , Integer index2) {
        //println("s:"+s+" index:"+index1)
        //println("t:"+t+" index:"+index2)
        String[] sArray=s.split("_")
        String[] tArray=t.split("_")
        int n = Math.min(sArray.size(), tArray.size());
        int matchedCount=0
        for (int i = 0; i < n; i++) {
            if (!(sArray[i]).equals(tArray[i]))
                return sArray.toList().subList(0,i);
            matchedCount++
            //avoid overlap
            if(Math.abs(index1-index2) < matchedCount)
                return sArray.toList().subList(0,i)
        }
        return sArray.toList().subList(0,n);
    }


    public static Map<String, Integer> findOccurences(List<String> strList, int length) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> indexMap = new HashMap<>();
        int limit = strList.size() - length + 1;
        // StringBuilder sb=new StringBuilder()
        for (int i = 0; i < limit; i++) {
            int offset=i+length
            ArrayList<String> subList=strList.subList(i,offset)
            //println "strings:"+subList.join("-")
            String sub=subList.join("_")  //save the index also
            Integer counter = map.get(sub);

            if(counter !=null){
                if(Math.abs(i-(indexMap.get(sub))) < sub.split("_").size())
                    continue
            }
            if (counter == null) {
                counter = 0;
            }
            map.put(sub, ++counter);
            indexMap.put(sub, i);
            //println("after:"+sub)
        }
        return  map
    }


    /**
     * FileNameFilter for pattern matching
     */
    public static class ActivityTrackerFileNameFilter implements FilenameFilter{

        private String pattern;

        public ActivityTrackerFileNameFilter(String ext){
            this.pattern = ext.toLowerCase();
        }
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().matches(pattern);
        }

    }
}

