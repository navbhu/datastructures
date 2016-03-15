package cs.ds.lists;

/*This is an implementation of a Linked List.
 *
 * Linked list as the name says it is a list of linked elements.
 * First/ Head element links the second element, second links the third, etc.
 * Last element links (points) to null, which is like saying this is the last element.
 *
 *  */


public class LinkedList {


	private class Node {
		private int data;
		private Node nextNode = null;

		public Node(int data){
			this.data=data;
		}

		public int getData() {
			return data;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public void setNextNode(Node node) {
			this.nextNode=node;
		}
	}

	private Node headNode = null;
	private Node tailNode = null;

	public LinkedList(){
	}

	private Node getHead() {
		return headNode;
	}

	public void add(int data) {
		Node node = new Node(data);
		if(headNode == null && tailNode == null){
			headNode=node;
			tailNode=node;
		} else {
			tailNode.setNextNode(node);
			tailNode = node;
		}
	}

	public int getLength(){
		int length=0;
		Node current = this.getHead();
		while(current!=null){
			length++;
			current = current.getNextNode();
		}
		return length;
	}

	public int getData(int nodePosition){
		int length=0;
		Node current = this.getHead();
		while(current!=null && (length != nodePosition)){
			length++;
			current = current.getNextNode();			
		}
		return current.getData();
	}

	public static void main(String[] args) {

		LinkedList nodeList = new LinkedList();
		nodeList.add(4);
		nodeList.add(5);
		nodeList.add(6);
		nodeList.add(7);
		nodeList.add(8);
		System.out.println("Length of the list is : " + nodeList.getLength());

		for(int i=0; i < nodeList.getLength(); i++) {
			System.out.println("data in position " + i +"  is : " + nodeList.getData(i));
		}		
	}
}


