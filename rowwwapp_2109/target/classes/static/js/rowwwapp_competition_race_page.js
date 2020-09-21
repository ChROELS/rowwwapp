
$(document).ready(function(){
    $(raceForm).hide();
});
$(document).ready(function(){
  $(buttonRaceInfosToggle).click(function(){
    $(raceForm).toggle(1000);
  });
});
function loadPageCompetitionRace() {
    window.location.assign("http://localhost:8080/rowwwapp/competition/race");

}
function loadPageCompensation(){
    window.location.assign("http://localhost:8080/rowwwapp/competition/compensation");
}


