package com.spa.leetcode.easy;

public class DefangingAnIPAddress {

    //
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
