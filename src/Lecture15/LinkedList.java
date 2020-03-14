package Lecture15;
public class LinkedList {
	private class Node {
		int data;
		Node next;

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	Node tail;
	int size;

	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void addFirst(int data) {
		Node node = new Node(data, this.head);
		this.head = node;
		if (this.isEmpty()) {
			this.tail = node;
		}
		this.size++;
	}

	public void addLast(int data) {
		Node node = new Node(data, null);
		if (this.isEmpty()) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	private Node getNodeAt(int index) throws Exception {
		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid index");
		}

		int counter = 0;
		Node temp = this.head;
		while (counter < index) {
			temp = temp.next;
			counter++;
		}

		return temp;
	}

	public void addAt(int index, int data) throws Exception {
		if (index < 0 || index > this.size) {
			throw new Exception("Invalid index");
		}

		if (index == 0) {
			this.addFirst(data);
		} else if (index == this.size) {
			this.addLast(data);
		} else {
			Node temp = this.getNodeAt(index - 1);
			Node node = new Node(data, temp.next);
			temp.next = node;
			this.size++;
		}
	}

	public int getFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.head.data;
	}

	public int getLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		return this.tail.data;
	}

	public int getAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		if (index < 0 || index >= this.size) {
			throw new Exception("Invalid Index");
		}

		return this.getNodeAt(index).data;
	}

	public int removeFirst() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		Node rv = this.head;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}
		this.size--;
		return rv.data;
	}

	public int removeLast() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}

		Node rv = this.tail;

		if (this.size() == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node temp = this.getNodeAt(this.size - 2);
			temp.next = null;
			this.tail = temp;

		}
		this.size--;
		return rv.data;
	}
	
	public int removeAt(int index) throws Exception {
		if (this.isEmpty()) {
			throw new Exception("List is Empty");
		}
		
		if(index<0||index>=this.size) {
			throw new Exception("Invalid Index");
		}
	
		if(index==0) {
			return this.removeFirst();
		}else if(index==this.size-1) {
			return this.removeLast();
		}else {
			Node rv=this.getNodeAt(index);
			Node temp=this.getNodeAt(index-1);
			temp.next=temp.next.next;
			this.size--;
			return rv.data;
		}

	}
	
	public void display() {
		Node temp=this.head;
		while(temp!=null) {
			System.out.print(temp.data+"=>");
			temp=temp.next;
		}
		System.out.println("END");
	}
	
	public void reverseDI() throws Exception {
		int left = 0, right = this.size - 1;

		while (left <= right) {
			Node l = this.getNodeAt(left);
			Node r = this.getNodeAt(right);
			int temp = l.data;
			l.data = r.data;
			r.data = temp;
			left++;
			right--;
		}
	}

	public void reversePI() {
		Node prev = this.head;
		Node curr = prev.next;
		while (curr != null) {
			Node tprev = prev;
			Node tcurr = curr;
			prev = curr;
			curr = curr.next;
			tcurr.next = tprev;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}
	
	public int mid() {
		return this.getmidNode().data;
	}
	
	private Node getmidNode() {
		Node slow=this.head;
		Node fast=this.head;
		
		while(fast.next!=null&&fast.next.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		
		return slow;
	}
	
	
	public int KthNodeFromEnd(int k) throws Exception {
		Node slow=this.head;
		Node fast=this.head;
		for(int i=0;i<k;i++) {
			fast=fast.next;
		}
		
		while(fast!=null) {
			slow=slow.next;
			fast=fast.next;
		}
		
		return slow.data;
	}
	
	public void createCycle() throws Exception {
		Node temp=this.getNodeAt(2);
		this.tail.next=temp;
	}
	
	public boolean detectCycle() {
		
		Node slow=this.head;
		Node fast=this.head;
		
		while(fast.next!=null&&fast.next.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
			if(fast==slow) {
				return true;
			}
		}
		
		return false;
	}
	
	
	public void reverseDR() {
		HeapMover hm=new HeapMover(this.head);
		reverseDR(hm, this.head, 0);
	}
	
	private void reverseDR(HeapMover hm,Node right,int level) {
		if(right==null) {
			return;
		}
		
		reverseDR(hm, right.next, level+1);
		if(level>=this.size/2) {
			int temp=hm.node.data;
			hm.node.data=right.data;
			right.data=temp;
			hm.node=hm.node.next;
			
		}
		
		
	}
	
	private class HeapMover{
		Node node;
		HeapMover(Node node){
			this.node=node;
		}
	}
	
	
}
