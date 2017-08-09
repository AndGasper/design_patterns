/**
 *
 * "When f is invoked, referencing a is slower than referencing b, which is slower than referencing c"
 * Baker, G.; Arvidsson, E. Best Practices: Optimizing JavaScript Code
 * Reference URL: https://developers.google.com/speed/articles/optimizing-javascript
 */

/**
 * If performance.timing.loadEventStart equals 0, then the load event has *not* been sent for the current document
 * Alternatively
 * (performance.timing.loadEventStart === 0) ? (loadEventHasBeenSentFor = true) : (loadEventHasBeenSentFor = false)
 */

var a = 'a';

function createFunctionWithClosure() {
    var b = 'b';
    return function () {
        var c = 'c';
        console.log("a, b, c");

        // console.log("performance.now() before the chained performance.measure()'s: ", performance.now());

        performance.measure(c);
        performance.measure(b);
        performance.measure(a);
    }
}
var f = createFunctionWithClosure();
f();
console.log(window.performance.getEntries());
var performanceMeasurementEntries = window.performance.getEntries();
console.log(performanceMeasurementEntries[1], performanceMeasurementEntries[2], performanceMeasurementEntries[3]);
/**
 * PerformanceMeasure {name: "c", entryType: "measure", startTime: 0, duration: 81.78500000000001}
 * PerformanceMeasure {name: "b", entryType: "measure", startTime: 0, duration: 81.805}
 * PerformanceMeasure {name: "a", entryType: "measure", startTime: 0, duration: 81.81}
 */
