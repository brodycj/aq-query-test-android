function a1(s) {
    document.getElementById('a1').innerHTML=s;
}
var w = new Worker('mytask.js');
w.postMessage('go');
