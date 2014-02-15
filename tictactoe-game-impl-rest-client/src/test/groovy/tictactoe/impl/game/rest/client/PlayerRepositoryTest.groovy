package tictactoe.impl.game.rest.client

import org.junit.Test

class PlayerRepositoryTest {
	@Test
	void testRepository () {
		def repo = new PlayerRepository()
		def players = repo.getPlayers()
		assert (players != null)
//		print players
	}
	

}
