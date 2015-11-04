function aqcallback(s) {
    document.getElementById('res').innerHTML=s;
}
var w = new Worker('mytask.js');
w.postMessage('go');
