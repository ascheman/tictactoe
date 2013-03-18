import org.slf4j.LoggerFactory

import tictactoe.core.Board
import tictactoe.core.Coordinate
import tictactoe.core.Value
import tictactoe.web.TicTacToeWebResponse


def logger = LoggerFactory.getLogger("tictactoe.web.simple")

webResponse = new TicTacToeWebResponse(out, response, params)

try {
	if (!session) {
		logger.debug("New session from IP '{}'", request.remoteHost)
		session = request.getSession(true)
	} else {
		logger.debug("Old session from IP '{}'", request.remoteHost)
	}

	def board = session.getAt("Board")

	if (null == board) {
		board = new Board()
		logger.debug("Add new board to session: '${board}'")
		session.putAt("Board",	board)
	} else {
		logger.debug("Retrieved Board: '${board}'")
	}

	if (params.isEmpty()) {
		webResponse.help()
		return
	}

	cmd =  params['CMD']

	if (!cmd || cmd == "SHOW") {
		webResponse.show(board.toString())
	} else if (cmd == "HELP") {
		webResponse.help()
	} else if (cmd == "RESET") {
		board.reset()
		webResponse.ok()
	} else if (cmd == "DESTROY") {
		session.invalidate()
		webResponse.destroyed()
	} else if (cmd == "SET") {
		def coordinateValue = params['coordinate']
		if (!coordinateValue) {
			webResponse.error("Parameter 'coordinate' is missing")
			return
		}
		Coordinate coordinate = Coordinate.valueOf(coordinateValue)
		if (board.isSet(coordinate)) {
			webResponse.error("Field at ${coordinate} is already occupied")
			return
		}
		def valueValue = params['value']
		if (!coordinateValue) {
			webResponse.error("Parameter 'value' is missing")
			return
		}
		Value value = Value.valueOf(valueValue)
		board.setValue(coordinate, value)
		webResponse.show(board.toString())
	} else {
		webResponse.error("Unknown command '${cmd}'")
	}
} catch (Exception error) {
	logger.error("Error: {}", error.message)
	webResponse.exception("'${error.message}'")
}