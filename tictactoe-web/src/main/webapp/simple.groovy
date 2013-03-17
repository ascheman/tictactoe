import org.slf4j.LoggerFactory

def logger = LoggerFactory.getLogger("tictactoe.web.simple")

response.setCharacterEncoding("UTF-8")

if (!session) {
	logger.info("New session from IP {}", request.remoteHost)
	session = request.getSession(true);

	println """
<html>
    <head>
        <title>TicTacToe</title>
    </head>
    <body>
NEW
    </body>
</html>
"""
}
