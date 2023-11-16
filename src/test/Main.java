package test;

import java.util.ArrayList;

public class Main {

	private static Graph boardGraph = new Graph(null);

	public static void main(String[] args) {
		Character[][] board = new Character[3][3];
		
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = '-';
			}
		}
		// TODO Auto-generated method stub
		//Load.loading(20, 1000, 1);
	//	System.out.println(play_game(board, 'x', new Vertex(board)));
		//System.out.println(boardGraph);
		//System.out.print(boardGraph.getEdges().get(0).getParent().getOutEdges().get(0).getChild().getOutEdges());
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

}
