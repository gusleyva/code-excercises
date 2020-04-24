package com.interview.trees.find.deep;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDeep {

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
		
		System.out.println(maxDepth(root));
	}
	
	public static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        
        int maxDeep = 1;
        Queue<TreeNode> q = new LinkedList<>(); 
        //[3,9,20,null,null,15,7]
        
        TreeNode node = root;
        q.add(node); //3
        
        while(!q.isEmpty()){
        	int size = q.size(); //1
        	
        	while(size > 0) {
        		TreeNode curr = q.poll(); //9 -> [20],  20
        		
        		if(curr.left != null) {
        			q.add(curr.left); //15
        		}
        		
        		if(curr.right != null) {
        			q.add(curr.right); //7
        		}
        		
        		size--; //0
        	}
        	
        	maxDeep++; //1
        }
        
        return maxDeep - 1; //2
    }
	
	public int maxDepthRecursive(TreeNode root) {
        if(root==null) //1
            return 0; //2
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));   
		//Done
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