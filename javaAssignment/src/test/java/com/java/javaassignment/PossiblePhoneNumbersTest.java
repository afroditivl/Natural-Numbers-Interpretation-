package com.java.javaassignment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class PossiblePhoneNumbersTest {

    private PossiblePhoneNumbers editor;
    private String phoneNumber;
    private String result;

    public PossiblePhoneNumbersTest(String phoneNumber, String result) {
        this.phoneNumber = phoneNumber;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testingData() {
        return Arrays.asList(new Object[][]{
                {"00306985689638", "VALID"},
                {"0030698568963", "INVALID"},
                {"00302885689638", "VALID"},
                {"0030285689638", "INVALID"},
                {"6985689638", "VALID"},
                {"6085689638", "INVALID"},
                {"2985689638", "VALID"},
                {"285689638", "INVALID"}
        });
    }

    @Before
    public void setUp() throws Exception {
        editor = new PossiblePhoneNumbers();
    }

    @Test
    public void checkForValidPhoneNumbers() {
        String returnedString = editor.checkForValidPhoneNumbers(phoneNumber);
        if(result.equals("INVALID")){
            assertTrue(returnedString.contains("INVALID"));
        }else{
            assertTrue(returnedString.contains("VALID"));
        }
    }
}