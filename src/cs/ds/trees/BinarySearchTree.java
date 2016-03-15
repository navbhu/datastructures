package cs.ds.trees;

/*
 Binary tree is a parent node with two child nodes. One on the left side and another on the right side.
 Left child has value less than or equal to the parent node.
 If the value is greater than the parent then it is put in the right side.
 */

public class BinarySearchTree {
	
	private class Node {
		int data = 0;
		Node leftNode = null;
		Node rightNode = null;
		
		public Node getLeftNode() {
			return leftNode;
		}

		public void setLeftNode(Node leftNode) {
			this.leftNode = leftNode;
		}

		public Node getRightNode() {
			return rightNode;
		}

		public void setRightNode(Node rightNode) {
			this.rightNode = rightNode;
		}

		public Node(int data){
			this.data=data;
		}

		public int getData() {
			return data;
		}			
	}
	
	private Node rootNode = null;
	
	BinarySearchTree(int data){
		this.rootNode = new Node(4);
	}
	
	BinarySearchTree(){		
	}
	
	//Add the given value to the binary tree
	public void add(int data){
		Node node = new Node(data);
		if(rootNode==null){
			rootNode = node;
		} else {
			addNode(this.rootNode, node);
		}
	}
	
	private void addNode(Node currentNode, Node newNode){
		if(currentNode.getData() < newNode.getData()){
			if (currentNode.getRightNode()==null){
				currentNode.setRightNode(newNode);
			} else {
				addNode(currentNode.getRightNode(), newNode);
			}
		} else {
			if(currentNode.getLeftNode()== null){
				currentNode.setLeftNode(newNode);
			} else {
				addNode(currentNode.getLeftNode(), newNode);
			}
		}
	}
	
	//Return the number of nodes in the binary tree
	public int size(){
		return size(this.rootNode);
	}
	
	private int size(Node node){
		int leftNodeSize = 0;
		if(node.getLeftNode()!=null){
			leftNodeSize++;
			leftNodeSize = size(node.getLeftNode());
		}
		
		int rightNodeSize = 0;
		if(node.getRightNode()!= null){
			rightNodeSize++;
			rightNodeSize = size(node.getRightNode());
		}	
		return rightNodeSize+leftNodeSize+1;
	}
	
	//Return max depth of the tree
	public int maxDepth(){
		return maxDepth(this.rootNode,1);
	}
	
	private int maxDepth(Node node, int depth){
		int leftNodeDepth = depth;
		if(node.getLeftNode()!=null){
			leftNodeDepth++;
			leftNodeDepth = maxDepth(node.getLeftNode(), leftNodeDepth);
		}
		
		int rightNodeDepth = depth;
		if(node.getRightNode()!= null){
			rightNodeDepth++;
			rightNodeDepth = maxDepth(node.getRightNode(), rightNodeDepth);
		}
		if(leftNodeDepth > rightNodeDepth){
			return leftNodeDepth;
		}
		return rightNodeDepth;
	}
	
	
	//Return the minimum value of this tree
	public int minValue(){
		return minValue(this.rootNode, this.rootNode.getData());
	}
	
	private int minValue(Node node, int minValue){
		int minimumValue = minValue;
		if(node.getLeftNode()!=null){
			minimumValue = minValue(node.getLeftNode(), node.getLeftNode().getData());
		}
		return minimumValue;
	}
	
	//Print the elements in ascending order 
	public void printData(){
		printData(this.rootNode);
	}
	
	private void printData(Node node){
		if(node.getLeftNode()!=null){
			printData(node.getLeftNode());
		}
		System.out.print(node.getData());
		System.out.print(", ");
		if(node.getRightNode()!= null){
		printData(node.getRightNode());
		}
	}
	
	//Print the elements of this tree in descending order
	public void printDescending(){
		printDescending(this.rootNode);
	}
	
	private void printDescending(Node node){

		if(node.getRightNode()!= null){
			printDescending(node.getRightNode());
		}
		System.out.print(node.getData());
		System.out.print(", ");
		if(node.getLeftNode()!=null){
			printDescending(node.getLeftNode());
		}
	}
	
	
	//Print the value of child's values before printing the parent's
	public void printPostOrder(){
		printPostOrder(this.rootNode);
	}
	
	private void printPostOrder(Node node){
		if(node.getLeftNode()!=null){
			printPostOrder(node.getLeftNode());
		}
		if(node.getRightNode()!= null){
		printPostOrder(node.getRightNode());
		}
		System.out.print(node.getData());
		System.out.print(", ");
	}
	
	public static void main(String[] args) {

		BinarySearchTree binaryTree = new BinarySearchTree();
		binaryTree.add(7);
		binaryTree.add(6);
		binaryTree.add(8);
		binaryTree.add(3);
		binaryTree.add(7);
		binaryTree.add(9);
		binaryTree.add(17);
		binaryTree.add(17);
		binaryTree.add(1);
		binaryTree.add(3);
		binaryTree.add(4);
		binaryTree.add(5);
		binaryTree.add(27);
		binaryTree.add(15);
		binaryTree.add(1);
		binaryTree.add(4);
		
		System.out.println("Size of this node is : "+binaryTree.size());
		System.out.println("Max depth is : " + binaryTree.maxDepth());
		System.out.println("Min Value is : " + binaryTree.minValue());
		binaryTree.printData();
		System.out.println();
		binaryTree.printDescending();
		System.out.println();
		binaryTree.printPostOrder();
	}

}

