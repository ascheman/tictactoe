package tictactoe.core;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author ascheman
 *
 * TicTacToe-Board
 */
public class Board implements Serializable, IBoard {
	/**
	 * 
	 */
	private static final long serialVersionUID = -614038128648985161L;

	Logger logger = LoggerFactory.getLogger("tictactoe.core.Board"); 
	
	private Value field[][] = null;
	
	public Board () {
		reset();
	}

	/* (non-Javadoc)
	 * @see tictactoe.core.IBoard#reset()
	 */
	@Override
	public void reset () {
		logger.debug("Resetting board!");
		field = new Value[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				field[i][j] = null;
			}
		}
	}

	public String toString () {
		StringBuffer result = null;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (null != field[i][j]) {
					if (null == result) {
						result = new StringBuffer();
					} else {
						result.append (", ");
					}
//					Coordinate currentCoordinate = Coordinate.valueFrom(i, j);
					Coordinate currentCoordinate = Coordinate.valueOf(i, j);
					result.append(currentCoordinate.toString() + "=" + field[i][j]);
				}
			}
		}
		return null != result ? result.toString() : "";
	}
	
	/* (non-Javadoc)
	 * @see tictactoe.core.IBoard#isSet(tictactoe.core.Coordinate)
	 */
	@Override
	public boolean isSet(Coordinate c) {
		Value value = getValue(c);
		return null != value;
	}

	/* (non-Javadoc)
	 * @see tictactoe.core.IBoard#getValue(tictactoe.core.Coordinate)
	 */
	@Override
	public Value getValue (Coordinate c) {
		int x = c.getXcartesian();
		int y = c.getYcartesian();
		Value[] row = field[x];
		Value value = row[y];
		return value;
	}	

	/* (non-Javadoc)
	 * @see tictactoe.core.IBoard#setValue(tictactoe.core.Coordinate, tictactoe.core.Value)
	 */
	@Override
	public void setValue(Coordinate c, Value v) {
		if (isSet(c)) {
			throw new RuntimeException ("Value at '" + c + "' is already set");
		}
		int x = c.getXcartesian();
		int y = c.getYcartesian();
		field[x][y] = v;
	}
}
