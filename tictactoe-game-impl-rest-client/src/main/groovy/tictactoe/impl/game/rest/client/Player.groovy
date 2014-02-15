package tictactoe.impl.game.rest.client

import tictactoe.core.Value
import tictactoe.game.IGame;
import tictactoe.game.IPlayer;

class Player implements IPlayer {
	
	private long id;
	private String name;
	
	public Player (long id, String name) {
		this.id = id
		this.name = name
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value getValue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGame newGameAsFirstPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGame newGameAsSecondPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGame newGameWithRandomStarter() {
		// TODO Auto-generated method stub
		return null;
	}

}
