package com.java.javaassignment;

import java.util.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CollapseNumberPartsTest {

    private NumberPartsEdit editor;
    private String[] numberParts;
    private String[] dividedNumbers;

    public CollapseNumberPartsTest(String[] numberParts, String[] dividedNumbers) {
        this.numberParts = numberParts;
        this.dividedNumbers = dividedNumbers;
    }

    @Before
    public void setUp() {
        editor = new NumberPartsEdit();
    }

    @Parameters
    public static Collection<Object[]> testingData() {
        return Arrays.asList(new Object[][]{
                new String[][]{{"200", "20", "2"}, {"222", null, null}},
                new String[][]{{"300", "30"}, {"330", null}},
                new String[][]{{"440", "4"}, {"444", null}},
                new String[][]{{"500", "5"}, {"505", null}},
                new String[][]{{"60", "6"}, {"66", null}},
                new String[][]{{"600", "0"}, {"600", "0"}},
                new String[][]{{"00", "3", "127", "60", "0", "25", "3"}, {"00", "3", "127", "60", "0", "25", "3"}}
        });
    }

    /**
     * Test of collapsePhoneNumber method, of class NumberPartsEdit.
     */
    @Test
    public void testCollapsePhoneNumber() {
        System.out.println("Arr1: ");
        printArray(dividedNumbers);
        System.out.println("Arr2: ");
        printArray(editor.collapsePhoneNumber(numberParts));
        assertArrayEquals(dividedNumbers, editor.collapsePhoneNumber(numberParts));
    }

    private static void printArray(String[] arr){
        for(String i: arr){
            System.out.println(i);
        }
    }

}
