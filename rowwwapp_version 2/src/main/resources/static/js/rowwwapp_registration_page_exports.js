
$(document).ready(function(){


});
$(document).ready(function(){
  $(buttonForfeitToggle).click(function(){
    $(Forfeit).toggle(1000);
  });
});
$(document).ready(function(){
  $(buttonModToggle).click(function(){
    $(modifications).toggle(1000);
    $(modbuttons).toggle(1000);
  });
});
function loadPageRegistration(){window.location.assign("http://localhost:8080/rowwwapp/registration/scheduledRace");}
function loadPageDatabase(){window.location.assign("http://localhost:8080/rowwwapp/console/");}
