package com.java.javaassignment;

import java.util.*;

public class NumberPartsEdit {

    /**
     * @param number three-digit number
     * @return a List of possible combination of the three-digit number
     * e.g. 234 -> [200304, 20034, 2304, 234]
     */
    public List<String> threeDigitsNumber(String number) {
        StringBuilder numBuilder = new StringBuilder(number);
        List possibleNumbers = new ArrayList<String>();
        possibleNumbers.add(number);
        if (!number.contains("0")) {
            String num = numBuilder.substring(0, 1) + "00" + numBuilder.substring(1, 2) + "0" + numBuilder.substring(2, 3);
            possibleNumbers.add(num);
        }
        if (!numBuilder.substring(1, 2).equals("0")) { //e.g 234 or 230
            String num = numBuilder.substring(0, 1) + "00" + numBuilder.substring(1, 3);
            possibleNumbers.add(num);
        }
        if (!numBuilder.substring(2, 3).equals("0")) { //e.g 234 or 203
            String num = numBuilder.substring(0, 2) + "0" + numBuilder.substring(2, 3);
            possibleNumbers.add(num);
        }
        return possibleNumbers;
    }

    /**
     * As this program dealing with Greek numbers, I took it for granted that the audio
     * input will be in Greek language. So if client says "11" --> "έντεκα" or "12" --> "δώδεκα"
     * it couldn't be "101" or "102" respectively.
     * @param number two-digit number
     * @return a List of possible combination of the two-digit number
     * e.g. 23 -> [203, 23]
     */
    public List<String> twoDigitsNumber(String number) {
        List possibleNumbers = new ArrayList();
        possibleNumbers.add(number);
        if (!number.contains("0") && !number.equals("11") && !number.equals("12")) {
            String num = number.substring(0, 1) + "0" + number.substring(1, 2);
            possibleNumbers.add(num);
        }
        return possibleNumbers;
    }

    /**
     * This method takes a String array with number's parts and edits them considering their number of digits
     */
    public List<List<String>> numberPartsDivision(String[] parts){
        List<List<String>> dividedNumbers = new ArrayList<List<String>>();
        for(int i=0; i<parts.length; i++){
            if (parts[i] == null){
                continue;
            }
            int numberLength = parts[i].length();
            List list = new ArrayList();
            switch(numberLength){
                case 1:
                    list.add(parts[i]);
                    break;
                case 2:
                    list = twoDigitsNumber(parts[i]);
                    break;
                case 3:
                    list = threeDigitsNumber(parts[i]);
                    break;
            }
            dividedNumbers.add(list);
        }
        return dividedNumbers;
    }
    
    /**
     * This method checks if two or three numbers can minimized to one.
     * e.g. 20 5 -> 25, 200 24 -> 224, 500 8 -> 508, 100 20 3 -> 123 etc.
     * @param parts a String array with number's parts before any processing
     * @return a String array with number's parts after processing
     */
    public String[] collapsePhoneNumber(String[] parts) {
        for (int i = 0; i < parts.length - 1; i++) {
            if (parts[i] == null) {
                continue;
            }
            int number1 = -1, number2 = -1, number3 = -1;
            number1 = Integer.parseInt(parts[i]);
            if (number1 != 0 && number1 % 100 == 0 && parts[i + 1] != null && parts[i + 1].length() <= 2) {
                number2 = Integer.parseInt(parts[i + 1]);
                if(number2 == 0){
                    continue;
                }
                parts[i] = "" + (number1 + number2);
                parts[i + 1] = null;
            }
            if (number1 != 0 && number1 % 10 == 0) {
                int j = i + 1;
                while (j < parts.length && parts[j] == null) {
                    j++;
                }
                if (j == parts.length) {
                    break;
                }
                if (parts[j].length() == 1) {
                    number3 = Integer.parseInt(parts[j]);
                    if(number3 == 0){
                        continue;
                    }
                    parts[i] = "" + (Integer.parseInt(parts[i]) + number3);
                    parts[j] = null;
                }
            }
        }
        return parts;
    }
}
