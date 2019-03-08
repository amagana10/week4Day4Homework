package com.example.week4day4.utilities;

import java.util.ArrayList;

import static com.example.week4day4.model.CommonConstants.BLANK;

public class StringUtils {
    //check if string is null or empty
    public static boolean isActuallyEmpty(String stringToCheck){
        return stringToCheck == null ||stringToCheck.isEmpty();
    }
    //turn an array of strings to a single String
    public  static String createStringFromArrayList(ArrayList<String> arrayList){
        StringBuilder sb = new StringBuilder();
        for (String currentString : arrayList){
            sb.append(currentString);
            sb.append(BLANK);

        }
        return sb.toString();
    }
}
