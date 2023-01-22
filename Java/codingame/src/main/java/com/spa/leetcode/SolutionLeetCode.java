package com.spa.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SolutionLeetCode {

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /** Definition for a binary tree node. */
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int climbStairs1(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        Map<Integer, Set<String>> known = new HashMap<>(
                Map.of(1, Set.of("1"), 2, Set.of("11", "2"), 3, Set.of("111", "21", "12")));
        climbStairs1Utils(n, 4, known);
        return known.get(n).size();
    }

    public void climbStairs1Utils(int n, int i, Map<Integer, Set<String>> known) {
        if (known.containsKey(i)) {
            return;
        }
        if (i <= n) {
            Set<String> ways = new HashSet<>();
            ways.addAll(known.get(i - 1).stream().map(seq -> seq + "1").collect(Collectors.toSet()));
            ways.addAll(known.get(i - 1).stream().map(seq -> "1" + seq).collect(Collectors.toSet()));
            ways.addAll(known.get(i - 2).stream().map(seq -> "2" + seq).collect(Collectors.toSet()));
            ways.addAll(known.get(i - 2).stream().map(seq -> seq + "2").collect(Collectors.toSet()));
            known.put(i, ways);
            climbStairs1Utils(n, i + 1, known);
        }
    }

    public List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        result.add("");
        for (int index = 1; index <= n; index++) {
            if (index % 15 == 0) {
                result.add("FizzBuzz");
            } else if (index % 5 == 0) {
                result.add("Buzz");
            } else if (index % 3 == 0) {
                result.add("Fizz");
            } else {
                result.add(String.valueOf(index));
            }
        }

        return result;
    }

    public ListNode middleNode(ListNode head) {

        ListNode current = head;
        int size = 0;
        do {
            size++;
            current = current.next;
        } while (current != null);
        int middle = size / 2;
        int i = 0;
        while (i < middle) {
            head = head.next;
            i++;
        }
        return head;
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineCounts = new int[26];
        Arrays.fill(magazineCounts, 0);
        int[] ransomNoteCounts = new int[26];
        Arrays.fill(ransomNoteCounts, 0);

        int[] magazineAsInts = magazine.chars().map(c -> c - 97).toArray();
        int[] ransomNoteAsInts = ransomNote.chars().map(c -> c - 97).toArray();

        for (int magazineLetter : magazineAsInts) {
            magazineCounts[magazineLetter]++;
        }

        for (int ransomLetter : ransomNoteAsInts) {
            ransomNoteCounts[ransomLetter]++;
        }

        for (int i = 0; i < ransomNoteCounts.length; i++) {
            if (magazineCounts[i] < ransomNoteCounts[i]) {
                return false;
            }
        }

        return true;
    }

    public int numberOfSteps1(int num) {

        Map<Integer, Integer> known = new HashMap<>(Map.of(1, 1, 2, 2, 3, 3, 4, 3));
        if (known.containsKey(num)) {
            return known.get(num);
        } else if (num % 2 == 0) {
            return 1 + numberOfSteps(num / 2);
        } else if (num % 2 == 1) {
            return 1 + numberOfSteps(num - 1);
        }
        return 0;

    }

    public int numberOfSteps(int num) {

        Map<Integer, Integer> known = new HashMap<>(Map.of(1, 1, 2, 2, 3, 3, 4, 3));
        if (known.containsKey(num)) {
            return known.get(num);
        } else if (num % 2 == 0) {
            return 1 + numberOfSteps(num / 2);
        } else if (num % 2 == 1) {
            return 1 + numberOfSteps(num - 1);
        }
        return 0;

    }

    /**
     * https://leetcode.com/problems/find-pivot-index/
     *
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        // reduce l-to-r

        int[] lr = new int[nums.length];
        int[] rl = new int[nums.length];

        for (int index = 1; index < nums.length; index++) {
            lr[index] = lr[index - 1] + nums[index - 1];

        }
        rl[nums.length - 1] = 0;
        for (int index = nums.length - 2; index >= 0; index--) {
            rl[index] = rl[index + 1] + nums[index + 1];
        }

        for (int index = 0; index < nums.length; index++) {
            if (rl[index] == lr[index]) {
                return index;
            }
        }

        return -1;
    }

    public boolean isIsomorphic(String s, String t) {
        return isIsomorphic(s, t, new HashMap<>());
    }

    public boolean isIsomorphic(String s, String t, Map<String, String> transformations) {
        if (s.isEmpty() && t.isEmpty()) {
            return true;
        }

        String currentSLetter = s.substring(0, 1);
        String currentTLetter = t.substring(0, 1);

        if (transformations.containsKey(currentSLetter)
                && !transformations.get(currentSLetter).equals(currentTLetter)) {
            return false;
        }

        if (!transformations.containsKey(currentSLetter) && !transformations.containsValue(currentTLetter)) {
            transformations.put(currentSLetter, currentTLetter);
        }
        if (!transformations.containsKey(currentSLetter) && transformations.containsValue(currentTLetter)) {
            return false;
        }
        return isIsomorphic(s.substring(1), t.substring(1), transformations);
    }

    public boolean isSubsequence(String s, String t) {
        if (t.isEmpty() && !s.isEmpty()) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        if (s.substring(0, 1).equals(t.substring(0, 1))) {
            return isSubsequence(s.substring(1), t.substring(1));
        }
        if (!s.substring(0, 1).equals(t.substring(0, 1))) {
            return isSubsequence(s, t.substring(1));
        }

        return false;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list2 == null && list1 != null) {
            return list1;
        }

        return mergeTwoListsImpl(list1, list2, null, null);
    }

    public ListNode mergeTwoListsImpl(ListNode list1, ListNode list2, ListNode currentNodeInResult,
            ListNode resultHead) {
        if (list1 == null && list2 == null) {
            return resultHead;
        }
        if (list1 == null) {
            currentNodeInResult.next = list2;
            return resultHead;
        }
        if (list2 == null) {
            currentNodeInResult.next = list1;
            return resultHead;
        }

        if (list1.val <= list2.val) {
            ListNode nextList1;
            if (resultHead == null) {
                currentNodeInResult = list1;
                nextList1 = list1.next;
                currentNodeInResult.next = null;
                resultHead = currentNodeInResult;
            } else {
                currentNodeInResult.next = list1;
                nextList1 = list1.next;
                currentNodeInResult.next.next = null;
                currentNodeInResult = currentNodeInResult.next;
            }

            return mergeTwoListsImpl(nextList1, list2, currentNodeInResult, resultHead);
        } else {
            ListNode nextList2;
            if (currentNodeInResult == null) {
                currentNodeInResult = list2;
                nextList2 = list2.next;
                currentNodeInResult.next = null;
                resultHead = currentNodeInResult;
            } else {
                currentNodeInResult.next = list2;
                nextList2 = list2.next;
                currentNodeInResult.next.next = null;
                currentNodeInResult = currentNodeInResult.next;
            }
            return mergeTwoListsImpl(list1, nextList2, currentNodeInResult, resultHead);
        }

    }

    public ListNode reverseList(ListNode head) {
        // 1 -> 7 -> 3 ->
        // <-1 , 7 -> 3 ->
        // <- 1 <- 7, 3 ->

        return reverseList(head, null);
    }

    public ListNode reverseList(ListNode head, ListNode resultHead) {
        // 1 -> 7 -> 3 ->
        // <-1 , 7 -> 3 ->
        // <- 1 <- 7, 3 ->

        if (head == null) {
            return resultHead;
        }

        if (resultHead == null) {
            ListNode newInitialHead = head.next;
            head.next = null;
            return reverseList(newInitialHead, head);
        }

        ListNode newInitialHead = head.next;
        head.next = resultHead;
        return reverseList(newInitialHead, head);
    }

    /**
     * https://medium.com/@tuvo1106/the-tortoise-and-the-hare-floyds-algorithm-87badf5f7d41
     * 
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        boolean cyclic = false;
        while (hare != null) {
            if (hare.next != null) {
                hare = hare.next.next;
            } else {
                hare = null;
            }

            tortoise = tortoise.next;

            if (tortoise == hare) {
                cyclic = true;
                break;
            }

        }

        if (cyclic) {
            tortoise = head;
            while (tortoise != hare && hare != null) {
                hare = hare.next;
                tortoise = tortoise.next;
            }
            return hare;
        }
        return null;
    }

    public record Stock(int day, int value) {
    }

    public int maxProfitO2(int[] prices) {
        // Stock[] stocks = IntStream.range(0, prices.length).mapToObj(index -> new
        // Stock(index + 1, prices[index]))
        // .sorted(Comparator.comparing(Stock::value)).<Stock>toArray(Stock[]::new);
        int profit = 0;
        for (int index = 0; index < prices.length; index++) {
            for (int j = index + 1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - prices[index]);
            }
        }
        return profit;
    }

    /**
     * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * 
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int[] profits = new int[prices.length];
        for (int index = 0; index < prices.length - 1; index++) {
            profits[index] = prices[index + 1] - prices[index];
        }

        int currentMaxSum = 0;
        int currentPositiveSum = 0;
        for (var p : profits) {
            currentPositiveSum += p;
            if (currentPositiveSum < 0) {
                currentPositiveSum = 0;
            }
            currentMaxSum = Math.max(currentMaxSum, currentPositiveSum);
        }
        return currentMaxSum;
    }

    public int longestPalindrome(String s) {
        var lettersCount = s.chars().<String>mapToObj(Character::toString)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        long l = 0;
        int rest = 0;
        for (var letterCount : lettersCount.entrySet()) {
            if (letterCount.getValue() % 2 == 0) {
                l += letterCount.getValue();
            } else {
                l += letterCount.getValue() - 1;
                rest++;
            }
        }
        if (rest > 0) {
            return (int) l + 1;
        }
        return (int) l;
    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        visitDFS(root, result);
        return result;
    }

    public void visitDFS(Node root, List<Integer> visited) {
        if (root == null) {
            return;
        }
        visited.add(root.val);
        if (root.children != null) {
            for (var child : root.children) {
                visitDFS(child, visited);
            }
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> visited = new ArrayList<>();
        visitBFS(root, visited, 0);
        return visited;
    }

    public void visitBFS(TreeNode root, List<List<Integer>> visited, int level) {
        if (root == null) {
            return;
        }

        if (level < visited.size()) {
            visited.get(level).add(root.val);
        } else {
            visited.add(new ArrayList<>());
            visited.get(level).add(root.val);
        }

        visitBFS(root.left, visited, level + 1);
        visitBFS(root.right, visited, level + 1);
    }

    public int search(int[] nums, int target) {
        var index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return -1;
        }
        return index;
    }

    boolean isBadVersion(int version) {
        if (version >= 1702766719) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * https://leetcode.com/problems/first-bad-version/
     * 
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        return (int) firstBadVersion(0, n, n);

    }

    public long firstBadVersion(long start, long end, long lastBadVersion) {
        if (start > end) {
            return -1;
        }
        if (start == end && isBadVersion((int) start)) {
            return start;
        } else if (start == end) {
            return lastBadVersion;
        }

        if (start + 1 == end && isBadVersion((int) start)) {
            return start;
        } else if (start + 1 == end && isBadVersion((int) end)) {
            return end;
        } else if (start + 1 == end) {
            return lastBadVersion;
        }

        long middle = (start + end) / 2;

        if (isBadVersion((int) middle)) {
            return firstBadVersion(start, middle - 1, middle);
        } else {
            return firstBadVersion(middle + 1, end, lastBadVersion);
        }

    }

    /**
     * https://leetcode.com/problems/validate-binary-search-tree/
     * 
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        List<Integer> visited = new ArrayList<>();
        isValidBST(root, visited);

        for (int i = 0; i < visited.size() - 1; i++) {
            if (visited.get(i) >= visited.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public void isValidBST(TreeNode root, List<Integer> visited) {
        if (root == null) {
            return;
        }
        isValidBST(root.left, visited);
        visited.add(root.val);
        isValidBST(root.right, visited);
    }

    /**
     * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
     * 
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // if p and q are at the left of the current root
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // if p and q are at the right of the current root
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // if p and q are on different sides of the root
        if ((p.val < root.val && q.val > root.val) || (p.val > root.val && q.val < root.val)) {
            return root;
        }

        // if p is the root
        if (p.val == root.val) {
            return p;
        }

        // if q is the root
        if (q.val == root.val) {
            return q;
        }
        return null;
    }

    /**
     * https://leetcode.com/problems/flood-fill/
     * 
     * @param image
     * @param sr
     * @param sc
     * @param color
     * @return
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        floodFill(image, sr, sc, image[sr][sc], color);
        return image;
    }

    public void floodFill(int[][] image, int sr, int sc, int startingPixelColor, int color) {
        if (sr >= image.length || sr < 0) {
            return;
        }
        if (sc >= image[0].length || sc < 0) {
            return;
        }
        if (image[sr][sc] == color) {
            return;
        }

        if (image[sr][sc] == startingPixelColor) {
            image[sr][sc] = color;
            floodFill(image, sr + 1, sc, startingPixelColor, color);
            floodFill(image, sr - 1, sc, startingPixelColor, color);
            floodFill(image, sr, sc + 1, startingPixelColor, color);
            floodFill(image, sr, sc - 1, startingPixelColor, color);
        }

    }

    public int numIslands(char[][] grid) {
        Map<String, Set<String>> connexions = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                String currentPlace = "%d-%d".formatted(i, j);
                Set<String> nextPlaces = new HashSet<>();
                if (i + 1 < grid.length && grid[i][j] == grid[i + 1][j] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i + 1, j));
                }
                if (j + 1 < grid[i].length && grid[i][j] == grid[i][j + 1] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i, j + 1));
                }

                if (j - 1 >= 0 && grid[i][j] == grid[i][j - 1] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i, j - 1));
                }

                if (i - 1 >= 0 && grid[i][j] == grid[i - 1][j] && grid[i][j] == '1') {
                    nextPlaces.add("%d-%d".formatted(i - 1, j));
                }

                if (grid[i][j] == '1') {
                    connexions.put(currentPlace, nextPlaces);
                }

            }
        }

        int islandsCount = 0;
        Set<String> visited = new HashSet<>();

        for (var connexion : connexions.entrySet()) {
            if (!visited.contains(connexion.getKey())) {
                islandsCount++;
                visitFrom(connexion.getKey(), visited, connexions);
            }
        }

        return islandsCount;
    }

    private void visitFrom(String startingPoint, Set<String> visited, Map<String, Set<String>> connexions) {
        if (visited.contains(startingPoint)) {
            return;
        }
        visited.add(startingPoint);

        if (!connexions.containsKey(startingPoint)) {
            return;
        }
        for (String neighbor : connexions.get(startingPoint)) {
            visitFrom(neighbor, visited, connexions);
        }
    }

    /**
     * https://leetcode.com/problems/climbing-stairs/
     * 
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        return climbStairs(n, 2, 2, 1);
    }

    public int climbStairs(int n, int i, int a, int b) {
        if (i == n) {
            return a;
        }
        return climbStairs(n, i + 1, a + b, a);
    }

    /**
     * https://leetcode.com/problems/unique-paths/
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i - 1 >= 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if (j - 1 >= 0) {
                    grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[m-1][n-1];
    }

}
