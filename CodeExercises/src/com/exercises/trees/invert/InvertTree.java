package com.exercises.trees.invert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class InvertTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		
		TreeNode nine = new TreeNode(9);
		TreeNode twenty = new TreeNode(20);
		
		TreeNode fifteen = new TreeNode(15);
		TreeNode seven = new TreeNode(7);
		twenty.left = fifteen;
		twenty.right = seven;
		
		root.left = nine;
		root.right = twenty;
		
		
		printTree(root);
		System.out.println("After: " + invertTree(root));
		printTree(root);
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if(root == null) {
			return null;
		}
		Stack<TreeNode> s = new Stack<>();
		
		s.add(root);
		while(!s.isEmpty()){
			int size = s.size();
			
			while(size > 0) {
				TreeNode curr = s.pop();
				//Swap the nodes
				TreeNode tmpNode = curr.left;
				curr.left = curr.right;
				curr.right = tmpNode;
				
				if(curr.left != null) {
					s.push(curr.left);
				}
				
				if(curr.right != null) {
					s.push(curr.right);
				}
				
				size--;
			}
			
		}
		return root;
	}
	
	public static void printTreeRecursive(List<TreeNode> listNodes) {
		if(listNodes.isEmpty()) {
			System.out.println("Empty tree");
		}
		List<TreeNode> next = new ArrayList<>();
		for(TreeNode node: listNodes) {
			if(node != null) {
				System.out.println(node.val);
				
				if(node.left != null)
					next.add(node.left);
				
				if(node.right != null)
					next.add(node.right);
			}
		}
		
		System.out.println("");
		printTreeRecursive(next);
	}
	
	public static void printTree(TreeNode node) {
		if(node == null) {
			System.out.println("Empty tree");
		}
		
		Queue<TreeNode> q = new LinkedList<>();
		
		q.offer(node);
		while(!q.isEmpty()) {
			int size = q.size();
			while(size > 0) {
				TreeNode n = q.poll();
				System.out.print(n.val + " ");
				
				if(n.left != null)
					q.add(n.left);
				
				if(n.right != null)
					q.add(n.right);
				
				size --;
			}
			System.out.println("");
		}
	}
	
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}