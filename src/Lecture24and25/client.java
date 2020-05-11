package Lecture24and25;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs graph=new Graphs();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		
		
		graph.addEdge("A", "B", 10);
		graph.addEdge("A", "D", 40);
		graph.addEdge("B", "C", 10);
		graph.addEdge("C", "D", 10);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "F", 3);
		graph.addEdge("F", "G", 3);
		graph.addEdge("G", "E", 8);
		
		System.out.println(graph.numEdges());
		System.out.println(graph.numVtces());
		
		graph.display();

		//graph.removeEdge("D", "E");
		//graph.removeVertex("A");
		graph.display();
		
//		System.out.println(graph.hasPath("A", "G"));
//		graph.bft();
//		System.out.println();
//		graph.dft();
	//	graph.dft();
		
		graph.Djikstra("A");
	}
	
	

}
