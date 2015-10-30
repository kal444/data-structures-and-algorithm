package com.yellowaxe.tree.trie;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: kal
 * Date: 9/17/13
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */
public class T9Trie {

    private TrieNode root = new TrieNode(null);

    public void add(String word) {
        if (word == null) return;
        TrieNode node = root;
        int length = word.length();
        for (int i = 0; i < length; i++) {
            Character c = Character.valueOf(word.charAt(i));
            Integer key = Integer.valueOf(Letter.valueOf(c.toString()).number());
            if (!node.children.containsKey(key)) {
                node.addChild(key);
            }

            node = node.children.get(key);
        }

        node.add(word);
    }

    public Set<String> findAllByDigits(String digits) {
        Set<String> result = new LinkedHashSet<String>();

        if (digits == null || digits.isEmpty()) return result; // too short

        TrieNode node = root;
        int length = digits.length();

        for (int i = 0; i < length; i++) {
            Integer number = Integer.valueOf(String.valueOf(digits.charAt(i)));
            node = node.children.get(number);
            if (node == null) {
                return result;
            }
        }

        result.addAll(node.words);

        return result;
    }

    public static enum Letter {

        A(2), B(2), C(2),
        D(3), E(3), F(3),
        G(4), H(4), I(4),
        J(5), K(5), L(5),
        M(6), N(6), O(6),
        P(7), Q(7), R(7), S(7),
        T(8), U(8), V(8),
        W(9), X(9), Y(9), Z(9);

        private final int number;

        Letter(int number) {
            this.number = number;
        }

        public int number() {
            return number;
        }
    }

    public static class TrieNode {
        private final Integer number;
        private Map<Integer, TrieNode> children = new LinkedHashMap<Integer, TrieNode>();
        private Set<String> words = new LinkedHashSet<String>();

        public TrieNode(Integer number) {
            this.number = number;
        }

        public void add(String word) {
            words.add(word);
        }

        public TrieNode addChild(Integer number) {
            TrieNode node = new TrieNode(number);
            children.put(number, node);
            return node;
        }
    }
}
