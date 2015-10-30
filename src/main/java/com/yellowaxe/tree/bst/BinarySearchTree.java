package com.yellowaxe.tree.bst;

import org.apache.log4j.Logger;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Created with IntelliJ IDEA.
 * User: kal
 * Date: 9/16/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private final static Logger LOG = Logger.getLogger(BinarySearchTree.class);

    private Node<T> root;

    public BinarySearchTree() {
    }

    public void insert(T element) {
        root = insertInternal(null, root, element);
    }

    private Node<T> insertInternal(Node<T> parent, Node<T> node, T element) {
        if (node == null) {
            return new Node<T>(parent, element);
        } else {
            if (element.compareTo(node.getValue()) < 0) {
                node.setLeft(insertInternal(node, node.getLeft(), element));
            } else {
                node.setRight(insertInternal(node, node.getRight(), element));
            }
            return node;
        }
    }

    public int getSize() {
        return sizeInternal(root);
    }

    private int sizeInternal(Node<T> node) {
        if (node != null) {
            return sizeInternal(node.getLeft()) + 1 + sizeInternal(node.getRight());
        } else {
            return 0;
        }
    }

    public Iterator<T> iteratorInOrder() {
        return new Iterator<T>() {
            private final Deque<Node<T>> visitedNodes = new LinkedList<Node<T>>();

            private int size = sizeInternal(root);
            private Node<T> currentNode = depthFirst(root);

            private Node<T> depthFirst(Node<T> node) {
                if (node == null) {
                    return null;
                }

                if (node.getLeft() != null) {
                    // save the visited but un-used nodes
                    LOG.debug("visited nodes but saving for later: " + node.getValue());
                    visitedNodes.push(node);
                    return depthFirst(node.getLeft());
                } else {
                    return node;
                }
            }

            private void moveNodeToNext() {
                if (currentNode.getRight() != null) {
                    currentNode = depthFirst(currentNode.getRight());
                } else {
                    if (visitedNodes.isEmpty()) {
                        currentNode = null;
                    } else {
                        currentNode = visitedNodes.pop();
                    }
                }
            }

            @Override
            public boolean hasNext() {
                return size > 0;
            }

            @Override
            public T next() {
                T value = currentNode.getValue();
                size--;
                moveNodeToNext();
                return value;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override
            public void forEachRemaining(Consumer<? super T> action) {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static class Node<T> {
        private final Node<T> parent;
        private final T value;
        private Node<T> left;
        private Node<T> right;

        public Node(Node<T> parent, T value) {
            this.parent = parent;
            this.value = value;
        }

        public Node<T> getParent() {
            return parent;
        }

        public Node<T> getLeft() {
            return left;
        }

        public void setLeft(Node<T> left) {
            this.left = left;
        }

        public Node<T> getRight() {
            return right;
        }

        public void setRight(Node<T> right) {
            this.right = right;
        }

        public T getValue() {
            return value;
        }

    }
}
