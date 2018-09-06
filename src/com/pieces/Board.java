package com.pieces;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/*
 * For a space that is 'populated':
	Each cell with one or no neighbors dies, as if by solitude.
	Each cell with four or more neighbors dies, as if by overpopulation.
	Each cell with two or three neighbors survives.
	For a space that is 'empty' or 'unpopulated'
	Each cell with three neighbors becomes populated.
 */
public class Board {

	private Cell [] [] boardCells = new Cell [10] [10];
	
	public Board (){
		createAndActivateCells();
		drawBoard();
		updateCellStatuses();
		drawBoard();
	}
	
		//Populate cells to the number stated 
	public int createAndActivateCells () {
		
		int initPopulation = new BigDecimal(Math.random()*100).intValue();
		int activeCells = 0;
		
		for (int i = 0; i < boardCells.length; i++) {
				Cell cellCol [] = boardCells[i];
				for (int j = 0; j < cellCol.length; j++) {
					cellCol[j] = new Cell(i, j);
					if (activeCells < initPopulation)
						cellCol[j].setActive(true);
					activeCells++;
				}
			}
		return initPopulation;
		}
	
	public void updateCellStatuses() {
		for (int i = 0; i < boardCells.length; i++) {
			Cell cellCol [] = boardCells[i];
			
			for (int j = 0; j < cellCol.length; j++) {
				int activeNeighbours=0;
				Set<Cell> neighbourCells = returnNeighbours(cellCol[j]);
				activeNeighbours = getActiveNeighbourCount(neighbourCells);
				
				if (cellCol[j].isActive()) {
					if (activeNeighbours < 2 || activeNeighbours > 3)
						cellCol[j].setActive(false);
				} else {
					if(activeNeighbours == 3)
						cellCol[j].setActive(true);
				}
			}
		}
	}
	
	/*
	 * 	TO DO -this is bugged, needs work
	 */
	private int getActiveNeighbourCount(Set<Cell> neighbourCells) {
		int activeNeighbours=0;
		
		for(Cell  cell : neighbourCells){
			if(cell.isActive())
				activeNeighbours++;
		}
		return activeNeighbours;
	}

	public void drawBoard() {
		for (int i = 0; i < boardCells.length; i++) {
			Cell cellCol [] = boardCells[i];
			for (int j = 0; j < cellCol.length; j++) {
					cellCol[j].draw();
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
	public Cell [] [] getBoardCells() {
		return boardCells;
	}
	
	public Set<Cell> returnNeighbours (Cell singleCell) {
	
		Set<Cell> neighbours = new  HashSet();
		int x = singleCell.getxCoord();
		int y = singleCell.getyCoord();
		
		int leftOfx = x-1;
		int rightOfX = x+1;
		int topOfy = y-1;
		int BottomOfy = y+1;
		
		for (int xAxis = leftOfx;  xAxis <= rightOfX; xAxis++) {
			for (int yAxis = topOfy;  yAxis <= BottomOfy; yAxis++) {
				if (!(xAxis == x && yAxis == y)) {
					neighbours.add(new Cell(xAxis, yAxis));
				}
			}
			//System.out.println(" ");
		}
	return neighbours;
	}
	
	//Return count of active cells
	public int getTotalActiveCellCount() {
		int activeCells = 0;
		for (int i = 0; i < boardCells.length; i++) {
				Cell cellCol [] = boardCells[i];
				for (int j = 0; j < cellCol.length; j++) {
					if (cellCol[j].isActive())
						activeCells++;
				}
			}
		return activeCells;
	}
}
