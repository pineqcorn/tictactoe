package test;

public class Edge {
	private int weight;
	private Vertex parent;
	private Vertex child;
	
	public Edge(Vertex p, Vertex c) {
		parent = p;
		child = c;
		
		p.addOutEdge(this);
		c.addInEdge(this);
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public Vertex getChild() {
		return child;
	}
	
	public Vertex getParent() {
		return parent;
	}
	
	public String toString() {
		return "\n" + parent + " " + child + " " + weight;
	}
}
