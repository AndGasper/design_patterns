/**
 *
 * "When f is invoked, referencing a is slower than referencing b, which is slower than referencing c"
 * Baker, G.; Arvidsson, E. Best Practices: Optimizing JavaScript Code
 * Reference URL: https://developers.google.com/speed/articles/optimizing-javascript
 */

var a = performance.now();

function createFunctionWithClosure() {
    var b = performance.now();
    return function () {
        var c = performance.now();
        console.log(a);
        console.log(b);
        console.log(c);
    }
}
var f = createFunctionWithClosure();
f();
// console.log(this);
// console.log(this.closure_lm_209428);
/*
 In dedicated workers created from a Window context, the value in the worker will be lower than performance.now()
 in the window who spawned that worker. It used to be the same as t0 of the main context, but this was changed.
 */
