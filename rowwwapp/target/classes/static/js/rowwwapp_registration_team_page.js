$(document).ready(function(){
  $(info).hide();
  $(teamForm).hide();
});
 
$(document).ready(function(){
    $(buttonInfosToggle).click(function(){
      $(info).toggle(1000);
    });
});
$(document).ready(function(){
    $(buttonTeamToggle).click(function(){
        $(teamForm).toggle(1000);
    });
});


  