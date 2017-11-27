package com.dh.springboot;

import org.junit.Test;

import static org.junit.Assert.*;

public class TextServiceImplTest {
    TextServiceImpl textService = new TextServiceImpl();

    @Test
    public void testValid1() {
        assertEquals("?šÁm es kaj ,jOha", textService.customReverse("Ahoj, jak se máš?"));
    }

    @Test
    public void testValid2() {
        assertEquals(".NjaF iM ej", textService.customReverse("Je mi fajn."));
    }

    @Test
    public void testEmpty() {
        assertEquals("", textService.customReverse(""));
    }

    @Test 
    public void testNull() {
        assertNull(textService.customReverse(null));
    }

    @Test 
    public void testShrinkSpaces() {
        assertEquals("zx dcb", textService.customReverse("bcd   xz"));
    }
    
    @Test 
    public void testFirstSpace() {
        assertEquals("zx dcb ", textService.customReverse(" bcd   xz"));
    }
    
    @Test 
    public void testLastSpace() {
        assertEquals(" zx dcb", textService.customReverse("bcd   xz "));
    }
}

