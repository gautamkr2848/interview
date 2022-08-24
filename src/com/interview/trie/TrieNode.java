package com.interview.trie;

public class TrieNode {
    boolean isEndOfWord;
    TrieNode[] children = new TrieNode[26];

    public TrieNode(){
        isEndOfWord = false;
        for (int i = 0; i < 26; i++)
            children[i] = null;
    }
}
