import { saveMessageImpl } from 'App/Services/Impl/saveMessageImpl'
import Ws from 'App/Services/Ws'
Ws.boot()

const connectedClients: any = [];
Ws.io.on('connection', (socket) => {
	connectedClients.push(socket);	
	socket.on('sse-message-chat', (data) => {
		for (const client of connectedClients) {
			if (client !== socket) {
				client.emit('sse-message-chat-response', data);
			}
		}
	})
})
