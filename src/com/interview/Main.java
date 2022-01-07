package com.interview;

import com.interview.array.subArray.f_MaxSumSubarrayByRemovingAtMostOneElement;
import com.interview.array.subArray.g_MaxSumBitonicSubArray;
import com.interview.dynamic.LCS.k_LongestSubStringWithNonRepeatedChar;
import com.interview.list.Node;
import com.interview.stack.WaterTapping;
import com.interview.stack.nearest.a_NearestGreaterNumbersOnLeft;
import com.interview.string.MinFlipsToAlternateString;
import com.interview.tree.distance.NodesAtDistance;
import com.interview.tree.distance.NodesAtDistanceFromLeaf;

import javax.crypto.Cipher;
import java.lang.*;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class Main {

    private static String lRSAKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxWlQk3gh0ImHOXhnhtbW"+
            "ZZ3FqtHI+v+5CL5Hs8mR/nS/Q/ewNPMWJ6n0RY6rQysH0NP3AoAujI3P2p7VC9B2"+
            "e7QyVcDucLw5GiqWJuxaJ76OoeHL5shzglFZrWkDLrccHGNUaH04co8G3RNM3lu0"+
            "4XU2CMQt0awuUsDvkCkJyeVV+ouyVTDF0mP7a1bGSQj9tRnl0cNh4PElpAd4vAnn"+
            "+TAgMJBJQ/hLqcx+IUH0XZfVBpfp0THOIuw8E83FQvukJWKFrpAxoTXczSQE7Zqs"+
            "mjg3GAQ0UMsoikDbGL1Vhe7CHmuj9QVGbUwN3NBhDcGpe3JmNT5QWWzsqYMZD9O0"+
            "8wIDAQAB";

    static int n =10;
    static int count = 1;
    static Boolean isEven = Boolean.FALSE;

    public static void main(String[] args) throws Exception {
        /*getRSAEncodedString("{\n" +
                "    \"CreateDate\": \"29/07/2021\",\n" +
                "    \"TimeFrom\": \"00:00\",\n" +
                "    \"TimeTo\": \"23:00\",\n" +
                "    \"Status\": \"P\",\n" +
                "    \"UCCList\": \"\",\n" +
                "    \"RecordType\": \"N\"\n" +
                "}");*/
        //convertPasswordMD5("paytmMoney@535");

        /*NodesAtDistanceFromLeaf n= new NodesAtDistanceFromLeaf();
        n.printNodes();*/

        //How do you find the missing number in a given integer array of 1 to 100?
        //Missing numbers in integer array [1, 2, 3, 4, 6], with size 6 is 5

        String s = null;
        Boolean bool = Boolean.valueOf(s);

        System.out.print(bool);
    }

    public static void missingNumber(int[] arr, int max){

        int actualSum = (max * (max + 1)) / 2;
        int currSum = 0;

        if(arr.length == max || arr.length == max - 2)
            System.out.print("Not a valid input for missingelemnet");

        for(int i=0; i<arr.length; i++){
            currSum += arr[i];
        }

        System.out.print(actualSum - currSum);
    }

    private static void printOdd(){
        while(count < n){
            if(count % 2 != 0 && !isEven) {
                System.out.print(count++ +" ");
                isEven = Boolean.TRUE;
            }
        }
    }

    private static void printEven(){
        while(count < n){

            if(count % 2 == 0 && isEven) {
                System.out.print(count++ + " ");
                isEven = Boolean.FALSE;
            }
        }
    }

    public static void printSubSetSizeK(int[] arr, int k, int size){
        int[] tmp = new int[size];
        printSubSetSizeKUtil(arr, k, size, tmp, 0, 0);
    }

    private static void printSubSetSizeKUtil(int[] arr, int sum, int size, int[] tmp, int index, int currPos){

        if(index == size){
            int var = 0;
            for(int i=0; i<size; i++)
                var += tmp[i];

            if(var <= sum){
                System.out.println(tmp[0] + " " + tmp[1] + " " + tmp[2]);
                return;
            }
        }

        if(currPos > arr.length - 1)
            return;

        tmp[index] = arr[currPos];
        printSubSetSizeKUtil(arr, sum, size, tmp, index + 1, currPos + 1);
        printSubSetSizeKUtil(arr, sum, size, tmp, index, currPos + 1);
    }

    private static Boolean hasString(Set<Character> set, String tmp){
        for(int i=0; i<tmp.length(); i++) {
            if (!set.contains(tmp.charAt(i))) {
                return false;
            }
            if(i == tmp.length()-1)
                return true;
        }
        return false;
    }

/* public static void convertPasswordMD5(String passwordToHash) throws NoSuchAlgorithmException {
        String generatedPassword = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(passwordToHash.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < bytes.length; ++i) {
            sb.append(Integer.toString((bytes[i] & 255) + 256, 16).substring(1));
        }

        generatedPassword = sb.toString();
        System.out.println(generatedPassword);
    }

    public static void getRSAEncodedString(String json) throws Exception {
        StringBuffer lSB = new StringBuffer();
        lSB.append(json);
        String lSHAOP = getSHAString(lSB.toString());
        String lRSAOP = getRSAEncryptString(lRSAKEY, lSHAOP);
        System.out.print(lRSAOP);
    }

    public static String getSHAString(String pInput) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] messageDigest = md.digest(pInput.getBytes());
        BigInteger no = new BigInteger(1, messageDigest);

        String hashtext;
        for(hashtext = no.toString(16); hashtext.length() < 64; hashtext = "0" + hashtext) {
        }

        return hashtext;
    }

    public static String getRSAEncryptString(String pPublicKey, String pData) throws Exception {
        byte[] keyBytes = Base64.getDecoder().decode((pPublicKey.getBytes()));
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey pubKey = keyFactory.generatePublic(spec);
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, pubKey);
        byte[] cipherText = rsaCipher.doFinal(pData.getBytes("UTF-8"));
        Base64.getEncoder().encodeToString(cipherText);
        return Base64.getEncoder().encodeToString(cipherText);

    }*/
}

class ABC{
    static int start = 1;
    static int N = 10;
    public void printOddEven() {
        Thread oddThread = new Thread(new Runnable() {
            public void run() {
                printOdd();
            }
        });

        Thread evenThread = new Thread(new Runnable() {
            public void run() {
                printEven();
            }
        });

        oddThread.start();
        evenThread.start();
    }

    public void printOdd(){

        synchronized(this) {
            while (start < N) {
                while (start % 2 ==0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(start++ + " ");
                notify();
            }
        }
    }

    public void printEven(){
        synchronized (this) {
            while (start < N) {
                while (start % 2 !=0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.print(start++ + " ");
                notify();
            }
        }
    }
}

class OddEven{

    int n = 10;
    int start = 1;
    Boolean isEven = Boolean.FALSE;
    public void printOddEven(){
        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printOdd();
            }
        });

        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                printEven();
            }
        });

        oddThread.start();
        evenThread.start();
    }

    private void printOdd(){
        while (start < n){
            if(!isEven)
                if(start % 2 != 0) {
                    System.out.print(start++ + " ");
                    isEven = !isEven;
                }
        }
    }

    private void printEven(){
        while (start < n){
            if(isEven)
                if(start % 2 == 0) {
                    System.out.print(start++ + " ");
                    isEven = !isEven;
                }
        }
    }
}
