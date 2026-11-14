package com.spa.leetcode.easy;

public class DefangingAnIPAddress {

    // https://leetcode.com/problems/defanging-an-ip-address/submissions/1161846495/

    //
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
