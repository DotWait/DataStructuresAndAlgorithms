package com.dotwait.structure.entity;

/**
 * 二叉搜索树的节点
 *
 * @author DotWait
 * @Date 2019-12-29
 */
public class BSTNode {
    private Integer key;
    private BSTNode parent;
    private BSTNode leftChild;
    private BSTNode rightChild;

    public BSTNode(Integer key) {
        this.key = key;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public BSTNode getParent() {
        return parent;
    }

    public void setParent(BSTNode parent) {
        this.parent = parent;
    }

    public BSTNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BSTNode leftChild) {
        this.leftChild = leftChild;
    }

    public BSTNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BSTNode rightChild) {
        this.rightChild = rightChild;
    }
}
