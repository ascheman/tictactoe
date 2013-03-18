package tictactoe.web

class TicTacToeWebResponse {
	enum RESPONSE_FORMAT {
		RAW, HTML
	}

	def out = null
	def responseFormat = RESPONSE_FORMAT.RAW
	def response = null

	TicTacToeWebResponse(out, response, params = null) {
		this.out = out
		if (params && params['TYPE'] && params['TYPE'] == "HTML") {
			this.responseFormat = RESPONSE_FORMAT.HTML
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

	void create () {
		respond ("NEW")
	}

	void help () {
		respond """<pre>
CMD=DESTROY							-	Invalidate Session
CMD=RESET                           -	Reset board
CMD=SET&coordinate=c&value=[xo]	    -	Set 'value' ('x' or 'o') to field with coordinates [A-C][1-3] 
CMD=SHOW                            -	Show board
</pre>"""
	}

	void error (msg) {
		respond msg
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
