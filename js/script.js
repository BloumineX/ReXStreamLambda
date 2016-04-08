(function() {
  'use strict';

  document.body.addEventListener("contextmenu", function(event) {
    event.preventDefault();
    Reveal.next();
    return false;
  });
})();