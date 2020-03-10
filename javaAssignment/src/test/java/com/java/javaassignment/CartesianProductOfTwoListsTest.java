package com.java.javaassignment;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CartesianProductOfTwoListsTest {
    
    private PossiblePhoneNumbers editor;
    
    public CartesianProductOfTwoListsTest() {
    }
    
    @Before
    public void setUpClass() {
        editor = new PossiblePhoneNumbers();
    }
   
    /**
     * Test of concatenateTwoLists method, of class PossiblePhoneNumbers.
     */
    @Test
    public void testConcatenateTwoLists() {
        List<String> list1= Arrays.asList("2", "36");
        List<String> list2= Arrays.asList("0", "6", "17");
        List<String> resultList = Arrays.asList("20", "26", "217", "360", "366", "3617");
        assertArrayEquals(resultList.toArray(), editor.concatenateTwoLists(list1, list2).toArray());
    }

}
