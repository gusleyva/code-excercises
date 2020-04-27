package com.exercises.trees.find;

public class FindNumber {

	public static void main(String[] args) {
		
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		four.left = two;
		four.right = seven;
		
		System.out.println(searchBST(four, 2));
	}
	
	public static TreeNode searchBST(TreeNode root, int val) {
        if(root == null)
            return null;
        int tmpVal = root.val;//4
        if(tmpVal == val){
            return root;
        }else if(val < tmpVal){
            if(root.left == null)
                return null;
            return searchBST(root.left, val);
        }else{
            if(root.right == null)
                return null;
            return searchBST(root.right, val);
        }
    }
}

class TreeNode {
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) { val = x; }
	}