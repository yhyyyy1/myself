package org.example.lab1;

import org.example.lab1.TreeNode;
import org.example.lab1.solution.Solution;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class lab1Test{

    @Test
    public void testSinglePath() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        Solution solution = new SolutionImpl();
        List<List<Integer>> result = solution.pathSum(root, 22);

        assertEquals(1, result.size(), "Should find one path");
        assertTrue(result.contains(Arrays.asList(5, 4, 11, 2)), "Path should be 5->4->11->2");
    }

    @Test
    public void testMultiplePaths() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        Solution solution = new SolutionImpl();
        List<List<Integer>> result = solution.pathSum(root, 22);

        assertEquals(2, result.size(), "Should find two paths");
        assertTrue(result.contains(Arrays.asList(5, 4, 11, 2)), "First path should be 5->4->11->2");
        assertTrue(result.contains(Arrays.asList(5, 8, 4, 5)), "Second path should be 5->8->4->5");
    }

    @Test
    public void testNoPath() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution solution = new SolutionImpl();
        List<List<Integer>> result = solution.pathSum(root, 5);

        assertTrue(result.isEmpty(), "Should find no path");
        assertFalse(result.contains(Arrays.asList(1, 2)), "Should not contain path 1->2");
    }
}

