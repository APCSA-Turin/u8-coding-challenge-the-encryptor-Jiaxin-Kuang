package com.example.project;

public class Main{
    public static void main(String[] args) {
        String encryptedMessage = " =?!yeaddiostt uuoo ye ceirna  ywroehv  oslil etHi";
        int rows = 2;
        String expectedDecrypted = "Hello how are you today? it is very nice outside!";
        System.out.println(Encryptor.decryptMessage(encryptedMessage, rows));
    }
}