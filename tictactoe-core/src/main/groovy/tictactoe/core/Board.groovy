package tictactoe.core

import org.slf4j.LoggerFactory


/**
 * @author ascheman
 *
 * TicTacToe-Board
 */
class Board implements Serializable {
	def logger = LoggerFactory.getLogger("tictactoe.core.Board") 
	
	private field = null
	
	public Board () {
		reset()
	}

	public void reset () {
		logger.debug("Resetting board!")
		field = [
			'A' : [ '1' : null, '2' : null, '3' : null],
			'B' : [ '1' : null, '2' : null, '3' : null],
			'C' : [ '1' : null, '2' : null, '3' : null]
		]
	}

	public String toString () {
		logger.debug ("Board has field '$field'")
		String result = ""
		for (def x : field.keySet()) {
			for (def y : field[x].keySet()) {
				def value = field[x][y]
				if (value != null) {
					if ("" != result) {
						result += ", "
					}
					result += Coordinate.valueOf(x + y).toString() + "=" + value.toString()
				}
			}
		}
		return result
	}
	
	public boolean isSet(Coordinate c) {
		def value = getValue(c)
		return null != value
	}

	public getValue (Coordinate c) {
		def x = c.getX()
		def y = c.getY()
		def row = field[x]
		if (null == row) {
			throw new RuntimeException ("This should never happen: There is no row for '$x'")
		}
		def value = row[y]
		return value
	}	

	public void setValue(Coordinate c, Value v) {
		if (isSet(c)) {
			throw new RuntimeException ("Value at ${c} is already set")
		}
		def x = c.getX()
		def y = c.getY()
		def row = field[x]
		row[y] = v
	}
}
