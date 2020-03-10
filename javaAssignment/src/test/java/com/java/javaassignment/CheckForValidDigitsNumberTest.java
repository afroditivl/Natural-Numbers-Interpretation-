package com.java.javaassignment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

@RunWith(Parameterized.class)
public class CheckForValidDigitsNumberTest {

    private String inputNumber;
    private String[] phoneNumberParts;

    public CheckForValidDigitsNumberTest(String inputNumber, String[] phoneNumberParts) {
        this.inputNumber = inputNumber;
        this.phoneNumberParts = phoneNumberParts;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testingData() {
        return Arrays.asList(new Object[][]{
                {"698 95", null},
                {"698 95 83", new String[]{"698", "95", "83"}}
        });
    }

    /**
     * Test of checkForValidDigitsNumber method, of class MainClass.
     */
    @Test
    public void testCheckForValidDigitsNumber() {
        assertArrayEquals(phoneNumberParts, MainClass.checkForValidDigitsNumber(inputNumber));
    }
}
