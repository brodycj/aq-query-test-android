self.addEventListener('message', function(ev) {
  var r = new XMLHttpRequest();
  r.open("POST", "aqaq:asdf?afsd=%12&,s=23%3", true);
  r.send();
});
