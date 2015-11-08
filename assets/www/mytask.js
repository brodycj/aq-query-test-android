self.addEventListener('message', function(ev) {
  var r = new XMLHttpRequest();
  //r.open("POST", "aqaq:asdf?afsd=%12&,s=23%3", true);
  r.open("POST", "file:///aqaq#as:df$a1?fs,d=wl%23&fw=%4238s@fda", true);
  r.send();
});
