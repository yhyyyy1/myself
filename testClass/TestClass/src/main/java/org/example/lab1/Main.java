package org.example.lab1;

import org.example.lab1.solution.Solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the node values separated by spaces (use 'null' for empty nodes):");

        String line = scanner.nextLine();
        String[] parts = line.split(" ");
        Integer[] nodes = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nodes[i] = "null".equals(parts[i]) ? null : Integer.parseInt(parts[i]);
        }

        // 读取目标和
        System.out.println("Enter the target sum:");
        int targetSum = scanner.nextInt();

        BinaryTree<Integer> tree = new BinaryTree<>(nodes);
//        tree.printLevelOrder();
        // your code here
        Solution solution = new SolutionImpl();
        List<List<Integer>> results = solution.pathSum(tree.root, targetSum);
        System.out.println(results);
    }

}