package com.spa.codewars;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UrlShortenerTest {

    UrlShortener shortener = new UrlShortener();

    @Test
    public void test_two_different_URLs() {
        String shortURL1 = shortener.urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c3e");
        assertTrue( testFormat(shortURL1),"Wrong string format!");
        String shortURL2 = shortener.urlShortener("https://www.codewars.com/kata/5efae11e2d12df00331f91a6");
        assertTrue(testFormat(shortURL2),"Wrong string format!");
        assertEquals("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c3e", shortener.urlRedirector(shortURL1));
        assertEquals("https://www.codewars.com/kata/5efae11e2d12df00331f91a6", shortener.urlRedirector(shortURL2));
    }

    @Test
    public void test_same_URLs() {
        String shortURL1 = shortener.urlShortener("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f");
        assertTrue(testFormat(shortURL1),"Wrong string format!");
        String shortURL2 = shortener.urlShortener("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f");
        assertTrue(testFormat(shortURL2),"Wrong string format!");
        assertEquals(shortURL1, shortURL2,"Should work with same URLs");
        assertEquals("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f", shortener.urlRedirector(shortURL1));

        for (int i = 0; i < 100; i++) {
            shortURL1 = shortener.urlShortener("https://www.codewars.com/kata/5ef9c85dc41b4e000f9a645f"+i);
            System.out.println(shortURL1);
        }
    }

    private static boolean testFormat(String string) {
        return Pattern.matches("^short.ly\\/[a-z]{1,4}$", string);
    }
}
