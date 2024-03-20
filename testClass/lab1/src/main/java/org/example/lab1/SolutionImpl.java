package org.example.lab1;

import org.example.lab1.solution.Solution;

import java.util.ArrayList;
import java.util.List;

public class SolutionImpl implements Solution {

    @Override
    public List<List<Integer>> pathSum(TreeNode<Integer> root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        findPaths(root, targetSum, new ArrayList<>(), paths);
        return paths;
    }

    private void findPaths(TreeNode<Integer> node, int sum, List<Integer> currentPath, List<List<Integer>> paths) {
        if (node == null) {
            return;
        }

        // 添加当前节点到路径
        currentPath.add(node.val);

        // 检查当前节点是否是叶子节点且路径和等于目标和
        if (node.left == null && node.right == null && node.val == sum) {
            paths.add(new ArrayList<>(currentPath));
        } else {
            // 继续递归左右子树
            findPaths(node.left, sum - node.val, currentPath, paths);
            findPaths(node.right, sum - node.val, currentPath, paths);
        }

        // 回溯，移除当前节点之前的路径
        currentPath.remove(currentPath.size() - 1);
    }
}
