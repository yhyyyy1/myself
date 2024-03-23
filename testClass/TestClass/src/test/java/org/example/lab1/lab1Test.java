package org.example.lab1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class lab1Test {

    @Test
    public void testEmptyTree() {
        SolutionImpl solution = new SolutionImpl();
        TreeNode<Integer> root = null;
        List<List<Integer>> paths = solution.pathSum(root, 0);
        Assert.assertTrue("Empty tree should return empty list", paths.isEmpty());
    }

    @Test
    public void testSinglePathTree() {
        SolutionImpl solution = new SolutionImpl();
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(8);

        List<List<Integer>> paths = solution.pathSum(root, 9);
        Assert.assertFalse("Should have one path", paths.isEmpty());
        Assert.assertEquals("Path should match", Arrays.asList(5, 4), paths.get(0));
    }

    @Test
    public void testMultiplePathsTree() {
        SolutionImpl solution = new SolutionImpl();
        TreeNode<Integer> root = new TreeNode<>(5);
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(8);
        root.left.left = new TreeNode<>(11);
        root.left.left.left = new TreeNode<>(7);
        root.left.left.right = new TreeNode<>(2);
        root.right.left = new TreeNode<>(13);
        root.right.right = new TreeNode<>(4);
        root.right.right.left = new TreeNode<>(5);
        root.right.right.right = new TreeNode<>(1);

        List<List<Integer>> paths = solution.pathSum(root, 22);
        Assert.assertFalse("Should have multiple paths", paths.isEmpty());
        Assert.assertTrue("Should contain path 5->4->11->2", paths.contains(Arrays.asList(5, 4, 11, 2)));
        Assert.assertTrue("Should contain path 5->8->4->5", paths.contains(Arrays.asList(5, 8, 4, 5)));
    }
}
