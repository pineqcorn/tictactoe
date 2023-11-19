package pack;

import java.util.ArrayList;
import java.util.Arrays;

public class Vertex {
	private Character[][] boardState;
	private ArrayList<Edge> inEdges = new ArrayList<Edge>();
	private ArrayList<Edge> outEdges = new ArrayList<Edge>();
	
	public Vertex(Character[][] value) {
		this.boardState = value;
	}
	
	public String toString() {
		String output = "";
		for (Character[] row : boardState) {
			for (Character col : row) {
				output += col;
			}
		}
		return output;
	}
	
	public Character[][] getValue() {
		Character[][] ret = new Character[3][3];
		for (int row = 0; row < boardState.length; row++) {
			ret[row] = Arrays.copyOf(boardState[row], 3);
		}
		return ret;
	}
	
	public void addOutEdge(Edge e) {
		outEdges.add(e);
	}
	
	public void addInEdge(Edge e) {
		inEdges.add(e);
	}
	
	public ArrayList<Edge> getOutEdges() {
		return outEdges;
	}
	
	public ArrayList<Edge> getInEdges() {
		return inEdges;
	}
}
