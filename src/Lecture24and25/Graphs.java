package Lecture24and25;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Graphs {

	private class Vertex {
		String name;
		HashMap<Vertex, Integer> nbrs;

		public Vertex(String name) {
			// TODO Auto-generated constructor stub
			this.name = name;
			this.nbrs = new HashMap<>();
		}

		public void display() {
			String str = this.name + "=>";
			Set<Vertex> nbrs = this.nbrs.keySet();
			for (Vertex nbr : nbrs) {
				str = str + nbr.name + "(" + this.nbrs.get(nbr) + "), ";
			}

			str = str + "END";
			System.out.println(str);

		}
	}

	HashMap<String, Vertex> vtces;

	Graphs() {
		this.vtces = new HashMap<>();
	}

	public void addVertex(String name) {
		if (vtces.containsKey(name)) {
			return;
		}
		Vertex vtx = new Vertex(name);
		this.vtces.put(name, vtx);
	}

	public void addEdge(String name1, String name2, int cost) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);

		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vtx2)) {
			return;
		}

		vtx1.nbrs.put(vtx2, cost);
		vtx2.nbrs.put(vtx1, cost);

	}

	public void removeEdge(String name1, String name2) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);

		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vtx2)) {
			return;
		}

		vtx1.nbrs.remove(vtx2);
		vtx2.nbrs.remove(vtx1);

	}

	public int numEdges() {
		Collection<Vertex> vtces = this.vtces.values();
		int count = 0;
		for (Vertex vtx : vtces) {
			count = count + vtx.nbrs.size();
		}
		count = count / 2;
		return count;
	}

	public int numVtces() {
		return this.vtces.size();
	}

	public void removeVertex(String name) {
		if (!this.vtces.containsKey(name)) {
			return;
		}
		Vertex vtx = this.vtces.get(name);
		Set<Vertex> nbrs = vtx.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			nbr.nbrs.remove(vtx);
		}

		this.vtces.remove(name);

	}

	public void display() {
		Collection<Vertex> vtces = this.vtces.values();
		for (Vertex vtx : vtces) {
			vtx.display();
		}
		System.out.println("**************************");
	}

	public boolean hasPath(String name1, String name2) {
		Vertex vtx1 = this.vtces.get(name1);
		Vertex vtx2 = this.vtces.get(name2);

		if (vtx1 == null | vtx2 == null) {
			return false;
		}

		HashMap<Vertex, Boolean> traversed = new HashMap<>();
		return this.hasPathBFS(vtx1, vtx2, traversed);
	}

	private boolean hasPathDFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> traversed) {
		if (!traversed.containsKey(vtx1)) {
			traversed.put(vtx1, true);
		} else {
			return false;
		}

		if (vtx1.nbrs.containsKey(vtx2)) {
			return true;
		}

		Set<Vertex> nbrs = vtx1.nbrs.keySet();
		for (Vertex nbr : nbrs) {
			if (this.hasPathDFS(nbr, vtx2, traversed)) {
				return true;
			}
		}

		return false;
	}

	private boolean hasPathBFS(Vertex vtx1, Vertex vtx2, HashMap<Vertex, Boolean> traversed) {
		Queue<Vertex> q = new LinkedList<>();
		q.add(vtx1);
		while (!q.isEmpty()) {
			Vertex rv = q.remove();
			if (!traversed.containsKey(rv)) {
				traversed.put(rv, true);
				if (rv.nbrs.containsKey(vtx2)) {
					return true;
				}
				Set<Vertex> nbrs = rv.nbrs.keySet();
				for (Vertex nbr : nbrs) {
					if (!traversed.containsKey(nbr)) {
						q.add(nbr);
					}
				}
			}
		}

		return false;
	}

	public void bft() {
		Queue<Vertex> q = new LinkedList<>();
		Collection<Vertex> vtces=this.vtces.values();
		HashMap<Vertex, Boolean> traversed = new HashMap<>();
		for(Vertex vtx:vtces) {
			if(!traversed.containsKey(vtx)) {
				q.add(vtx);
			}
			
			while (!q.isEmpty()) {
				Vertex rv = q.remove();
				if (!traversed.containsKey(rv)) {
					traversed.put(rv, true);
					System.out.print(rv.name+" ");
					Set<Vertex> nbrs = rv.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!traversed.containsKey(nbr)) {
							q.add(nbr);
						}
					}
				}
			}

			
		}
	}
	
	public void dft() {
		LinkedList<Vertex> stack = new LinkedList<>();
		Collection<Vertex> vtces=this.vtces.values();
		HashMap<Vertex, Boolean> traversed = new HashMap<>();
		for(Vertex vtx:vtces) {
			if(!traversed.containsKey(vtx)) {
				stack.addFirst(vtx);
			}
			
			while (!stack.isEmpty()) {
				Vertex rv = stack.removeFirst();
				if (!traversed.containsKey(rv)) {
					traversed.put(rv, true);
					System.out.print(rv.name+" ");
					Set<Vertex> nbrs = rv.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!traversed.containsKey(nbr)) {
							stack.addFirst(nbr);
						}
					}
				}
			}

			
		}
	}
	
	public void Djikstra(String src1) {
		int[] dis=new int[this.vtces.size()];
		for(int i=0;i<dis.length;i++) {
			dis[i]=Integer.MAX_VALUE;
		}
		
		Vertex v=this.vtces.get(src1);
		dis[src1.charAt(0)-65]=0;
		
		Queue<String> q=new LinkedList<>();
		q.add(src1);
		
		while(!q.isEmpty()) {
			String str=q.remove();
			Vertex vtx=this.vtces.get(str);
			Set<Vertex> nbrs=vtx.nbrs.keySet();
			for(Vertex nbr:nbrs) {
				int oldcost=dis[nbr.name.charAt(0)-65];
				int newcost=dis[vtx.name.charAt(0)-65]+vtx.nbrs.get(nbr);
				if(newcost<oldcost) {
					dis[nbr.name.charAt(0)-65]=newcost;
					q.add(nbr.name);
				}
			}
		}
		
		for(int i=0;i<dis.length;i++) {
			System.out.print(dis[i]+" ");
		}
	}
	
	public boolean isConnected() {
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtces = this.vtces.values();
		queue.add((Vertex) vtces.toArray()[0]);
		while (!queue.isEmpty()) {
			Vertex rvtx = queue.remove();
			if (!visited.containsKey(rvtx)) {
				visited.put(rvtx, true);
				// System.out.print(rvtx.name+" ");
				Set<Vertex> nbrs = rvtx.nbrs.keySet();
				for (Vertex nbr : nbrs) {
					if (!visited.containsKey(nbr)) {
						queue.add(nbr);
					}
				}
			}
		}

		return this.vtces.size() == visited.size();
	}

	public ArrayList<ArrayList<String>> getCC() {
		ArrayList<ArrayList<String>> list = new ArrayList<>();
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		Collection<Vertex> vtces = this.vtces.values();
		for (Vertex vtx : vtces) {
			if (!visited.containsKey(vtx)) {
				queue.add(vtx);
			}
			ArrayList<String> cc = new ArrayList<>();
			while (!queue.isEmpty()) {
				Vertex rvtx = queue.remove();
				if (!visited.containsKey(rvtx)) {
					visited.put(rvtx, true);
					cc.add(rvtx.name);
					Set<Vertex> nbrs = rvtx.nbrs.keySet();
					for (Vertex nbr : nbrs) {
						if (!visited.containsKey(nbr)) {
							queue.add(nbr);
						}
					}
				}
			}
			if (cc.size() != 0) {
				list.add(cc);
			}
		}
		return list;
	}
	
}
