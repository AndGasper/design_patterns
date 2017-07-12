const EventEmitter = require('events');

class SampleEmitter extends EventEmitter {}

const sampleEmitter = new SampleEmitter();
const sampleEmitterSynchronousSwitch = new SampleEmitter(); 

const eventTracker = new SampleEmitter(); 

const errorEvent = new SampleEmitter(); 



const eventListener = new SampleEmitter(); 
// The once event will occur before a listener is added to its intenral array of listenrs.
// So let's see what gets logged first! 
eventListener.once('newListener', (event, listener) => {
    if (event === 'event') {
        eventListener.on('event', () => {
            console.log("B. Inside of newListener"); // B inside 
            // See the B console log first
        });
    }
});

eventListener.on('event', () => {
    console.log("A. Inside of on callback");
    // See this A console log after new listener event
});


// emitter.emit(eventName[,...args])
// [] = optional stuff

eventListener.emit('event'); 

// process.on('uncaughtException', (err) => {
//     console.error("Oh no baby, what is you doin'?")
// });
// errorEvent.emit('error', new Error('oh no!')); // Without error handling, uncaught exception


// let m = 0;
// // eventTracker.on('event', () => {
// //     console.log(`This is the value of m: ${++m}`); // Incrememnt m first
// // });
// eventTracker.once('event', () => {
//     console.log(++m); // Output: 1; then it doesn't print again
// });


// eventTracker.emit('event');
// eventTracker.emit('event'); 

// sampleEmitter.on('event', function(a,b) {
//     console.log("An event has occurred.");
//     console.log(`a, b, this`, a, b, this);
// //     // a tuned out to just be "a"
// //     // Since I made b = null, null appeared
// //     /* this = SampleEmitter {
// //         domain: null,
// //         _events: {event: [Function] },
// //         _eventsCount: 1,
// //         _maxListeners: undefined }
// //     */
// });


// Arrow syntax scope resolution 
sampleEmitter.on('event', (a,b) => {
   console.log("a, b, this", a, b, this); // Fat arrow function scope resolution 
   // Output: a null {}
});

sampleEmitter.on('kittens', ()=>{
    console.log("Kittens event");
});

sampleEmitterSynchronousSwitch.on('event', (a,b) => {
    console.log("Log before the setImmediate");
    setImmediate(() => {
        console.log("setImmediate causes this to happen asynchronously");
    });
});

sampleEmitter.emit('event','a', null); 
sampleEmitter.emit('kittens');

sampleEmitterSynchronousSwitch.emit('event', 'a', 'b');



