package com.intropro.academy.vhavryliuk;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String sentenceToRevert = " abcd          newwennew hhrr12 ab12c3 18ab12cd33";
        System.out.println("========================");
        System.out.println("Original array of words:");
        System.out.println("========================");
        System.out.println(Arrays.toString(divideSentenceToWords(sentenceToRevert)));
        System.out.println("========================");
        System.out.println("Reverted words:");
        System.out.println("========================");
        for (String word: divideSentenceToWords(sentenceToRevert)){
            System.out.println(revertWord(word));
        }
        System.out.println("========================");
        System.out.println("Reverted except digits:");
        System.out.println("========================");
        for (String word: divideSentenceToWords(sentenceToRevert)){
            System.out.println(revertWordExceptDigit(word));
        }
    }

    static String revertWord(String word){
        char[] charArr = word.toCharArray();
        for (int i=0; i<charArr.length/2; i++){
            char tmp = charArr[i];
            charArr[i] = charArr[charArr.length - 1 - i];
            charArr[charArr.length - 1 - i] = tmp;
        }
        String result = new String (charArr);
        return result;
    }

    static String revertWordExceptDigit(String word){
        char[] charArr = word.toCharArray();
        int start = 0;
        int finish = charArr.length-1;
        while(start<finish){
            while(isDigit(charArr[start])){
                start++;
            }
            while (isDigit(charArr[finish])){
                finish--;
            }
            char tmp = charArr[start];
            charArr[start] = charArr[finish];
            charArr[finish] = tmp;
            start++;
            finish--;
        }
        String result = new String (charArr);
        return result;
    }

    static boolean isDigit(char character){
    return (character >= '0' && character <= '9');
    }

    static String[] divideSentenceToWords(String sentence){
        return sentence.trim().split("\\s+");
    }
}
