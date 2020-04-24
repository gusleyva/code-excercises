package com.interview.trees.insert;

public class InsertIntoBST {

	public static void main(String[] args) {
		TreeNode two = new TreeNode(2);
		TreeNode seven = new TreeNode(7);
		TreeNode four = new TreeNode(4);
		four.left = two;
		four.right = seven;
		
		System.out.println(insertIntoBST(four, 2));
		System.out.println(insertIntoBST(four, 1));
		System.out.println(insertIntoBST(four, 9));
		System.out.println(insertIntoBST(four, 5));
	}
	
	public static TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null)
			return new TreeNode(val);
		TreeNode tmpRoot = root;
		while(tmpRoot != null) {
			int tmpVal = tmpRoot.val;
			System.out.printf("tmpVal: [%d], val: [%d] \n", tmpVal, val);
			if(tmpVal == val) {
				return tmpRoot;
			}else if(val > tmpVal) {//right
				TreeNode rightNode = tmpRoot.right;
				if(rightNode == null) {
					TreeNode tmpRecord = new TreeNode(val);
					tmpRoot.right = tmpRecord;
					tmpRoot = rightNode;
				}else {
					tmpRoot = rightNode;
				}
			}else {//left
				TreeNode leftNode = tmpRoot.left;
				if(leftNode == null) {
					TreeNode tmpRecord = new TreeNode(val);
					tmpRoot.left = tmpRecord;
					tmpRoot = leftNode;
				}else {
					tmpRoot = leftNode;
				}
			}
		}
		
		return root;
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