package snake;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

public class Snake {
	int boxRow, boxCol;
	char[][] box = null;
	Queue<Node> q = new LinkedList<Node>();
	Snake(int boxRow, int boxCol){
		this.boxRow = boxRow;
		this.boxCol = boxCol;
		char[][] box = new char[boxRow][boxCol];
		for(int i=0; i<boxRow; i++) Arrays.fill(box[i],'#');
		this.box = box;
		
		q.add(new Node(0,0));
	}
	public void setBonus(int bonusNos) {
		for(int i=0; i<bonusNos; i++) {
			Random random = new Random();
			int max = boxRow-1;
			int min = 1;
			box[random.nextInt((max-min)+1)+min][random.nextInt((max-min)+1)+min] = 'X';
		}
	}
	public void snakeMove(int row, int col) {
		if(row<box.length && row>=0 && col < box[0].length && col>=0) {
			if(box[row][col] == '*') {
				System.out.println("GAME OVER ! SNAKE BITTEN ITSELF");
				System.exit(0);
			}
			q.add(new Node(row,col));
			
			if(box[row][col] != 'X') {
				Node node = q.poll();
				int r = node.getRow();
				int c = node.getCol();
				box[r][c] = '#';
			}
			box[row][col] = '*';
		}
		else {
			System.out.println("GAME OVER ! SNAKE BITTEN THE BOX");
			System.exit(0);
		}
	}
	
	public void printBox() {
		for(int i=0; i<boxRow; i++) {
			for(int j=0; j<boxCol; j++) {
				System.out.print(box[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
