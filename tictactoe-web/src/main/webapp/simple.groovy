import org.slf4j.LoggerFactory

import tictactoe.core.Board
import tictactoe.core.Coordinate
import tictactoe.core.Value
import tictactoe.web.TicTacToeWebResponse

def logger = LoggerFactory.getLogger("tictactoe.web.simple")

response.setCharacterEncoding("UTF-8")

webResponse = new TicTacToeWebResponse(out)

def board = null
if (!session) {
	logger.info("New session from IP {}", request.remoteHost)
	session = request.getSession(true)

	webResponse.create()
	board = new Board()
	logger.debug("Add new board to session: '${board}'")
	session.putAt("Board",	board)
	
	return
} else {
	board = session.getAt("Board")
	logger.debug("Retrieved Board: '${board}'")
}

logger.debug("Finally using board '${board}'")

if (params.isEmpty()) {
	webResponse.help()
	return
}

cmd =  params['CMD']

if (!cmd) {
	webResponse.error("No CMD parameter given")
} else if (cmd == "HELP") {
	webResponse.help()
} else if (cmd == "SHOW") {
	webResponse.show(board.toString())
} else if (cmd == "RESET") {
	board.reset()
	webResponse.ok()
} else if (cmd == "DESTROY") {
	session.invalidate()
	webResponse.destroyed()
} else if (cmd == "SET") {
	Coordinate coordinate = Coordinate.valueOf(params['coordinate'])
	Value value = Value.valueOf(params['value'])
	board.setValue(coordinate, value)
	webResponse.show(board.toString())
} else {
	webResponse.error("Unknown command '${cmd}'")
}