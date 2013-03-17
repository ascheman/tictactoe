package tictactoe.web

class TicTacToeWebResponse {
	def out = null
	
	TicTacToeWebResponse(out) {
		this.out = out
	}

	private respond (String msg) {
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
	}
	
	void create () {
		respond ("NEW")
	}
	
	void help () {
		respond """<pre>
CMD=RESET           -	Reset board
CMD=SHOW            -	Show board
CMD=SET&field=value	-	Set 'value' to field with coordinates [A-C][1-3]
</pre>"""
	}
	
	void error (msg) {
		respond msg
	}
}
