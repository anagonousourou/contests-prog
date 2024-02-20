package com.spa.leetcode;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MostPopularVideoCreator {

    //https://leetcode.com/problems/most-popular-video-creator/description/

    record Video(String id,String creator,long views){}

    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        List<Video> videos = IntStream.range(0, creators.length).mapToObj(i -> new Video(ids[i], creators[i], views[i]))
            .toList();
        Map<String, List<Video>> videosByCreator = videos.stream().collect(Collectors.groupingBy(Video::creator, Collectors.toList()));
        List<Map.Entry<String, Long>> creatorsViews = videosByCreator.entrySet().stream().map(entry -> Map.entry(entry.getKey(), entry.getValue().stream().mapToLong(Video::views).sum()))
            .sorted(Comparator.<Map.Entry<String, Long>>comparingLong(Map.Entry::getValue).reversed()).toList();
        int i = 1;
        while(i < creatorsViews.size() && Objects.equals(creatorsViews.get(i).getValue(), creatorsViews.get(0).getValue())) {
            i++;
        }
        var mostPopularCreator = creatorsViews.subList(0, i);

        return mostPopularCreator.stream().map(Map.Entry::getKey).map(creator ->
            List.of(creator, videosByCreator.get(creator).stream().max(Comparator.comparingLong(Video::views).thenComparing((a,b) -> b.id.compareTo(a.id))).get().id)
        ).toList();
    }
}
