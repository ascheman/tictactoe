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
