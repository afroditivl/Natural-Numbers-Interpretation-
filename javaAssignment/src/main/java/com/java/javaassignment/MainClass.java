package com.java.javaassignment;

import java.util.*;

/**
 * The application check number's start and length. It is just a first filtering to avoid 
 * unnecessary processing.
 */

public class MainClass {

    public static void main(String[] args) {

        NumberPrefix numberPrefix = new NumberPrefix();
        NumberPartsEdit numberPartsEditor = new NumberPartsEdit();
        PossiblePhoneNumbers possiblePhoneNumbers = new PossiblePhoneNumbers();
        String[] phoneNumberParts = phoneNumberInput();
        
        phoneNumberParts = numberPrefix.checkForValidStartOfNumber(phoneNumberParts);
        if (phoneNumberParts != null) { //means that has a valid start and at least 6 digits
            List<List<String>> dividedPartsOfNumber = numberPartsEditor.numberPartsDivision(phoneNumberParts);
            List<String> possibleNumbers = possiblePhoneNumbers.findPossiblePhoneNumbers(dividedPartsOfNumber);
            possiblePhoneNumbers.printValidPhoneNumber(possibleNumbers);
        }
        
        MyScanner.closeScanner();
    }

    public static String[] phoneNumberInput() {
        Scanner scanner = MyScanner.getScanner();
        System.out.println("Phone number:");
        String inputNumber = scanner.nextLine();
        String[] phoneNumberParts = checkForValidDigitsNumber(inputNumber);
        return phoneNumberParts;
    }

    public static String[] checkForValidDigitsNumber(String inputNumber){
        String[] phoneNumberParts;
        if (inputNumber.length() <= 7) { //a 3-digit number can expand to a 5-digit number, so we need at least 2 3-digit numbers (and one gap) to expand it in a valid phone number
            phoneNumberParts = null;
        } else {
            phoneNumberParts = inputNumber.split(" ");
        }
        return phoneNumberParts;
    }
    
}
