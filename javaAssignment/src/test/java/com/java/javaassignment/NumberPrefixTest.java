package com.java.javaassignment;

import java.util.*;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;


@RunWith(Parameterized.class)
public class NumberPrefixTest {

    enum Type {EVERYNUMBER, MOBILEPHONENUMBER}

    private NumberPrefix checkingPrefix;
    private StringBuilder phoneNumber;
    private boolean hasValidStart;
    private Type type;

    public NumberPrefixTest(Type type, StringBuilder phoneNumber, boolean hasValidStart) {
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.hasValidStart = hasValidStart;
    }

    @Before
    public void setUp() {
        checkingPrefix = new NumberPrefix();
    }

    @Parameters
    public static Collection<Object[]> testingData() {
        return Arrays.asList(new Object[][]{
                {Type.EVERYNUMBER, new StringBuilder("003856952"), true},
                {Type.EVERYNUMBER, new StringBuilder("69856952"), true},
                {Type.EVERYNUMBER, new StringBuilder("2556952"), true},
                {Type.EVERYNUMBER, new StringBuilder("72556952"), false},
                {Type.MOBILEPHONENUMBER, new StringBuilder("600954511"), true},
                {Type.MOBILEPHONENUMBER, new StringBuilder("60954511"), true},
                {Type.MOBILEPHONENUMBER, new StringBuilder("695451196"), true},
                {Type.MOBILEPHONENUMBER, new StringBuilder("605451196"), false},
                {Type.MOBILEPHONENUMBER, new StringBuilder("885451196"), false},
        });
    }

    /**
     * Test of checkNumberStart method, of class NumberPrefix.
     */
    @Test
    public void testCheckNumberStart() {
        if (type == Type.EVERYNUMBER) {
            assertTrue(hasValidStart == checkingPrefix.checkNumberStart(phoneNumber));
        }
    }

    /**
     * Test of checkMobilePhoneStart method, of class NumberPrefix.
     */
    @Test
    public void testCheckMobilePhoneStart() {
        if (type == Type.MOBILEPHONENUMBER) {
            assertTrue(hasValidStart == checkingPrefix.checkMobilePhoneStart(phoneNumber));
        }
    }

}
