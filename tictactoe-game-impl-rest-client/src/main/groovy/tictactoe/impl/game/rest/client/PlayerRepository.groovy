package tictactoe.impl.game.rest.client

import groovyx.net.http.RESTClient
import tictactoe.game.IPlayer
import tictactoe.game.IPlayerRepository

class PlayerRepository implements IPlayerRepository {

	@Override
	public List<IPlayer> getPlayers() {
		def repository = new RESTClient( 'http://192.168.2.24:8080/TicTacWildfy-0.0.1-SNAPSHOT/rest/player' )

		def response = repository.get(path : 'player')
		def players = response.data
		def result = new ArrayList<IPlayer>()
		players.each {
			result.add(new Player(it.id, it.name))
		}
		return result
	}

	@Override
	public IPlayer getPlayerById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static main (args) {
		def repo = new PlayerRepository()
		def players = repo.getPlayers()
		print players
	}

}
