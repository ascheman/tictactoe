package tictactoe.web

import org.slf4j.LoggerFactory

class TicTacToeWebResponse {
	enum RESPONSE_FORMAT {
		RAW, HTML
	}
	
	static def logger = LoggerFactory.getLogger("tictactoe.web.TicTacToeWebResponse")

	def out = null
	def responseFormat = RESPONSE_FORMAT.RAW
	def response = null

	TicTacToeWebResponse(out, response, params = null) {
		this.out = out
		if (params && params['FORMAT'] && params['FORMAT'] == "HTML") {
			this.responseFormat = RESPONSE_FORMAT.HTML
			logger.debug("HTML format chosen")
		} else {
			logger.debug("RAW format chosen")
		}
		this.response = response
	}

	private respond (String msg) {
		response.setCharacterEncoding("UTF-8")
		if (responseFormat == RESPONSE_FORMAT.HTML) {
			response.setContentType('text/html')
			out.println """
<html>
    <head>
        <title>TicTacToe</title>
    </head>
    <body>
${msg}
    </body>
</html>
"""
		} else {
			response.setContentType('text/plain')
			out.println(msg)
		}

	}
	
	void preFormat (msg) {
		if (responseFormat == RESPONSE_FORMAT.HTML) {
			respond """<pre>
$msg
</pre>
"""
		} else {
			respond msg
		}
	}

	void help () {
		preFormat """CMD=DESTROY                         -	Invalidate Session
CMD=HELP                            -	Show this help text
CMD=SET&coordinate=c&value=[xo]	    -	Set 'value' ('x' or 'o') to field with coordinates [A-C][1-3] 
CMD=SHOW                            -	Show board
CMD=RESET                           -	Reset board"""
	}

	void error (msg) {
		respond "ERROR: $msg"
	}

	void exception (msg) {
		respond "EXCEPTION: $msg"
	}

	void show(String status) {
		respond "FIELD: ${status}"
	}

	void ok() {
		respond "OK"
	}

	void destroyed() {
		respond "DESTROYED"
	}
}
