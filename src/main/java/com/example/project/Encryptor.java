package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

public class Encryptor {
    
    public static int determineColumns(int messageLen, int rows){
        if(messageLen < rows){
            return 1;
        }
        double lenOverRows = (double) messageLen/rows;
        int lenOverRows2 = messageLen/rows;
        if(lenOverRows == lenOverRows2){
            return lenOverRows2;
        }
        else{
            return lenOverRows2 + 1;
        }
    }
    
    public static String[][] generateEncryptArray(String message, int rows) {
        int columns = determineColumns(message.length(), rows);
        String[][] messageArray = new String[rows][columns];
        int k = 0; 
        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < columns; j ++){
                if(k < message.length()){
                    messageArray[i][j] = message.substring(k, k + 1);
                    k ++;
                }
                else{
                    messageArray[i][j] = "=";
                }
            }
        }
        return messageArray;
    }

    public static String encryptMessage(String message, int rows){
        int columns = determineColumns(message.length(), rows);
        String[][] messageArray = generateEncryptArray(message, rows);
        String encryptedMessage = "";
        for(int i = columns - 1; i >= 0; i --){
            for(int j = 0; j < rows; j ++){
                encryptedMessage += messageArray[j][i];
            }
        }
        return encryptedMessage;
    }

    public static String decryptMessage(String encryptedMessage, int rows) {
        String decryptedMessage = "";
        int columns = determineColumns(encryptedMessage.length(), rows);
        for (int i = 0; i < rows; i++){
            for (int j = columns - 1; j >= 0; j--){
                int index = j * rows + i;
                if(index < encryptedMessage.length() && !encryptedMessage.substring(index, index + 1).equals("=")){
                    decryptedMessage += encryptedMessage.substring(index, index + 1);
                }
            }
        }
        return decryptedMessage;
    }
}