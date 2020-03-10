package com.java.javaassignment;

/*
This class concludes functions that check number's prefix.
 */
public class NumberPrefix {

    /**
     * This method takes the phone number as an argument, and check if its start
     * could be valid or not. Is a first check to avoid unnecessary processing.
     *
     * @param phoneNumber (without gaps) from user's input
     * @return true if phoneNumber can be valid and false if it is invalid
     */
    public boolean checkNumberStart(StringBuilder phoneNumber) {
        boolean hasValidStart = false;
        if (phoneNumber.substring(0, 3).equals("003")) { //just a first filtering. 
            hasValidStart = true;
        } else if (phoneNumber.substring(0, 1).equals("6")) {
            hasValidStart = checkMobilePhoneStart(phoneNumber);
        } else if (phoneNumber.substring(0, 1).equals("2")) {
            hasValidStart = true;
        }
        return hasValidStart;
    }

    public boolean checkMobilePhoneStart(StringBuilder phoneNumber) {
        boolean hasValidStart = false;
        if (phoneNumber.substring(0, 4).equals("6009") || phoneNumber.substring(0, 3).equals("609") || phoneNumber.substring(0, 2).equals("69")) {
            hasValidStart = true;
        }
        return hasValidStart;
    }    

    public String[] checkForValidStartOfNumber(String[] phoneNumberParts) {
        if (phoneNumberParts != null) {
            StringBuilder phoneNumber = numberWithoutGaps(phoneNumberParts);
            boolean hasValidStart = checkNumberStart(phoneNumber);
            phoneNumberParts = firstValidationCheck(hasValidStart, phoneNumberParts);
        } else {
            System.out.println("Invalid phone number (less digits)");
        }
        return phoneNumberParts;
    }
    
    /**
     * This method takes a boolean variable to know if number can be valid or not. 
     * If yes, process is continuing, number input is editing and parts of number get into phoneNumberParts list.
     * If not, application will stop.
     * @param hasValidStart
     * @param phoneNumberParts
     * @return a String array with (collapsed) parts of number input
     * (null if number has no valid start)
     */
    public String[] firstValidationCheck(boolean hasValidStart, String[] phoneNumberParts) {
        NumberPartsEdit numberPartsEditor = new NumberPartsEdit();
        if (hasValidStart == false) {
            System.out.println("Invalid phone number (Illegal start)");
            phoneNumberParts = null;
            //INVALID
        } else {
            //Collapse number
            phoneNumberParts = numberPartsEditor.collapsePhoneNumber(phoneNumberParts);
        }
        return phoneNumberParts;
    }

    public StringBuilder numberWithoutGaps(String[] phoneParts) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < phoneParts.length; i++) {
            builder.append(phoneParts[i]);
        }
        return builder;
    }
}
