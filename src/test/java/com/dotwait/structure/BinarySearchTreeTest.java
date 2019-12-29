package com.dotwait.structure;

import com.dotwait.structure.entity.BSTNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 二叉搜索树测试类
 *
 * @author DotWait
 * @Date 2019-12-29
 */
public class BinarySearchTreeTest {
    private static Random random = new Random();

    @Test
    public void binarySearchTreeTest(){
        BinarySearchTree bst = new BinarySearchTree(initNodes(10, 100));
        System.out.println("中序遍历：");
        bst.inOrderTraversal();
        System.out.println("前序遍历：");
        bst.preOrderTraversal();
        System.out.println("后序遍历：");
        bst.postOrderTraversal();
        BSTNode minimum = bst.minimum();
        System.out.println("minimum:"+minimum.getKey());
        BSTNode maximum = bst.maximum();
        System.out.println("maximum:"+maximum.getKey());
        BSTNode predecessor = bst.predecessor(maximum);
        System.out.println("predecessor:"+predecessor.getKey());
        BSTNode successor = bst.successor(minimum);
        System.out.println("successor:"+successor.getKey());
        System.out.println("root:"+bst.getRoot().getKey());
        bst.delete(bst.getRoot());
        System.out.println("中序遍历：");
        bst.inOrderTraversal();
        System.out.println("前序遍历：");
        bst.preOrderTraversal();
    }

    private List<BSTNode> initNodes(int num, int limit){
        List<BSTNode> bstNodes = new ArrayList<>(num);
        for (int i=0;i<num;i++){
            bstNodes.add(new BSTNode(random.nextInt(limit)));
        }
        return bstNodes;
    }

}
