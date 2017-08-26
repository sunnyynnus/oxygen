package careercup;

import java.util.*;

/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.
*/

public class BoardGames{

	public static void main(String[] args){
		char[][] board = {{'A', 'B', 'C', 'E'},{'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
		BoardGames bg= new BoardGames();
		System.out.println(bg.checkIfWordExistsInBoard(board, "ABCCED"));
		System.out.println(bg.checkIfWordExistsInBoard(board, "SEE"));
		System.out.println(bg.checkIfWordExistsInBoard(board, "ABCB"));
	}

	//Brute-force
	public boolean checkIfWordExistsInBoard(char[][] board, String word){
		
		for(int row=0; row< board.length; row++){
			for(int col=0; col < board[0].length; col++){
				if(board[row][col] == word.charAt(0)){
					Set<Pair> visited = new HashSet<>();
					visited.add(new Pair(row, col));
					if(checkIfExists(board, row, col, word, 1, visited)){
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean checkIfExists(char[][] board, int row, int col, String word, int index, Set<Pair> visited){
		
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length){
			return false;
		}

		if(index == word.length()){
			return true;
		}

		if(row+1 < board.length && board[row+1][col] == word.charAt(index) && !visited.contains(new Pair(row+1, col))){
			Set<Pair> visitedCopy = new HashSet<>(visited);
			visitedCopy.add(new Pair(row+1, col));
			if(checkIfExists(board, row+1, col, word, index+1, visitedCopy)){
				return true;
			}
		}
		if(row-1 >=0 && board[row-1][col] == word.charAt(index) && !visited.contains(new Pair(row-1, col))){
			Set<Pair> visitedCopy = new HashSet<>(visited);
			visitedCopy.add(new Pair(row-1, col));
			if(checkIfExists(board, row-1, col, word, index+1, visitedCopy)){
				return true;
			}
		}
		if(col+1 < board[0].length && board[row][col+1] == word.charAt(index) && !visited.contains(new Pair(row, col+1))){
			Set<Pair> visitedCopy = new HashSet<>(visited);
			visitedCopy.add(new Pair(row, col+1));
			if(checkIfExists(board, row, col+1, word, index+1, visitedCopy)){
				return true;
			}
		}
		if(col-1 >=0 && board[row][col-1] == word.charAt(index) && !visited.contains(new Pair(row, col-1))){
			Set<Pair> visitedCopy = new HashSet<>(visited);
			visitedCopy.add(new Pair(row, col-1));
			if(checkIfExists(board, row, col-1, word, index+1, visitedCopy)){
				return true;
			}
		}
		
		return false;
	}

private static class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}

	public boolean equals(Object o){
		if(o==this) return true;
		if(o instanceof Pair){
			Pair pair = (Pair)o;
			return this.x == pair.x && this.y == pair.y;
		}
		return false;
	}

	public int hashCode(){
		return 5*x+7*y;
	}

	public String toString(){
		return String.valueOf(x)+":"+String.valueOf(y);
	}
}
}
