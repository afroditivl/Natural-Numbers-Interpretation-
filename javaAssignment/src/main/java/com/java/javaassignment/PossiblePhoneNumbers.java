package com.java.javaassignment;

import java.util.*;
import java.util.function.UnaryOperator;

public class PossiblePhoneNumbers {
    
    /**
     * This method takes a List of Lists and create every possible combination from those elements 
     */
    public List<String> findPossiblePhoneNumbers(List<List<String>> listOfLists) {
        List<String> previousList = new ArrayList();
        for (int i = 0; i < listOfLists.get(0).size(); i++) { //put first list's elements in the result list
            previousList.add(listOfLists.get(0).get(i));
        }
        for (int i = 1; i < listOfLists.size(); i++) {
            List results = concatenateTwoLists(previousList, listOfLists.get(i));
            previousList = results;
        }
        List<String> possibleNumbers = previousList;
        return possibleNumbers;
    }

    /**
     * This method takes two lists and return their cartesian product
     */
    public List<String> concatenateTwoLists(List<String> firstList, List<String> secondList) {
        List<String> results = new ArrayList();
        for (int i = 0; i < firstList.size(); i++) {
            for (int j = 0; j < secondList.size(); j++) {
                results.add(firstList.get(i).concat(secondList.get(j)));
            }
        }
        return results;
    }

    /**
     * This method takes a list with numbers and find out which of them are valid phone numbers or not 
     */
    public void printValidPhoneNumber(List<String> possibleNumbers) {
        possibleNumbers.forEach(number -> System.out.println(checkForValidPhoneNumbers(number)));
    }

    public String checkForValidPhoneNumbers(String phoneNumber){
        if ((phoneNumber.length() == 14 && (phoneNumber.substring(0, 5).equals("00302") || phoneNumber.substring(0, 6).equals("003069")))
                || (phoneNumber.length() == 10 && (phoneNumber.substring(0, 1).equals("2") || phoneNumber.substring(0, 2).equals("69")))) {
            return phoneNumber.concat("    [phone number: VALID]");
        } else {
            return phoneNumber.concat("    [phone number: INVALID]");
        }
    }
}
