package com.spa.leetcode.easy;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenerateTagForVideoCaption {

    // https://leetcode.com/problems/generate-tag-for-video-caption/submissions/2126509455/

    public String generateTag(String caption) {
        String tag = Arrays.stream(caption.split(" "))
            .filter(Predicate.not(String::isBlank))
            .map(word -> word.replaceAll("\\W", ""))
            .map(word -> word.substring(0, 1).toUpperCase()+ word.substring(1).toLowerCase())
            .collect(Collectors.joining());
        if(tag.isEmpty()){
            return "#";
        }
        return "#"+ tag.substring(0, 1).toLowerCase()+tag.substring(1, Math.min(99, tag.length()));
    }
}
