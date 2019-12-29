package com.dotwait.structure;

import com.dotwait.structure.entity.BSTNode;

import java.util.List;

/**
 * 二叉搜索树
 *
 * @author DotWait
 * @Date 2019-12-29
 */
public class BinarySearchTree {
    /**
     * 根节点
     */
    private BSTNode root;

    public BSTNode getRoot() {
        return root;
    }

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(BSTNode root) {
        this.root = root;
    }

    public BinarySearchTree(List<BSTNode> nodes){
        nodes.forEach(this::insert);
    }

    /**
     * 先序遍历——递归实现
     */
    public void preOrderTraversal() {
        preOrderTraversal(root);
    }

    /**
     * 先序遍历——递归实现
     *
     * @param node 节点
     */
    public void preOrderTraversal(BSTNode node) {
        if (node != null) {
            visit(node);
            preOrderTraversal(node.getLeftChild());
            preOrderTraversal(node.getRightChild());
        }
    }

    public void preOrderTraversalIteration() {

    }

    public void preOrderTraversalIteration(BSTNode node) {

    }

    /**
     * 中序遍历——递归实现
     */
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    /**
     * 中序遍历——递归实现
     *
     * @param node 节点
     */
    public void inOrderTraversal(BSTNode node) {
        if (node != null) {
            inOrderTraversal(node.getLeftChild());
            visit(node);
            inOrderTraversal(node.getRightChild());
        }
    }

    /**
     * 后序遍历——递归实现
     */
    public void postOrderTraversal() {
        postOrderTraversal(root);
    }

    /**
     * 后序遍历——递归实现
     *
     * @param node 节点
     */
    public void postOrderTraversal(BSTNode node) {
        if (node != null) {
            postOrderTraversal(node.getLeftChild());
            postOrderTraversal(node.getRightChild());
            visit(node);
        }
    }

    /**
     * 访问节点
     *
     * @param node 节点
     */
    public void visit(BSTNode node) {
        System.out.println(node.getKey());
    }

    /**
     * 查找某个key的节点——递归实现
     *
     * @param key 关键字
     * @return 节点
     */
    public BSTNode search(Integer key) {
        return search(root, key);
    }

    /**
     * 查找某个key的节点——递归实现
     *
     * @param node 节点
     * @param key  关键字
     * @return 节点
     */
    private BSTNode search(BSTNode node, Integer key) {
        if (node == null || node.getKey().equals(key)) {
            return node;
        }
        if (node.getKey() > key) {
            return search(node.getLeftChild(), key);
        } else {
            return search(node.getRightChild(), key);
        }
    }

    /**
     * 查找某个key的节点——迭代实现
     *
     * @param key 节点
     * @return 节点
     */
    public BSTNode searchIteration(Integer key) {
        return searchIteration(root, key);
    }

    /**
     * 查找某个key的节点——迭代实现
     *
     * @param node 节点
     * @param key  关键字
     * @return 节点
     */
    private BSTNode searchIteration(BSTNode node, Integer key) {
        while (node != null && !node.getKey().equals(key)) {
            if (node.getKey() > key) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return node;
    }

    /**
     * 获取最小节点
     *
     * @return 节点
     */
    public BSTNode minimum() {
        return minimum(root);
    }

    /**
     * 获取最小节点
     *
     * @param node 节点
     * @return 节点
     */
    public BSTNode minimum(BSTNode node) {
        if (node == null) {
            return null;
        }
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
        }
        return node;
    }

    /**
     * 获取最大节点
     *
     * @return 节点
     */
    public BSTNode maximum() {
        return maximum(root);
    }

    /**
     * 获取最大节点
     *
     * @param node 节点
     * @return 节点
     */
    public BSTNode maximum(BSTNode node) {
        if (node == null) {
            return null;
        }
        while (node.getRightChild() != null) {
            node = node.getRightChild();
        }
        return node;
    }

    /**
     * 获取指定节点的后继节点
     *
     * @param node 节点
     * @return 节点
     */
    public BSTNode successor(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.getRightChild() != null) {
            return minimum(node.getRightChild());
        }
        BSTNode parent = node.getParent();
        while (parent != null && node.equals(parent.getRightChild())) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    /**
     * 获取指定节点的前驱节点
     *
     * @param node 节点
     * @return 节点
     */
    public BSTNode predecessor(BSTNode node) {
        if (node == null) {
            return null;
        }
        if (node.getLeftChild() != null) {
            return maximum(node.getLeftChild());
        }
        BSTNode parent = node.getParent();
        while (parent != null && node.equals(parent.getLeftChild())) {
            node = parent;
            parent = parent.getParent();
        }
        return parent;
    }

    /**
     * 插入节点
     *
     * @param node 节点
     */
    public void insert(BSTNode node) {
        if (node == null || node.getKey() == null) {
            return;
        }
        BSTNode y = null;
        BSTNode x = root;
        while (x != null) {
            y = x;
            if (x.getKey() > node.getKey()) {
                x = x.getLeftChild();
            } else {
                x = x.getRightChild();
            }
        }
        node.setParent(y);
        if (y == null) {
            root = node;
        } else if (node.getKey() < y.getKey()) {
            y.setLeftChild(node);
        } else {
            y.setRightChild(node);
        }
    }

    /**
     * 移动子树，子树替换
     * @param srcNode 原来的子树节点
     * @param targetNode 替换后的子树节点
     */
    private void transplant(BSTNode srcNode, BSTNode targetNode){
        if (srcNode.getParent() == null){
            root = targetNode;
        }else if (srcNode.equals(srcNode.getParent().getLeftChild())){
            srcNode.getParent().setLeftChild(targetNode);
        }else {
            srcNode.getParent().setRightChild(targetNode);
        }
        if (targetNode != null){
            targetNode.setParent(srcNode.getParent());
        }
    }

    /**
     * 删除指定节点
     * @param node 节点
     */
    public void delete(BSTNode node){
        BSTNode delNode = search(node.getKey());
        if (delNode == null){
            return;
        }
        if (delNode.getLeftChild() == null){
            transplant(delNode, delNode.getRightChild());
        }else if (delNode.getRightChild() == null){
            transplant(delNode, delNode.getLeftChild());
        }else {
            BSTNode y = minimum(delNode.getRightChild());
            if (!delNode.equals(y.getParent())){
                transplant(y, y.getRightChild());
                y.setRightChild(delNode.getRightChild());
                y.getRightChild().setParent(y);
            }
            transplant(delNode, y);
            y.setLeftChild(delNode.getLeftChild());
            y.getLeftChild().setParent(y);
        }
    }
}
