package edu.sjsu.java.misc;

public class TicTacToe {

	public static void main(String[] args) {

		char[][] input = { { 'x', 'o', 'x' }, { 'x', ' ', 'x' },
				{ 'o', 'x', 'x' } };

		boolean winner = isWinner(input);
		System.out.println(winner);
	}

	public static boolean isWinner(char[][] arr) {
		if (arr == null) {
			return false;
		}

		boolean flag = false;

		for (int i = 0; i < arr.length; i++) {

			// check the rows
			if (arr[i][0] != ' ' && arr[i][0] == arr[i][1]
					&& arr[i][0] == arr[i][2]) {
				flag = true;
				break;
			}

			// check the colums
			if (arr[0][i] != ' ' && arr[0][i] == arr[1][i]
					&& arr[0][i] == arr[2][i]) {
				flag = true;
				break;
			}

			// check the diagonal
			if (arr[0][0] != ' ' && arr[0][0] == arr[1][1]
					&& arr[0][0] == arr[2][2]) {
				flag = true;
				break;
			}

			// check cross diagonal
			if (arr[0][2] != ' ' && arr[0][2] == arr[1][1]
					&& arr[0][2] == arr[2][0]) {
				flag = true;
				break;
			}
		}
		return flag;
	}

}
