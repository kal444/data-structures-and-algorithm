package com.yellowaxe.tree.bst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: kal
 * Date: 9/16/13
 * Time: 9:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTreeTest {
    @Test
    public void test_getSize_for_empty_tree() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        assertEquals(0, bst.getSize());
    }

    @Test
    public void test_insert_1_value_size_increase_by_1() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.insert("A");
        assertEquals(1, bst.getSize());
    }

    @Test
    public void test_insert_2_value_size_increase_by_2() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.insert("A");
        bst.insert("B");
        assertEquals(2, bst.getSize());
    }

    @Test
    public void test_insert_3_value_size_increase_by_3() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        assertEquals(3, bst.getSize());
    }

    @Test
    public void test_insert_dup_value_is_accepted() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.insert("A");
        bst.insert("B");
        bst.insert("C");
        bst.insert("C");
        assertEquals(4, bst.getSize());
    }

    @Test
    public void test_inorder_traversal() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.insert("D");
        bst.insert("B");
        bst.insert("A");
        bst.insert("C");
        bst.insert("C");
        bst.insert("F");
        bst.insert("E");
        bst.insert("G");

        List<String> result = new ArrayList<String>();
        Iterator<String> stringIterator = bst.iteratorInOrder();
        while(stringIterator.hasNext()) {
            result.add(stringIterator.next());
        }

        List<String> expected = new ArrayList<String>();
        expected.add("A");
        expected.add("B");
        expected.add("C");
        expected.add("C");
        expected.add("D");
        expected.add("E");
        expected.add("F");
        expected.add("G");

        assertEquals(expected, result);
    }

    @Test
    public void test_inorder_traversal_empty() throws Exception {
        BinarySearchTree<String> bst = new BinarySearchTree<String>();
        bst.iteratorInOrder();
    }
}
