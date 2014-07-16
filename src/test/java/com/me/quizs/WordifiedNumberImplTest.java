/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.quizs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JRDO
 */
public class WordifiedNumberImplTest {

    public WordifiedNumberImplTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void wordifiedWordReferenceTest() throws Exception {
        WordifiedNumber wordifiedNumber = new WordifiedNumberImpl();
        assertEquals("one", wordifiedNumber.toWords(1));
        assertEquals("twenty one", wordifiedNumber.toWords(21));
        assertEquals("one hundred and five", wordifiedNumber.toWords(105));
        assertEquals("one thousand and five", wordifiedNumber.toWords(1005)); 
        assertEquals("one hundred and ten thousand one hundred and five", wordifiedNumber.toWords(110105)); 
        assertEquals("one million and ninety nine", wordifiedNumber.toWords(1000099));
        assertEquals("one million one hundred", wordifiedNumber.toWords(1000100));
        assertEquals("fifty six million nine hundred and forty five thousand seven hundred and eighty one", wordifiedNumber.toWords(56945781));
    }
}
