package com.java.javaassignment;

import java.util.*;
import org.junit.*;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FirstValidationCheck_prefixAndDigitsTest {

    private NumberPrefix editor;
    private String[] numberPartsInput;
    private boolean hasValidStart;
    private String[] numberPartsExpected;

    public FirstValidationCheck_prefixAndDigitsTest(String[] numberPartsInput, String[] numberPartsExpected, boolean hasValidStart) {
        this.numberPartsInput = numberPartsInput;
        this.hasValidStart = hasValidStart;
        this.numberPartsExpected = numberPartsExpected;
    }

    @Parameters
    public static Collection<Object[]> testingData() {
        return Arrays.asList(new Object[][]{
            {new String[]{"885", "50", "125"}, null, false},
            {new String[]{"69", "760", "8"}, new String[]{"69", "768"}, true}
        });
    }

    @Before
    public void setUp() {
        editor = new NumberPrefix();
    }

    /**
     * Test of firstValidationCheck method, of class NumberPrefix.
     */
    @Test
    public void testFirstValidationCheck() {
    }

    /**
     * Test of numberWithoutGaps method, of class NumberPrefix.
     */
    @Test
    public void testNumberWithoutGaps() {
        StringBuilder builder = new StringBuilder("6986956412");
        String[] phoneParts = new String[]{"6", "9", "869", "564", "12"};
        assertEquals(builder.toString(), editor.numberWithoutGaps(phoneParts).toString());
    }

}
