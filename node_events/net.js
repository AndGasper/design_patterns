const net = require('net'); 
const EventEmitter = require('events'); 

class ErrorHandler extends EventEmitter {};

const errorHandler = new ErrorHandler(); 

errorHandler.on('error', () => {
    console.log("Oh no baby, what is you doing? There's been an error.");
});

const server = net.createServer((socket) => {
    socket.end("Goodbye\n");
}).on('error', (err) => {
    throw err; 
});

server.listen(() => {
    console.log("Opened server on", server.address());
});

server.on('error', (e) => {
    if (e.code === 'EADDRINUSE') {
        console.log("Address in use, retrying...");
        setTimeout(()=> {
            server.close(); // Close the connection
            server.listen(PORT,HOST);
        }, 1000);
    }
});