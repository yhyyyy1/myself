package org.example.writtenexamination.TXmusic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * AC 45mins
 */
public class T2 {
    public TreeNode makeCompleteTree (TreeNode root) {
        // write code here



        if ( root == null) return root;

        // 先层序遍历，添加非底层节点
        int totalHeight = maxDepth(root);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // 定义层数
        int height = 1;
        while (!queue.isEmpty() && height < totalHeight - 1) {
            TreeNode nowNode;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                nowNode = queue.poll();
                if (nowNode.left == null) {
                    nowNode.left = new TreeNode(1);

                }
                if (nowNode.right == null) {
                    nowNode.right = new TreeNode(1);
                }
                queue.add(nowNode.left);
                queue.add(nowNode.right);
            }
            height++;
        }

        // 目前队列中是 倒数第二层
        int[] check = new int[queue.size() * 2];
        Iterator<TreeNode> it = queue.iterator();
        int index = 0;
        TreeNode tempNode;
        while (it.hasNext()) {
            tempNode = it.next();
            if (tempNode.left == null) {
                check[index] = 0;
            } else {
                check[index] = 1;
            }

            index++;

            if (tempNode.right == null) {
                check[index] = 0;
            } else {
                check[index] = 1;
            }

            index++;
        }

        int maxRight = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 1)
                maxRight = Math.max(i, maxRight);
        }

        maxRight++;
        int times = 0;
        // 得到最右侧的1的位置，对左侧进行补全
        if (maxRight % 2 == 0) {
            // 右端点
            times = maxRight / 2;
        } else {
            times = (maxRight + 1) / 2;
        }

        for (int i = 0; i < times - 1; i++) {
            tempNode = queue.poll();
            if (tempNode.left == null) {
                tempNode.left = new TreeNode(1);
            }
            if (tempNode.right == null) {
                tempNode.right = new TreeNode(1);
            }
        }
        if (maxRight % 2 == 0) {
            tempNode = queue.poll();
            if (tempNode.left == null) {
                tempNode.left = new TreeNode(1);
            }
        }
        return root;

    }
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
