package Lecture12;

public class StackUsingArrays {
	
	private int[] data;
	private int tos;
	
	public static final int DEFAULT_CAPACITY=10;
	public StackUsingArrays() throws Exception {
		this(DEFAULT_CAPACITY);
	}
	
	public StackUsingArrays(int capacity) throws Exception {
		if(capacity<=0) {
			throw new Exception("invalid Capacity");
		}
		
		this.data=new int[capacity];
		this.tos=-1;
	}
	
	public int size() {
		return this.tos+1;
	}
	
	public boolean isEmpty() {
		return this.size()==0;
	}
	
	public void push(int item) throws Exception{
		if(this.size()==this.data.length) {
			throw new Exception("Stack is Full");
		}
		
		this.tos++;
		this.data[this.tos]=item;
	}
	
	public int pop() throws Exception{
		if(this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		
		int rv=this.data[this.tos];
		this.data[this.tos]=0;
		this.tos--;
		return rv;
	}
	
	public int top() throws Exception{
		if(this.isEmpty()) {
			throw new Exception("Stack is Empty");
		}
		
		int rv=this.data[this.tos];
		return rv;
	}
	
	public void display() {
		for(int i=this.tos;i>=0;i--) {
			System.out.print(this.data[i]+" ");
		}
		System.out.println();
	}

}
