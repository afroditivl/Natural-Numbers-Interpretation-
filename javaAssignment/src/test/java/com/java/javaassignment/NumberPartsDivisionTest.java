package com.java.javaassignment;

import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

public class NumberPartsDivisionTest {

    private NumberPartsEdit editor;


    @Before
    public void setUp() {
        editor = new NumberPartsEdit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testingData() {
        return Arrays.asList(new Object[][]{

        });
    }

    /**
     * Test of numberPartsDivision method, of class NumberPartsEdit.
     */
    @Test
    public void testNumberPartsDivision() {
        List<List<String>> list = Arrays.asList(Arrays.asList("5"), Arrays.asList("26", "206"), Arrays.asList("728", "700208", "70028", "7208"));
        String[] numberParts = {"5", "26", "728", null};
        assertArrayEquals(list.toArray(), editor.numberPartsDivision(numberParts).toArray());
    }

}
