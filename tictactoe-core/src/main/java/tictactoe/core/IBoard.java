package tictactoe.core;

public interface IBoard {

	public abstract void reset();

	public abstract boolean isSet(Coordinate c);

	public abstract Value getValue(Coordinate c);

	public abstract void setValue(Coordinate c, Value v);

}