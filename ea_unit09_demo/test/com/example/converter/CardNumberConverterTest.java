/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.converter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class CardNumberConverterTest {
    
    CardNumberConverter cardNumberConverter;
    
    public CardNumberConverterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cardNumberConverter = new CardNumberConverter();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAsObject method, of class CardNumberConverter.
     */
    @Test
    public void testGetAsObject() {
        final String case1 = "1234-5678-9123-4567";
        final String case2 = "1234 5678 9123 4567";
        final String case3 = "1234567891234567";
        
        String r1 = (String) cardNumberConverter.getAsObject(null, null, case1);
        System.out.println(r1);
        assertEquals(case3, r1);
        String r2 = (String) cardNumberConverter.getAsObject(null, null, case2);
        System.out.println(r2);
        assertEquals(case3, r2);
        String r3 = (String) cardNumberConverter.getAsObject(null, null, case3);
        System.out.println(r3);
        assertEquals(case3, r3);
        
    }

    /**
     * Test of getAsString method, of class CardNumberConverter.
     */
    @Test
    public void testGetAsString() {
        final String case1 = "1234567891234567";
        final String target = "1234-5678-9123-4567";
        String r1 = cardNumberConverter.getAsString(null, null, case1);
        System.out.println(r1);
        assertEquals(target, r1);
    }
    
}
