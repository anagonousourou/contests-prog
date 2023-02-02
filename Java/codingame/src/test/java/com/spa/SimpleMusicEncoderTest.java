package com.spa;

import com.spa.codewars.SimpleMusicEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleMusicEncoderTest {

    @Test
    public void basicTests() {
        test("2 identical numbers",new int[] {1,2,2,3},"1,2*2,3");
        test("3 consecutive numbers, ascending",new int[] {1,3,4,5,7},"1,3-5,7");
        test("3 consecutive numbers, descending",new int[] {1,5,4,3,7},"1,5-3,7");
        test("3 numbers with same interval, descending",new int[] {1,10,8,6,7},"1,10-6/2,7");
        test("3 consecutive numbers, descending then ascending",new int[] {1,5,4,3,4,5,7},"1,5-3,4,5,7");
        test("",new int[] {2,2,2,3,4,5,6,9},"2*3,3-6,9");
        test("",new int[] {1,1,2,3,4,5,7,9},"1*2,2-5,7,9");
        test("",new int[] {140,65,3,0,-3,},"140,65,3--3/3");

    }

    private void test(String description,int[] raw,String encoded) {
        assertEquals(encoded,new SimpleMusicEncoder().compress(raw),description);
    }
}
