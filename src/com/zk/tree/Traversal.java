package com.zk.tree;

import com.zk.stack.LLStack;

public class Traversal {

    public void preOrder(BinaryTreeNode root) {
        if (root != null) {
            System.out.println(root.getData());
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public void preOrderNonRecursive(BinaryTreeNode root) {
        LLStack S = new LLStack();
        while (true) {
            while (root != null) {
                System.out.println(root.getData());
                S.push(root);
                root = root.getLeft();
            }
            if (S.isEmpty()) break;
            root = (BinaryTreeNode) S.pop();
            root = root.getRight();
        }
    }

    public void inOrder(BinaryTreeNode root) {
        if (root != null) {
            inOrder(root.getLeft());
            System.out.println(root.getData());
            inOrder(root.getRight());
        }
    }

    public void inOrderNonRecursive(BinaryTreeNode root) {
        LLStack S = new LLStack();
        while (true) {
            while (root != null) {
                S.push(root);
                root = root.getLeft();
            }
            if (S.isEmpty()) break;
            root = (BinaryTreeNode) S.pop();
            System.out.println(root.getData());
            root = root.getRight();
        }
    }

    public void postOrder(BinaryTreeNode root) {
        if (root != null) {
            postOrder(root.getLeft());
            postOrder(root.getRight());
            System.out.println(root.getData());
        }
    }

    public void postOrderNonRecursive(BinaryTreeNode root) {
        LLStack S = new LLStack();
        while (true) {
            if (root != null) {
                S.push(root);
                root = root.getLeft();
            }else {
                if (S.isEmpty()) {
                    break;
                }else if (((BinaryTreeNode)S.top()).getRight() == null){
                    root = (BinaryTreeNode) S.pop();
                    System.out.println(root.getData());
                    if (((BinaryTreeNode)S.top()).getRight() == root) {
                        System.out.println(((BinaryTreeNode) S.top()).getData());
                        S.pop();
                    }

                }
                root = ((BinaryTreeNode)S.pop()).getRight();
            }
        }
    }
}
