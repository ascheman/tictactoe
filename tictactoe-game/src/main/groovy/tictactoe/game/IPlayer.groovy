package tictactoe.game

import tictactoe.core.Value

interface IPlayer {
	long getId()
	String getName()
	
	Value getValue()
	
	IGame newGameAsFirstPlayer()
	IGame newGameAsSecondPlayer()
	IGame newGameWithRandomStarter()
}
