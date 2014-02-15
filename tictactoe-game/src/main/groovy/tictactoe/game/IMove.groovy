package tictactoe.game

import tictactoe.core.Coordinate

interface IMove {
	IPlayer getPlayer()
	Coordinate getCoordinate()
}
