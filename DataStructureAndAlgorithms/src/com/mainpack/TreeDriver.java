package com.mainpack;

import com.mytreeimplementation.MyTree;
import com.mytreeimplementation.TreeNode;

public class TreeDriver {

	public static void main(String[] args) {
		MyTree<Integer> tree=new MyTree<>();
		tree.add(new TreeNode<>(25));
		tree.add(new TreeNode<>(20));
		tree.add(new TreeNode<>(35));
		tree.add(new TreeNode<>(12));
		tree.add(new TreeNode<>(23));
		tree.add(new TreeNode<>(27));
		tree.add(new TreeNode<>(50));
		tree.add(new TreeNode<>(4));
		tree.add(new TreeNode<>(14));
		tree.add(new TreeNode<>(22));
		tree.add(new TreeNode<>(24));
		tree.add(new TreeNode<>(26));
		tree.add(new TreeNode<>(28));
		System.out.println("Tree size: "+tree.size());
		System.out.println("contains: "+tree.contains(4));
		System.out.println("Level order traversal : ");
		tree.printBreathFirst();
		
		System.out.println("\nDepth first traversal: \n ");
		tree.printDeptFirst();
		tree.delete(4);
		System.out.println("\nTree size: "+tree.size());
		System.out.println("contains: "+tree.contains(4));
		System.out.println("Level order traversal : ");
		tree.printBreathFirst();
		System.out.println("\nDepth first traversal:\n");
		tree.printDeptFirst();
	}

}
