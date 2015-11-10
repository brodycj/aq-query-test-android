var w = new Worker('mytask.js');
aqworker('cbh1', w);

w.addEventListener('message', function(ev) {
  document.getElementById('res').innerHTML=ev.data;
});

w.postMessage('go');
