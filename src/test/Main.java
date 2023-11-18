package test;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static Graph boardGraph = new Graph(null);

	public static void main(String[] args) {
		Character[][] board = new Character[3][3];
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = '-';
			}
		}
		play_game(board, 'x', new Vertex(board));
		Scanner scan = new Scanner(System.in);
		
		ArrayList<Vertex> dummy = new ArrayList<Vertex>();
		dummy.add(boardGraph.getEdges().get(0).getParent());
		
		controlPanel(dummy, scan);
	}
	
	private static int play_game(Character[][] board, Character move, Vertex parent) {

		
		int sumEdges = 0;
		for (int row = 0; row < board.length; row++) {
			
			for (int col = 0; col < board[row].length; col++) {
				board = parent.getValue();
			
				
				if (!board[row][col].equals('-')) {continue;}
				//for every cell that is empty
				
				board[row][col] = move;
				
				final Vertex HERE = new Vertex(board);
				
				Edge e = new Edge(parent, HERE);
				boardGraph.addEdge(e);
				
				//System.out.println(boardGraph.length());
				
				final String WON = detect_win(board);
				
				if (WON.equals(move + " win")) {
					e.setWeight(1);
					//return move + " win";
				} else if (WON.equals("no win")){
					
					if (move.equals('x')) {move = 'o';}
					else if (move.equals('o')) {move = 'x';}
					
					int result = play_game(board, move, HERE);
					
					if (move.equals('x')) {move = 'o';}
					else if (move.equals('o')) {move = 'x';}
					
					e.setWeight(e.getWeight() - result);


				} else {
					e.setWeight(-1);
					//return move + " win";
				}
				
				sumEdges += e.getWeight();
			}
		}
		return sumEdges;
	}
	
	private static String detect_win(Character[][] board) {
		for (Character[] row : board) {
			//detects three across win
			if (!row[0].equals('-') && row[0].equals(row[1]) && row[0].equals(row[2])) {
				return row[0] + " win";
			}

		}
		
		//checks for column win
		for (int i = 0; i < 3; i++) {
			if (!board[0][i].equals('-') && board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])) {
				return board[0][i] + " win";
			}
		}
		
		if ((!board[0][0].equals('-') && board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2]))
				||
			(!board[2][0].equals('-') && board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2]))) {
				return board[1][1] + " win";
			}
		return "no win";
	}
	
	private static void controlPanel(ArrayList<Vertex> vArray, Scanner scan) {
		for (int i = 0; i < vArray.size(); i++) {
			if (i == 0) {
				System.out.println("* " + vArray.get(i) + " ROOT");
				continue;
			}
			else if (i == vArray.size() - 1) {
				System.out.println("v " + vArray.get(i));
				continue;
			}
			System.out.println("| " + vArray.get(i));
		}
		Vertex v = vArray.get(vArray.size() - 1);
		System.out.println("Current Vertex: " + v);
		
		if (v.getInEdges().size() > 0) {
			System.out.println("\nIn Edges");
			System.out.println("\n#  parent    child     value");			
			//prints out all in edges
			for (Edge e : v.getInEdges()) {
				System.out.println(v.getInEdges().indexOf(e) + ") " + e);
			}
		} else {
			System.out.println("There are no incoming edges");
		}
		
		if (v.getOutEdges().size() > 0) {
			System.out.println("\nOut Edges");
			System.out.println("\n#  parent    child     value");	
			
			//prints out all out edges
			for (Edge e : v.getOutEdges()) {
				System.out.println(v.getOutEdges().indexOf(e) + ") " + e);
			}
		} else {
			System.out.println("There are no outgoing edges");
		}
		
		//choose in/out edges
		int ioChoice = 0;
		final int IN_EDGES = 1;
		final int OUT_EDGES = 2;
		
		do {
			System.out.print("\n1) In edges\n2) Out edges\n");
			ioChoice = scan.nextInt();
			if (ioChoice > 2 || ioChoice < 0) {
				System.out.println("Invalid input");
			}
			
			if (v.getInEdges().size() <= 0 && ioChoice == IN_EDGES) {
				System.out.println("There are no incoming edges");
			}
			
			if (v.getOutEdges().size() <= 0 && ioChoice == OUT_EDGES) {
				System.out.println("There are no outgoing edges");
			}
		} while (ioChoice > 2 || ioChoice < 0 || (v.getInEdges().size() <= 0 && ioChoice == IN_EDGES) || (v.getOutEdges().size() <= 0 && ioChoice == OUT_EDGES));
		
		
		ArrayList<Edge> EDGE_ARRAY = null;
		if (ioChoice == 1) {EDGE_ARRAY = v.getInEdges();}
		else if (ioChoice == 2) {EDGE_ARRAY = v.getOutEdges();}
		
		
		//choose edge in specified in/out group
		int edgeChoice = 0;
		do {
			System.out.print("Choose an edge number: ");
			edgeChoice = scan.nextInt();
			if (edgeChoice > EDGE_ARRAY.size() || edgeChoice < 0) {
				System.out.println("Invalid input");
			}
		} while (edgeChoice > EDGE_ARRAY.size() || edgeChoice < 0);
		
		
		//in edges go to parent while out edges go to child
		if (ioChoice == 1) {vArray.add(EDGE_ARRAY.get(edgeChoice).getParent());}
		else if (ioChoice == 2) {vArray.add(EDGE_ARRAY.get(edgeChoice).getChild());}
		
		//System.out.print("\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b\b");
		System.out.flush();
		
		controlPanel(vArray, scan);
		
		
		
		
		
		//start at root
			//print out out/in edges
			//select o/i
			//select number
			//print out children and parents
			//repeat
	}

}
