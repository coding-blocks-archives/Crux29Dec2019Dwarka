package Lecture15;

public class client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		list.addFirst(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		//list.addAt(5, 55);
		//list.addLast(60);
		
//		list.display();
//		
//		System.out.println(list.getFirst());
//		System.out.println(list.getLast());
//		System.out.println(list.getAt(3));
//		
//		
//		list.removeFirst();
//		list.removeAt(4);
//		list.removeLast();
		list.display();
	}

}
