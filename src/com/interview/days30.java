package com.interview;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class days30 {

    public void days30(){
        LocalDate curDate = LocalDate.of(2019, 02, 27);
        int daysBetweenPeriod = ((curDate.plusDays(1).getYear() - curDate.getYear()) * 360) + ((curDate.plusDays(1).getMonthValue() - curDate.getMonthValue()) * 30) +
                ((isEndOfMonth(curDate.plusDays(1)) ? 30 : curDate.plusDays(1).getDayOfMonth()) - (isEndOfMonth(curDate) ? 30 : curDate.getDayOfMonth()));
        System.out.println(daysBetweenPeriod);
    }

    boolean isEndOfMonth(LocalDate date) {
        return date.equals(date.with(TemporalAdjusters.lastDayOfMonth()));
    }

}



    /*private static String lRSAKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxWlQk3gh0ImHOXhnhtbW"+
            "ZZ3FqtHI+v+5CL5Hs8mR/nS/Q/ewNPMWJ6n0RY6rQysH0NP3AoAujI3P2p7VC9B2"+
            "e7QyVcDucLw5GiqWJuxaJ76OoeHL5shzglFZrWkDLrccHGNUaH04co8G3RNM3lu0"+
            "4XU2CMQt0awuUsDvkCkJyeVV+ouyVTDF0mP7a1bGSQj9tRnl0cNh4PElpAd4vAnn"+
            "+TAgMJBJQ/hLqcx+IUH0XZfVBpfp0THOIuw8E83FQvukJWKFrpAxoTXczSQE7Zqs"+
            "mjg3GAQ0UMsoikDbGL1Vhe7CHmuj9QVGbUwN3NBhDcGpe3JmNT5QWWzsqYMZD9O0"+
            "8wIDAQAB";*/

    /*getRSAEncodedString("{\n" +
                "    \"CreateDate\": \"29/07/2021\",\n" +
                "    \"TimeFrom\": \"00:00\",\n" +
                "    \"TimeTo\": \"23:00\",\n" +
                "    \"Status\": \"P\",\n" +
                "    \"UCCList\": \"\",\n" +
                "    \"RecordType\": \"N\"\n" +
                "}");*/

//convertPasswordMD5("password@123");

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

    /*int fetchMinutes = 60;
        Random random = new Random();
        Integer cronSec = random.nextInt(60);
        String cronExpression = cronSec.toString() + " ";
        Integer cronMin = 0;
        Integer minutes = fetchMinutes % 60;
        if (minutes == 0) {
            cronMin = random.nextInt(60);
            cronExpression = cronExpression + cronMin + " ";
        } else {
            cronMin = random.nextInt(minutes);
            cronExpression = cronExpression + cronMin + "/" + minutes + " ";
        }
        Integer hours = (int) Math.ceil(fetchMinutes / 60.0);
        if (hours == 0)
            cronExpression = cronExpression + "* * * ?";
        else
            cronExpression = cronExpression + random.nextInt(hours) + "/" + hours + " * * ?";
        System.out.println(cronExpression);*/
