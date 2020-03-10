package com.java.javaassignment;

import java.util.*;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TwoOrThreeDigitsNumberDivisionTest {
    
    enum Type {THREEDIGITS, TWODIGITS, MIXEDNUMBERS};
    
    private NumberPartsEdit editor;
    private Type type;
    private String number;
    private List<String> possibleNumbers;
       
    public TwoOrThreeDigitsNumberDivisionTest(Type type, String number, List<String> possibleNumbers) {
        this.type = type;
        this.number = number;
        this.possibleNumbers = possibleNumbers;
    }

    @Before
    public void setUp() {
        editor = new NumberPartsEdit();
        System.out.println("Type: " + type);
        System.out.println("Number: " + number);
        System.out.println("Possible: " + possibleNumbers);
    }
    
    @Parameters
    public static Collection<Object[]> testingData(){
        return Arrays.asList(new Object[][] {
          {Type.THREEDIGITS, "234", Arrays.asList("234", "200304", "20034", "2304")},
          {Type.THREEDIGITS, "230", Arrays.asList("230", "20030")},
          {Type.THREEDIGITS, "204", Arrays.asList("204", "2004")},
          {Type.THREEDIGITS, "200", Arrays.asList("200")},
          {Type.TWODIGITS, "11", Arrays.asList("11")},
          {Type.TWODIGITS, "12", Arrays.asList("12")},
          {Type.TWODIGITS, "10", Arrays.asList("10")},
          {Type.TWODIGITS, "39", Arrays.asList("39", "309")}
        });
    }

    /**
     * Test of threeDigitsNumber method, of class NumberPartsEdit.
     */
    @Test
    public void testThreeDigitsNumber() throws Exception{
//        Assume.assumeTrue(type == Type.THREEDIGITS);
        if(type == Type.THREEDIGITS)
        assertArrayEquals(possibleNumbers.toArray(), editor.threeDigitsNumber(number).toArray());
    }

    /**
     * Test of twoDigitsNumber method, of class NumberPartsEdit.
     */
    @Test
    public void testTwoDigitsNumber() throws Exception{
//        Assume.assumeTrue(type == Type.TWODIGITS);
        if(type == Type.TWODIGITS)
        assertArrayEquals(possibleNumbers.toArray(), editor.twoDigitsNumber(number).toArray());
    }

//    /**
//     * Test of numberPartsDivision method, of class NumberPartsEdit.
//     */
//    @org.junit.Test
//    public void testNumberPartsDivision() throws Exception{
//    }
//
//    /**
//     * Test of collapsePhoneNumber method, of class NumberPartsEdit.
//     */
//    @org.junit.Test
//    public void testCollapsePhoneNumber() throws Exception{
//    }
    
}
