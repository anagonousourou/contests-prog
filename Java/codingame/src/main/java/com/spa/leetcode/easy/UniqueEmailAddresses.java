package com.spa.leetcode.easy;

import java.util.Arrays;

public class UniqueEmailAddresses {

    // https://leetcode.com/problems/unique-email-addresses/submissions/1585668000/
    record EmailAddr(String localName, String domainName) {
    }


    public int numUniqueEmails(String[] emails) {
        return (int) Arrays.stream(emails)
            .map(UniqueEmailAddresses::parse).distinct()
            .count();
    }

    private static EmailAddr parse(String s) {
        int sepIndex = s.indexOf('@');
        String domainName = s.substring(sepIndex + 1);
        String localName = s.substring(0, sepIndex);
        int plusIndex = localName.indexOf('+');
        localName = plusIndex != -1 ? localName.substring(0, plusIndex) : localName;
        localName = localName.replace(".", "");

        return new EmailAddr(localName, domainName);
    }


}
