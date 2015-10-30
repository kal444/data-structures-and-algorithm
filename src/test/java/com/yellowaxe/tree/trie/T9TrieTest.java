package com.yellowaxe.tree.trie;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: kal
 * Date: 9/17/13
 * Time: 10:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class T9TrieTest {

    private static final Logger LOG = Logger.getLogger(SimpleTrieTest.class);

    @Test
    public void test_add() throws Exception {
        T9Trie trie = new T9Trie();
        trie.add("AD");
        trie.add("BE");
        trie.add("CF");

        LOG.debug(trie.findAllByDigits("23"));
    }
}
