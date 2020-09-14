$(document).ready(function(){
  $(raceForm).hide();
  $(rowerForm).hide();
});
 
$(document).ready(function(){
    $(buttonRaceToggle).click(function(){
      $(raceForm).toggle(1000);
    });
});
$(document).ready(function(){
    $(buttonRowerToggle).click(function(){
      $(rowerForm).toggle(1000);
    });
  });
$(document).ready(function(){
    $(buttonTeamToggle).click(function(){
        $(teamForm).toggle(1000);
    });
});
$(document).ready(function(){
    $(buttonAge).click(function(){
      $(buttonAge).after("<label>Age:</label><br/>"+ bir);
    });
  });     
  