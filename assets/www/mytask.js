importScripts('aqworker.js');

aqsetcbprefix('mycb');

self.addEventListener('message', function(ev) {
  if (ev.data === 'go') {
    aqrequest('as', 'df', 'fs,d=wl%23&fw=%4238s@fda', function(s) {
      self.postMessage('result: ' + s);
    });
  }
});
