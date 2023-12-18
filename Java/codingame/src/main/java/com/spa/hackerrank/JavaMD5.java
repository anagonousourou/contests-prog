package com.spa.hackerrank;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(md5(scanner.nextLine()));
        scanner.close();
    }

    /**
     * https://stackoverflow.com/questions/415953/how-can-i-generate-an-md5-hash-in-java
     *
     * @param input
     * @return
     */
    public static String md5(String input) {
        try {
            byte[] bytesOfMessage = input.getBytes(StandardCharsets.UTF_8);
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(bytesOfMessage);
            return String.format("%032x", new BigInteger(1, thedigest));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
