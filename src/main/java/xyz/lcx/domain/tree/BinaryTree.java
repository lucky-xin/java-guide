package xyz.lcx.domain.tree;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树
 *
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-13
 */
@Data
public class BinaryTree<T extends Comparable<T>> {

    /**
     * 根节点
     */
    private TreeNode<T> root;

    void addNode(T t) {
        TreeNode<T> node = new TreeNode<>(null, null, null, t);
        if (root == null) {
            root = node;
            return;
        }
        TreeNode<T> parent = root;
        while (parent != null) {
            int diff = t.compareTo(parent.getData());
            TreeNode<T> pp = parent;
            if ((parent = parent.getLeft() == null ? parent.getRight() : parent.getLeft()) == null) {
                if (diff < 0) {
                    pp.setLeft(node);
                } else {
                    pp.setRight(node);
                }
            }
        }
    }

    public List<T> preOrder() {
        List<T> elements = new LinkedList<>();
        preOrder(elements, this.root);
        return elements;
    }

    public void preOrder(List<T> elements, TreeNode<T> next) {
        if (next == null) {
            return;
        }
        elements.add(next.getData());
        preOrder(elements, next.getLeft());
        preOrder(elements, next.getRight());
    }

    public List<T> middleOrder() {
        List<T> elements = new LinkedList<>();
        middleOrder(elements, this.root);
        return elements;
    }

    public void middleOrder(List<T> elements, TreeNode<T> next) {
        if (next == null) {
            return;
        }
        middleOrder(elements, next.getLeft());
        elements.add(next.getData());
        middleOrder(elements, next.getRight());
    }

    public List<T> postOrder() {
        List<T> elements = new LinkedList<>();
        postOrder(elements, this.root);
        return elements;
    }

    public void postOrder(List<T> elements, TreeNode<T> next) {
        if (next == null) {
            return;
        }
        postOrder(elements, next.getLeft());
        elements.add(next.getData());
        postOrder(elements, next.getRight());
    }

    public List<T> levelOrder() {
        List<T> elements = new LinkedList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        for (TreeNode<T> next = queue.poll(); next != null; next = queue.poll()) {
            elements.add(next.getData());
            if (next.getLeft() != null) {
                queue.offer(next.getLeft());
            }
            if (next.getRight() != null) {
                queue.offer(next.getRight());
            }
        }
        return elements;
    }

    /**
     * 返回以该节点为根节点的二叉树的高度，如果不是二叉搜索树了则返回-1
     *
     * @param next
     * @return
     */
    public int depth(TreeNode<T> next) {
        if (next == null) {
            return 0;
        }
        int depthL = depth(next.getLeft());
        int depthR = depth(next.getRight());
        if (Math.abs(depthL - depthR) > 1) {
            return -1;
        }
        return 1 + Math.max(depthL, depthR);
    }

}
