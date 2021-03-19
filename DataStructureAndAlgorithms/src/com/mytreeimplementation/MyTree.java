package com.mytreeimplementation;

public class MyTree<T extends Comparable<T>> {
	private TreeNode<T> root;
	private int size = 0;

	public MyTree() {
		this.root = null;
	}

	public int size() {
		return size;
	}

	public void add(TreeNode<T> childNode) {
		if (root == null) {
			this.root = childNode;
			System.out.println("The root is added to thre tree: ");
			this.size++;
		} else {
			insert(this.root, childNode);
		}
	}

	private void insert(TreeNode<T> parentNode, TreeNode<T> childNode) {
		if (parentNode.getData().compareTo(childNode.getData()) > 0) {
			if (parentNode.getLeft() == null) {
				parentNode.setLeft(childNode);
				childNode.setParent(parentNode);
				this.size++;
			} else {
				insert(parentNode.getLeft(), childNode);
			}
		}

		if (parentNode.getData().compareTo(childNode.getData()) <= 0) {
			if (parentNode.getRight() == null) {
				parentNode.setRight(childNode);
				childNode.setParent(parentNode);
				this.size++;
			} else {
				insert(parentNode.getRight(), childNode);
			}
		}

	}

	public void printBreathFirst() {
		printLevelOrder();
	}

	private void printLevelOrder() {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++)
			printGivenLevel(root, i);
	}

	 private int height(TreeNode<T> root){
		if (root == null)
			return 0;
		else  {
			
			int lheight = height(root.getLeft());
			int rheight = height(root.getRight());

			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	private void printGivenLevel(TreeNode<T> root, int level) {
		if (root == null)
			return;
		if (level == 1)
			System.out.print(root.getData() + " ");
		else if (level > 1) {
			printGivenLevel(root.getLeft(), level - 1);
			printGivenLevel(root.getRight(), level - 1);
		}
	}

	public boolean contains(T data) {
		TreeNode<T> currentNode = getNode(data);
		if (currentNode == null) {
			return false;
		} else {
			return true;
		}
	}

	public boolean delete(T data) {
		boolean deleted = false;
		if (this.root == null) {
			return false;
		}

		TreeNode<T> currentNode = getNode(data);

		if (currentNode != null) {
		
			if (currentNode.getLeft() == null && currentNode.getRight() == null) {
				unlink(currentNode, null);
				deleted = true;
			}

			
			else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
				unlink(currentNode, currentNode.getRight());
				deleted = true;
			}


			else if (currentNode.getLeft() != null && currentNode.getRight() == null) {
				unlink(currentNode, currentNode.getLeft());
				deleted = true;
			}

			else {
				TreeNode<T> child = currentNode.getLeft();
				while (child.getRight() != null && child.getLeft() != null) {
					child = child.getRight();
				}
				
				unlink(currentNode, child);
				deleted = true;

			}
		}
		
		this.size--;
		return deleted;

	}

	private void unlink(TreeNode<T> currentNode, TreeNode<T> newNode) {
		if (currentNode == this.root) {
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			newNode.setParent(currentNode.getParent());
			this.root = newNode;
		} else if (currentNode.getParent().getRight() == currentNode) {
			currentNode.getParent().setRight(newNode);
		} else {
			currentNode.getParent().setLeft(newNode);
		}
	}

	private TreeNode<T> getNode(T data) {
		TreeNode<T> currentNode = this.root;

		while (currentNode != null) {
			int value = data.compareTo(currentNode.getData());

			if (value == 0) {
				return currentNode;
			} else if (value > 0) {
				currentNode = currentNode.getRight();
			} else {
				currentNode = currentNode.getLeft();
			}
		}
		return null;
	}

	private void printInorder(TreeNode<T> node) {
		if (node == null)
			return;
		printInorder(node.getLeft());
		System.out.print(node.getData() + " ");
		printInorder(node.getRight());
	}

	private void printPreorder(TreeNode<T> node) {
		if (node == null)
			return;

		System.out.print(node.getData() + " ");
		printPreorder(node.getLeft());
		printPreorder(node.getRight());
	}

	private void printPostorder(TreeNode<T> node) {
		if (node == null)
			return;
		printPostorder(node.getLeft());
		printPostorder(node.getRight());
		System.out.print(node.getData() + " ");
	}

	public void printDeptFirst() {
		System.out.println("Inorder traversal: ");
		printInorder(root);
		System.out.println();
		System.out.println("preorder traversal: ");
		printPreorder(root);
		System.out.println();
		System.out.println("postorder traversal: ");
		printPostorder(root);

	}

}