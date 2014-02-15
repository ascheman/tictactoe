package tictactoe.impl.game.rest.client

import java.util.List

import tictactoe.core.Coordinate;
import tictactoe.core.IBoard;
import tictactoe.game.GameState;
import tictactoe.game.IGame;
import tictactoe.game.IMove;
import tictactoe.game.IPlayer;

class Game implements IGame {

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IPlayer getPlayer1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPlayer getPlayer2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IBoard getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameState getState() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void move(IPlayer player, Coordinate coordinate) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<IMove> getMoves() {
		// TODO Auto-generated method stub
		return null;
	}

}
