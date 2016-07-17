//package MarketShare;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.text.DecimalFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///**
// * Created by asoni on 30-5-16.
// */
//public class Vinash {
//
//    class table {
//        Date datetime;
//        String cdatetime;
//        String address;
//        String district;
//        String beat;
//        String grid;
//        String crimedescr;
//        String  ucr_ncic_code;
//        String latitude;
//        String  longitude;
//
//    }
//    private static void firstquestion(){
//
//        int decrement = 0;
//        for (int i = 1; i <= 190000; i++){
//            if ((i % 7 == 0 )  ) {
//                decrement ++;
//                continue;
//            }
//            String charNum = String.valueOf(i);
//            if (charNum.contains("2")) {
//                //System.out.println("Contains 2: " + charNum);
//                decrement++;
//                continue;
//            }
//            int sum = 0;
//            for (int j = 0; j < charNum.length(); j ++) {
//                sum +=  charNum.charAt(j) - '0';
//            }
//            if (sum > 20) {
//                //System.out.println("Sum > 20 " + sum + " " + charNum );
//                decrement++;
//                continue;
//            }
//        }
//
//        //System.out.println(decrement);
//        System.out.println(190000 - decrement);
//    }
//
//    private static int getCount(String address, List<table> db){
//
//        int count = 0;
//        for (int i =0; i < db.size(); i ++) {
//            table tb = db.get(i);
//            String [] city = tb.address.split("/");
//            for (int j =0 ;j < city.length; j++) {
//                if (address.equals(city[j])){
//                    count ++;
//                }
//            }
//        }
//        return  count;
//    }
//
//    private static void secondQuestion (List <table> db){
//        int maxCount = 0;
//        String street = "";
//
//        for (int i =0; i < db.size(); i ++){
//            table tb = db.get(i);
////            System.out.println(tb.address);
//            String [] city = tb.address.split("/");
//            for (int j =0 ;j < city.length; j++) {
//                int count = getCount(city[j], db);
//                if (maxCount < count) {
//                    maxCount = count;
//                    street = city[j];
//                }
//            }
//        }
//        //System.out.println(maxCount);
//        System.out.println(street);
//    }
//
//    private List readDatabase (){
//
//        List db = new ArrayList();
//
//        String fileName = "D:\\pgit\\Competitions\\src\\MarketShare\\SacramentoCrimeJanuary2006.csv";
//        BufferedReader br = null;
//        try {
//            br = new BufferedReader(new FileReader(fileName));
//
//            String strLine = "";
//            strLine = br.readLine();
//            while ((strLine = br.readLine()) != null) {
//                String [] words = strLine.split(",");
//                table tb = new table();
//
//                tb.cdatetime = words[0];
//                tb.address= words[1];
//                tb.district= words[2];
//                tb.beat= words[3];
//                tb.grid= words[4];
//                tb.crimedescr= words[5];
//                tb.ucr_ncic_code= words[6];
//                tb.latitude= words[7];
//                tb.longitude= words[8];
////                DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern()
////                tb.datetime = new Date(tb.cdatetime);
//                db.add(tb);
//            }
//
//            //System.out.println(db.size());
//            return db;
//        } catch (Exception ex) {
//            System.out.println("Returning null" +   ex);
//            return  null;
//        }
//    }
//
//    private static void thirdQuestion () {
//        double hours = 744;
//        double count = 7584;
//
//        DecimalFormat df = new DecimalFormat("#.000");
//
//        System.out.println( df.format(count/hours));
//    }
//
//    private static void forthQuestion (List<table> db) {
//        int count = 0;
//        for (int i =0; i < db.size(); i++) {
//            int predicted;
//            table tb = db.get(i);
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm");
//            Date date = new Date();
//            try {
//                date = simpleDateFormat.parse(tb.cdatetime);
//            }catch (Exception ex) {
//
//            }
//
//            double hoursOfDay = date.getHours();
//            hoursOfDay += ((double)(date.getMinutes()) / 60.0);
////            System.out.println(hoursOfDay);
//            if (Double.compare( hoursOfDay,  6.5) <= 0){
//                if (Integer.parseInt(tb.grid) <= 627) {
//
//                    if (Double.parseDouble(tb.grid) <= 619.5) {
//                        predicted = 2404;
//                    } else {
//                        predicted = 2299;
//                    }
//                }
//                else {
//                    predicted = 7000;
//                }
//            } else if (Double.compare( hoursOfDay,  16.5) <= 0){
//                predicted = 7000;
//            } else {
//                if (Double.parseDouble(tb.grid) <= 506.5) {
//                    predicted =2404;
//                } else {
//                    predicted = 7000;
//                }
//            }
//
//            if (Integer.parseInt(tb.ucr_ncic_code) == predicted){
//                System.out.println(i);
//                count ++;
//            }
//        }
//
//        System.out.println(count);
//    }
//
//    public static void main(String[] args) {
//
//        firstquestion ();
//
//        Vinash main = new Vinash();
//        List db = main.readDatabase();
//
//        secondQuestion (db);
//
//        thirdQuestion ();
//
//        main.forthQuestion(db);
//    }
//}
