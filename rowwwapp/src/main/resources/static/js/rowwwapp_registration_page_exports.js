
$(document).ready(function(){
  $(modifications).hide();
    $(modbuttons).hide();
    $(Exports).hide();
    $(Forfeit).hide();
    $(forfait2).hide(); 
});
$(document).ready(function(){
  $(buttonExportToggle).click(function(){
    $(Exports).toggle(1000);
  });
});
$(document).ready(function(){
  $(buttonForfeitToggle).click(function(){
    $(Forfeit).toggle(1000);
    $(forfait2).toggle(1000);
  });
});
$(document).ready(function(){
  $(buttonmodToggle).click(function(){
    $(modifications).toggle(1000);
    $(modbuttons).toggle(1000);
  });
});
$(document).ready(function(){
  $(buttonAge).click(function(){
    $(buttonAge).after("<label>Age:</label><br/>"+ bir);
  });
});

