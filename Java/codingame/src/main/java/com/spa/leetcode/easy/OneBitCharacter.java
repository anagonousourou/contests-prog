package com.spa.leetcode.easy;

public class OneBitCharacter {


    // https://leetcode.com/problems/1-bit-and-2-bit-characters/submissions/1549627414/

    // https://leetcode.com/problems/1-bit-and-2-bit-characters/submissions/1549632389/
    public boolean isOneBitCharacter(int[] bits) {
        // return isOneBitCharacter(Arrays.stream(bits).mapToObj(String::valueOf).collect(Collectors.joining()));
        return isOneBitCharacter_v2(bits, 0);
    }

    private boolean isOneBitCharacter(String bits) {
        if (bits.isEmpty()) {
            return false;
        }
        if (bits.length() == 1) {
            return true;
        }
        if (bits.charAt(0) == '0') {
            return isOneBitCharacter(bits.substring(1));
        }
        if (bits.startsWith("10") || bits.startsWith("11")) {
            return isOneBitCharacter(bits.substring(2));
        }
        return false;

    }

    private boolean isOneBitCharacter_v2(int[] bits, int i) {
        if (bits.length == i) {
            return false;
        }
        if (bits.length - 1 == i) {
            return true;
        }
        if (bits[i] == 0) {
            return isOneBitCharacter_v2(bits, i + 1);
        }
        if (bits[i] == 1) {
            return isOneBitCharacter_v2(bits, i + 2);
        }
        return false;
    }
}
