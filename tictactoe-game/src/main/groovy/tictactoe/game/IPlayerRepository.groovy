package tictactoe.game

interface IPlayerRepository {
	List<IPlayer> getPlayers()
	IPlayer getPlayerById()
}
