package com.spa.codewars;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HowManyAreSmallerThanMeIITest {

    @Test
    public void initialTests() {
        assertArrayEquals(new int[]{4, 3, 2, 1, 0}, HowManyAreSmallerThanMeII.smaller(new int[]{5, 4, 3, 2, 1}));
        assertArrayEquals(new int[]{0, 0, 0}, HowManyAreSmallerThanMeII.smaller(new int[]{1, 2, 3}));
        assertArrayEquals(new int[]{1, 1, 0}, HowManyAreSmallerThanMeII.smaller(new int[]{1, 2, 0}));
        assertArrayEquals(new int[]{0, 1, 0}, HowManyAreSmallerThanMeII.smaller(new int[]{1, 2, 1}));
        var res = HowManyAreSmallerThanMeII.smaller(new int[]{1, 1, -1, 0, 0});
        System.out.println(Arrays.toString(res));
        assertArrayEquals(new int[]{3, 3, 0, 0, 0}, res);
        res = HowManyAreSmallerThanMeII.smaller(new int[]{5, 4, 7, 9, 2, 4, 4, 5, 6});
        System.out.println(Arrays.toString(res));
        assertArrayEquals(new int[]{4, 1, 5, 5, 0, 0, 0, 0, 0}, res);
        assertArrayEquals(new int[]{5, 2, 6, 6, 1, 1, 0, 0, 0, 0}, HowManyAreSmallerThanMeII.smaller(new int[]{5, 4, 7, 9, 2, 4, 1, 4, 5, 6}));
    }
}
