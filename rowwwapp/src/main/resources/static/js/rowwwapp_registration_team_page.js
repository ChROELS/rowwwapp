$(document).ready(function(){
  $(raceForm).hide();
  $(teamForm).hide();
});
 
$(document).ready(function(){
    $(buttonRaceToggle).click(function(){
      $(raceForm).toggle(1000);
    });
});
$(document).ready(function(){
    $(buttonTeamToggle).click(function(){
        $(teamForm).toggle(1000);
    });
});


  