package com.interview.trie;

import java.util.*;

// Applications - auto complete, Spell checking, word break problem

// https://docs.google.com/document/d/1ZhnyO0i24_MG4jrLGj5cIKVFIwwM4Q_7hWgX1T9L8kQ/edit

public class Trie {

    private static Node root;
    private static String ans = "";

    public Trie(){}

    public Trie(List<String> words) {
        root = new Node();
        for (String word : words)
            insert(word);
    }

    public void insert(String word) {       // Time complexity - O(L) L is length of string
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new Node();
            }
            curr = curr.children[index];
        }
        curr.isWord = true;
    }

    public static boolean search(String word) {     // Time complexity - O(L) L is length of string
        Node curr = root;
        for(int i=0; i<word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if(curr.children[index] == null)
                return false;

            if(i == word.length()-1 && !curr.isWord)
                return false;

            curr = curr.children[index];
        }
        return true;
    }

    public static List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        Node node = root;
        StringBuffer curr = new StringBuffer();
        for (char c : prefix.toCharArray()) {
            node = node.children[c - 'a'];
            if (node == null)
                return list;
            curr.append(c);
        }
        suggestHelper(node, list, curr);
        return list;
    }

    private static void suggestHelper(Node curr, List<String> list, StringBuffer tmp) {
        if (curr == null || curr.children == null)
            return;

        if (curr.isWord) {
            list.add(tmp.toString());
        }

        for (int i=0; i<curr.children.length; i++) {
            suggestHelper(curr.children[i], list, tmp.append((char) ('a' + i)));
            tmp.setLength(tmp.length() - 1);
        }
    }

    public static void longestWordWithAllPrefix(Node root, StringBuilder tmp){
        if(root == null) {
            return;
        }

        for(int i=0; i<26; i++) {
            if(root.children[i] != null && root.isWord) {
                tmp.append((char) ('a' + i));
                if(tmp.length() > ans.length())
                    ans = tmp.toString();

                longestWordWithAllPrefix(root.children[i], tmp);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }

    public static boolean wordStartsWith(String prefix) {
        Node curr = root;
        for(int i=0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if(curr.children[index] == null)
                return false;

            curr = curr.children[index];
        }
        return true;
    }

    public static int countUniqueSubstrings(String str) {

        // all prefix of all suffix
        // all suffix of all prefix

        // total nodes of trie = count of unique prefix

        // find all suffix of the string
        // create a trie using all suffix
        // count nodes of trie

        List<String> suffixList = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            suffixList.add(str.substring(i));
        }

        Trie trie = new Trie(suffixList);
        Node curr = root;
        return countNodes(curr);

    }

    private static int countNodes(Node root) {
        int count = 0;

        if(root == null)
            return count;

        for(int i=0; i<26; i++){
            if(root.children[i] != null) {
                count += countNodes(root.children[i]);
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "dog", "hell", "cat", "a", "hel","help","helps","helping");
        Trie trie = new Trie(words);

        System.out.println(suggest("he"));
//        System.out.println(countUniqueSubstrings("apple"));
//        System.out.println(wordStartsWith("co"));
//        longestWordWithAllPrefix(root, new StringBuilder(""));
//        System.out.println(ans);
    }

}

class Node {
    Node[] children;
    boolean isWord;

    public Node() {
        children = new Node[26];
        isWord = false;
    }
}