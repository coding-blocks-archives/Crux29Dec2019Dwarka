package Lecture14;

import Lecture13.DynamicStack;

public class min_stack {

	private DynamicStack pstack;
	private DynamicStack minstack;

	public min_stack() throws Exception {
		// TODO Auto-generated constructor stub
		this.pstack = new DynamicStack();
		this.minstack = new DynamicStack();
	}

	public int size() {
		return this.pstack.size();
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void push(int item) throws Exception {
		if (this.size() == 0) {
			this.minstack.push(item);
		} else if (item <= this.minstack.top()) {
			this.minstack.push(item);
		}
		this.pstack.push(item);
	}

	public int pop() throws Exception {

		int rv = this.pstack.pop();
		if (rv == this.minstack.top()) {
			this.minstack.pop();
		}
		return rv;
	}

	public int top() throws Exception {
		int rv = this.pstack.top();
		return rv;
	}

	public void display() {
		this.pstack.display();
	}

	public int min() throws Exception {
		int rv = this.minstack.top();
		return rv;
	}
}
