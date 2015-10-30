package com.yellowaxe.tree.trie;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: kal
 * Date: 9/17/13
 * Time: 8:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTrie {

    private TrieNode root = new TrieNode(Character.valueOf('\0'), false);

    public void add(String word) {
        if (word == null) return;
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            Character c = Character.valueOf(word.charAt(i));
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode(c, i == length - 1));
            }

            node = node.children.get(c);
        }
    }

    public Set<String> findAllByPrefix(String prefix) {
        Set<String> result = new LinkedHashSet<String>();

        if (prefix == null || prefix.isEmpty()) return result; // too short
        TrieNode node = root;
        int length = prefix.length();

        for (int i = 0; i < length; i++) {
            Character c = Character.valueOf(prefix.charAt(i));
            node = node.children.get(c);
            if (node == null) {
                return result;
            }
        }

        findAllByPrefix(prefix, node, result);

        return result;
    }

    private void findAllByPrefix(String prefix, TrieNode node, Set<String> result) {

        if (node.complete) {
            result.add(prefix);
        }

        for (TrieNode child : node.children.values()) {
            findAllByPrefix(prefix + child.character, child, result);
        }

    }

    public static class TrieNode {

        private final Character character;
        private final boolean complete;
        private Map<Character, TrieNode> children = new LinkedHashMap<Character, TrieNode>();

        public TrieNode(Character character, boolean complete) {
            this.character = character;
            this.complete = complete;
        }
    }
}
