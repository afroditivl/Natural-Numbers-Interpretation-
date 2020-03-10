package com.java.javaassignment;

import java.util.Scanner;

public class MyScanner {

    private static Scanner scanner;

    private MyScanner() {
    }

    public static Scanner getScanner() {
        if(scanner == null){
            return scanner = new Scanner(System.in);
        }else{
            return scanner;
        }
    }

    public static void closeScanner(){
        try{
            scanner.close();
        }catch(IllegalStateException e){
            System.out.println("Scanner is not open");
        }
    }
}
