package snake;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int boxRow = 6,boxCol = 6;
		int row =0, col =0;
		int bonusNos = 6;
		Snake sn = new Snake(boxRow,boxCol);
		sn.snakeMove(row, col);
		sn.setBonus(bonusNos);
		sn.printBox();
		while(true) {
			System.out.print("Enter the direction here : ");
			char inp = s.next().charAt(0);
			switch(inp) {
			case 'U' : sn.snakeMove(--row,col);
			break;
			case 'D' : sn.snakeMove(++row, col);
			break;
			case 'R' : sn.snakeMove(row,++col);
			break;
			case 'L' : sn.snakeMove(row, --col);
			break;
			}
			sn.printBox();
		}
	}
}
