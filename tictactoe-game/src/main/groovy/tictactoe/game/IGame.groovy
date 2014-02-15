package tictactoe.game

import tictactoe.core.Coordinate
import tictactoe.core.IBoard

interface IGame {
	long getId()
	IPlayer getPlayer1()
	IPlayer getPlayer2()
	
	IBoard getBoard()
	GameState getState ()
	void move(IPlayer player, Coordinate coordinate)
}
