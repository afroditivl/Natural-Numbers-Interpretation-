package com.java.javaassignment;

import java.util.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class findPossibleNumbersWithCartesianProductTest {
    
    private PossiblePhoneNumbers editor;
    
    public findPossibleNumbersWithCartesianProductTest() {
    }
    
    @Before
    public void setUpClass() {
        editor = new PossiblePhoneNumbers();
    }
    
    /**
     * Test of findPossiblePhoneNumbers method, of class PossiblePhoneNumbers.
     */
    @Test
    public void testFindPossiblePhoneNumbers() {
        List<List<String>> list = Arrays.asList(
                Arrays.asList("2", "3"),
                Arrays.asList("4", "5"),
                Arrays.asList("6", "7")
                );
        List<String> resultList = Arrays.asList("246", "247", "256", "257", "346", "347", "356", "357");
        assertArrayEquals(resultList.toArray(), editor.findPossiblePhoneNumbers(list).toArray());
    }
    
}
