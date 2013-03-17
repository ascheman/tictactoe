package tictactoe.core

import static org.junit.Assert.*
import org.junit.Test

class BoardTest {
	@Test 
	void testSetValue() {
		def board = new Board()
		def c = Coordinate.A3
		def v = Value.x
		board.setValue(c, v)
		assertEquals (v, board.getValue(c))
	}
	
	@Test
	void testToString() {
		def board = new Board()
		board.setValue(Coordinate.A2, Value.x)
		board.setValue(Coordinate.C3, Value.o)
		assertEquals ("A2=x, C3=o", board.toString())
	}
	
	@Test(expected=RuntimeException.class)
	void testExceptionForDuplicateSet() {
		def board = new Board()
		board.setValue(Coordinate.A2, Value.x)
		board.setValue(Coordinate.A2, Value.o)
	}
}
