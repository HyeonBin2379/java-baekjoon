package codekata.programmers;

public class BiggestSquare {

	private final int[][] moves = {{-1, 0}, {0, -1}, {-1, -1}};
	private int[][] newBoard;

	// board[x][y]: (x,y)가 오른쪽 아래 꼭짓점인 정사각형 한 변의 최대 길이
	public int solution(int[][] board) {
		setNewBoard(board);
		int answer = 0;
		for (int i = 1; i < newBoard.length; i++) {
			for (int j = 1; j < newBoard[0].length; j++) {
				if (board[i-1][j-1] >= 1) {
					newBoard[i][j] = getMinSize(i, j);
					answer = Math.max(newBoard[i][j], answer);
				}
			}
		}
		return answer*answer;
	}

	private void setNewBoard(int[][] board) {
		newBoard = new int[board.length+1][board[0].length+1];
		for (int i = 1; i < newBoard.length; i++) {
			System.arraycopy(board[i-1], 0, newBoard[i], 1, board[i-1].length);
		}
	}

	private int getMinSize(int x, int y) {
		int minSize = Integer.MAX_VALUE;
		for (int[] move : moves) {
			int nx = x+move[0];
			int ny = y+move[1];

			minSize = Math.min(newBoard[nx][ny], minSize);
		}
		return minSize+1;
	}

	public static void main(String[] args) {
		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
		int result = new BiggestSquare().solution(board);
		System.out.println(result);
	}
}
