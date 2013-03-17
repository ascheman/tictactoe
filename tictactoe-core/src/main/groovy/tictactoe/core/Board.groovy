package tictactoe.core

class Board {
	private field = [
		A : [ 1 : null, 2 : null, 3 : null],
		B : [ 1 : null, 2 : null, 3 : null],
		C : [ 1 : null, 2 : null, 3 : null]
	]
	
	String toString () {
		String result = ""
		for (def x : field.keys) {
			for (def y : field[x].keys) {
				if (field[x][y] != null) {
					if ("" != result) {
						result += ", "
					}
					result += Coordinate.valueOf(x + y).toString() + "=" + field[x][y].toString()
				}
			}
		}
		return result
	}
}
