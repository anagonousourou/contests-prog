package com.spa.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveSubFoldersFromTheFilesystem {

    // https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/submissions/1703504580/

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> validFolders = new ArrayList<>();
        validFolders.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            if(!folder[i].startsWith(validFolders.get(validFolders.size() - 1) + "/") ){
               validFolders.add(folder[i]);
            }
        }
        return validFolders;
    }
}
