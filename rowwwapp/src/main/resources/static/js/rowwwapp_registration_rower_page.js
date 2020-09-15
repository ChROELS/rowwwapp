$(document).ready(function(){
    $(rowerForm).hide();
    $(info).hide();
});
$(document).ready(function(){
    $(buttonRowerToggle).click(function(){
      $(rowerForm).toggle(1000);
    });
  });
$(document).ready(function(){
    $(buttonInfosToggle).click(function(){
        $(info).toggle(1000);
    });
});

  