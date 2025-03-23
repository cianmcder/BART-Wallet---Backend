The main class is WalletApplication.java. The edited-out sections are related earlier testing that were removed when I began the Unit Testing file.

The system is set to run on localhost:8080

The commands (preceded with localhost:8080):
/wallet/find/all							-retrieves all wallets added
/wallet/find/{id}							-retrieves the wallet specified by entered id
/wallet/new								-create a new wallet
/wallet/delete/{id}							-delete wallet of specified id
/wallet/{id}/deposit/deposit={depo}					-deposits the entered amount of money into the wallet
/trainstation/origin={origin}&destination={destination}			-takes an origin and destination from a 4-letter representation of each BART station.
										Returns a json object in string format containing fare, origin, and destination
/wallet/{id}/buyticket/origin={origin}&destination={destination}	-takes a wallet id, station origin and destination. Returns a Ticket object and removes
										fare from Wallet

There are also some test cases for these commands under src/test/java.