package com.interview.systemDesign;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class URLSortner {

    // Base62 characters
    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int SHORT_URL_LENGTH = 7;
    private static Map<String, String> urlMap = new HashMap<>();

    // Method to generate MD5 hash
    private static String generateMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    // Method to convert part of MD5 hash to base62
    private static String base62Encode(String hash) {
        StringBuilder shortURL = new StringBuilder();
        long hashValue = Long.parseUnsignedLong(hash.substring(0, 11), 16); // Use first 10 hex chars (~40 bits)
        for (int i = 0; i < SHORT_URL_LENGTH; i++) {
            shortURL.append(BASE62.charAt((int) (hashValue % 62)));
            hashValue /= 62;
        }
        return shortURL.reverse().toString();
    }

    // Method to generate short URL
    public static String generateShortURL(String originalURL) {
        String md5Hash = generateMD5Hash(originalURL);
        String shortURL = base62Encode(md5Hash);
        urlMap.put(shortURL, originalURL);
        return shortURL;
    }

    // Method to retrieve original URL
    public static String getOriginalURL(String shortURL) {
        return urlMap.get(shortURL);
    }

    public static void main(String[] args) {
        String originalURL = "https://www.example.com/some/very/long/url";
        String shortURL = generateShortURL(originalURL);
        System.out.println("Original URL: " + originalURL);
        System.out.println("Short URL: " + shortURL);
        System.out.println("Retrieved URL: " + getOriginalURL(shortURL));
    }
}
