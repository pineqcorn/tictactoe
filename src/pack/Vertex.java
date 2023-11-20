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
	
	public String getHumanReadableString() {
		return this.toString().substring(0, 3) + "\n" + this.toString().substring(3, 6) + "\n" + this.toString().substring(6);	
	}
	
	public static String getHumanReadableListv(ArrayList<Vertex> vertices) {
		ArrayList<String> row1 = new ArrayList<String>();
		ArrayList<String> row2 = new ArrayList<String>();
		ArrayList<String> row3 = new ArrayList<String>();
		String output = "";
		
		for (Vertex v : vertices) {
			row1.add(v.toString().substring(0, 3));
			row2.add(v.toString().substring(3, 6));
			row3.add(v.toString().substring(6, 9));
			
		}
		
		for (int i = 0; i < vertices.size(); i++) {
			output += i + 1 + ") \t";
		}
		output += "\n";
		
		for (String board : row1) {
			output += board + "\t";
		}
		
		output += "\n";
		
		for (String board : row2) {
			output += board + "\t";
		}
		
		output += "\n";
		
		for (String board : row3) {
			output += board + "\t";
		}
		
		
		return output;
	}
	

	public static String getHumanReadableListe(ArrayList<Edge> edges) {
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		for (Edge e : edges) {
			vertices.add(e.getChild());
		}
		return getHumanReadableListv(vertices);
	}
}
