package Library;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.zip.CheckedInputStream;

/**
 * Created by asoni on 9/8/2016.
 */
public class Generator {
    public static void main(String[] args) {
        List characters = Arrays.asList('a','b','c','X','Y','Z');
        getStringByCharacterList(characters,10);
    }

    public static String getLowerCaseString(int size) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char c = (char)random.nextInt(26);
            str.append((char) ('a' + c));
        }
        return str.toString();
    }

    public static String getUpperCaseString(int size) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            char c = (char)random.nextInt(26);
            str.append((char) ('A' + c));
        }
        return str.toString();
    }


    public static List<Integer> getZeroToUpperBound(int upperBound, int size) {
        Random random = new Random();
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            integerList.add(random.nextInt(upperBound));
        }
        return integerList;
    }

    public static List<Integer> getIntNegativeUpperBoundToUpperBound(int upperBound, int size) {
        Random random = new Random();
        List<Integer> integerList = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            int currNo = random.nextInt(upperBound);
            currNo = random.nextInt(2) >= 1 ? currNo : currNo * (-1);
            integerList.add(currNo);
        }
        return integerList;
    }

    /**
     * Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z')
     * Arrays.asList('A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z')
     * @param characterList
     * @param size
     * @return
     */
    public static String getStringByCharacterList(List<Character> characterList,int size) {
        Random random = new Random();
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++) {
            int no = random.nextInt(characterList.size());
            str.append(characterList.get(no));
        }
        System.out.println(str.toString());
        return str.toString();
    }
}
