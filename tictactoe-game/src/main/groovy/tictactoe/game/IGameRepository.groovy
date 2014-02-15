package tictactoe.game

import tictactoe.core.Value

interface IGameRepository {
	IGame getGameById()

	IGame newGameAsFirstPlayer(IPlayer player, Value value)
	IGame newGameAsSecondPlayer(IPlayer player, Value value)
	IGame newGameWithRandomStarter(IPlayer player, Value value)
	
	List<IGame> getOpenGames()
}
