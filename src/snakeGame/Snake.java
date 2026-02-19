package snakeGame;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Snake {
	private char[][] snakeBoard = null;

	private Queue<Node> snakePos = new LinkedList<Node>();
	private Queue<Node> foodPos = new LinkedList<Node>();

	Snake(int row, int col) {
		snakeBoard = new char[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				snakeBoard[i][j] = '-';
			}
		}

		snakePos.offer(new Node(0, 0));

		foodPos.offer(new Node(1, 0));
		foodPos.offer(new Node(2, 2));
		foodPos.offer(new Node(3, 4));
		foodPos.offer(new Node(5, 2));
		foodPos.offer(new Node(4, 5));

		displayFood(foodPos.poll());

	}

	public void initialSnake() {
		int row = 0;
		int col = 0;
		snakeBoard[row][col] = '|';

		Scanner sc = new Scanner(System.in);

		while (true) {
			printSnake();

			char direction = sc.next().charAt(0);

			if (direction == 'U') {
				snakeMove(--row, col);
			}
			if (direction == 'D') {
				snakeMove(++row, col);
			}
			if (direction == 'L') {
				snakeMove(row, --col);
			}
			if (direction == 'R') {
				snakeMove(row, ++col);
			}
		}
	}

	public void snakeMove(int row, int col) {
		if (row >= 0 && row < snakeBoard.length && col >= 0 && col < snakeBoard[0].length) {

			if (snakeBoard[row][col] != 'X') {
				Node tail = snakePos.poll();
				int tailRow = tail.getRow();
				int tailCol = tail.getCol();
				snakeBoard[tailRow][tailCol] = '-';
			}

			if (snakeBoard[row][col] == '|') {
				System.out.println("Game Over!!!!");
				System.exit(0);
			}

			if (snakeBoard[row][col] == 'X') {

				if (foodPos.isEmpty()) {
					moveForwardAndPrint(row, col);
					printSnake();
					System.out.println("You Win!!!!");
					System.exit(0);
				}

				moveForwardAndPrint(row, col);
				displayFood(foodPos.poll());
				return;
			}

			moveForwardAndPrint(row, col);
		} else {
			System.out.println("Invalid Move");
			System.exit(0);
		}
	}

	public void moveForwardAndPrint(int row, int col) {
		snakeBoard[row][col] = '|';
		snakePos.offer(new Node(row, col));
	}

	public void displayFood(Node node) {
		int r = node.getRow();
		int c = node.getCol();
		snakeBoard[r][c] = 'X';
	}

	public void printSnake() {
		for (char[] chars : snakeBoard) {
			for (int j = 0; j < snakeBoard[0].length; j++) {
				System.out.print(chars[j] + " ");
			}

			System.out.println();
		}
	}

}
