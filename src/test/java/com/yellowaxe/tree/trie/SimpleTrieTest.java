package com.yellowaxe.tree.trie;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: kal
 * Date: 9/17/13
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTrieTest {

    private static final Logger LOG = Logger.getLogger(SimpleTrieTest.class);

    @Test
    public void test_add() throws Exception {
        SimpleTrie trie = new SimpleTrie();
        trie.add("BE");
        trie.add("BEAR");
        trie.add("BEER");

        LOG.debug(trie.findAllByPrefix("BE"));
    }

}
