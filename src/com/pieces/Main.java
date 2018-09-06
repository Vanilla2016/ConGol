package com.pieces;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		for (int i = 0; i < 10; i++){
			
			Board board = new Board();
			System.out.println(board.getTotalActiveCellCount() +" ");
			Thread.sleep(1000);
			//System.out.println("EXIT");
		}
	}
}
