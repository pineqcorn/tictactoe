package pack;

import java.util.ArrayList;
import java.util.List;


public class Graph {
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	public Graph(ArrayList<Edge> edges) {
		this.edges = edges;
	}
	
	
	public void addEdge(Edge edge) {
		if (edges == null) {
			ArrayList<Edge> eds = new ArrayList<>();
			edges = eds;
		}
		
		edges.add(edge);
	}
	
	public String toString() {
		return edges.toString();
	}
	
	public int length() {
		return edges.size();
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}

}
