$(document).ready(function(){
  $(compensationForm).hide();

});

  $(document).ready(function(){
    $(buttonCompensationToggle).click(function(){
      $(compensationForm).toggle(1000);
    });
  });
function loadPageCompensationRace() {
  window.location.assign("http://localhost:8080/rowwwapp/competition/compensation");

}
function loadPageResults(){
  window.location.assign("http://localhost:8080/rowwwapp/competition/results");
}

