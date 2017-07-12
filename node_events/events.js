const EventEmitter = require('events');

class SampleEmitter extends EventEmitter {}

const sampleEmitter = new SampleEmitter();

sampleEmitter.on('event', function(a,b) {
    console.log("An event has occurred.");
    console.log(`a, b, this`, a, b, this);
});

sampleEmitter.emit('event','a', null); 