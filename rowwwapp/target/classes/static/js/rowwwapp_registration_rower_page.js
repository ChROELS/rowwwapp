$(document).ready(function(){
    $(rowerForm).hide();

});
$(document).ready(function(){
    $(buttonRowerToggle).click(function(){
      $(rowerForm).toggle(1000);
    });
  });
function loadPageRower(){
    window.location.assign("http://localhost:8080/rowwwapp/registration/rower");
}
function loadPageResults(){
    window.location.assign("http://localhost:8080/rowwwapp/registration/rower/results");
}

  