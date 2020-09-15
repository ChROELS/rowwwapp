
$(document).ready(function(){
  $(modifications).hide();
    $(modbuttons).hide();
    $(Forfeit).hide();

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
function loadPageRegistration(){window.location.assign("http://localhost:8080/rowwwapp/registration/team");}
function loadPageDownload() {
  window.location.assign("http://localhost:8080/rowwwapp/registration/results/document");
}
