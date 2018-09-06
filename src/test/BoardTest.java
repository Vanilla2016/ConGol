package test;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import com.pieces.Board;
import com.pieces.Cell;

public class BoardTest {
	
	Cell neighCell;
	
	@Test
	public final void testCellArrayPopulatedWithCorrectRandomValue() {
		Board testBoard = new Board();
		//Call the initialisation method again independently
		assertEquals(testBoard.createAndActivateCells(), testBoard.getTotalActiveCellCount());
	}
	
	@Test
	public final void testReturnNeigbours() {
		Board testBoard = new Board();
		
		Set<Cell> neighbours = testBoard.returnNeighbours(new Cell(1,1));
			
		assertTrue(neighbours.contains(new Cell(0,0)));
		assertTrue(neighbours.contains(new Cell(0,1)));
		assertTrue(neighbours.contains(new Cell(0,2)));
		assertTrue(neighbours.contains(new Cell(1,0)));
		assertFalse(neighbours.contains(new Cell(1,1)));
		assertTrue(neighbours.contains(new Cell(1,2)));
		assertTrue(neighbours.contains(new Cell(2,0)));
		assertTrue(neighbours.contains(new Cell(2,1)));
		assertTrue(neighbours.contains(new Cell(2,2)));
		assertFalse(neighbours.contains(new Cell(2,3)));
		assertFalse(neighbours.contains(new Cell(-2,-3)));
		assertFalse(neighbours.contains(new Cell(-1,-1)));
		
	}
}
