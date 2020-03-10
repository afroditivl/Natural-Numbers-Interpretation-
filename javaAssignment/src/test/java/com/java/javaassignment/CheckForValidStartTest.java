package com.java.javaassignment;

import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CheckForValidStartTest {

    private NumberPrefix editor;
    private String[] phoneNumberPartsInput;
    private String[] phoneNumberPartsExpected;

    public CheckForValidStartTest(String[] phoneNumberPartsInput, String[] phoneNumberPartsExpected) {
        this.phoneNumberPartsInput = phoneNumberPartsInput;
        this.phoneNumberPartsExpected = phoneNumberPartsExpected;
    }
        
    @Before
    public void setUp() {
        editor = new NumberPrefix();
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> testingData(){
        return Arrays.asList(new Object[][] {
            new String[][]{null, null},
            new String[][]{{"69", "760", "8"}, {"69", "768", null}},
            new String[][]{{"889", "760", "885"}, null}
        });
    }
    
    /**
     * Test of checkForValidStartOfNumber method, of class NumberPrefix.
     */
    @Test
    public void testCheckForValidStartOfNumber() {
        System.out.println("1 :   ");
        System.out.println(phoneNumberPartsExpected);
        System.out.println("2 :   ");
        System.out.println(editor.checkForValidStartOfNumber(phoneNumberPartsInput));
        assertArrayEquals(phoneNumberPartsExpected, editor.checkForValidStartOfNumber(phoneNumberPartsInput));
    }
}
