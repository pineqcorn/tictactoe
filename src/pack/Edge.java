package pack;

import java.util.Arrays;

public class Edge {
	private double weight;
	private Vertex parent;
	private Vertex child;
	private Character move;
	
	public Edge(Vertex p, Vertex c, Character m) {
		parent = p;
		child = c;
		move = m;
		
		p.addOutEdge(this);
		c.addInEdge(this);
	}
	
	public void setWeight(double d) {
		this.weight = d;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public Vertex getChild() {
		return child;
	}
	
	public Vertex getParent() {
		return parent;
	}
	
	public String toString() {
		return parent + " " + child + " " + (int) (1000.0 * weight) / 1000.0;
	}
	
	public Character getMove() {
		return move;
	}
}
