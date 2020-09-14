$(document).ready(function(){
    $(formModification).hide();
    $(formExports).hide();
});
$(document).ready(function(){
$(ButtonModificationToggle).click(function(){
  $(formModification).toggle(1000);
});
});
$(document).ready(function(){
    $(ButtonPrintToggle).click(function(){
      $(formExports).toggle(1000);
    });
    });
 function loadCompetitionXls() {
     window.location.assign("http://localhost:8080/rowwwapp/competition/documents/competition");
 }
 function loadCompetitionCsv() {
     window.location.assign("http://localhost:8080/rowwwapp/competition/documents/competition");
 }
 function loadRaceXls() {
     window.location.assign("http://localhost:8080/rowwwapp/competition/documents/race");
 }
 function loadRaceCsv() {
     window.location.assign("http://localhost:8080/rowwwapp/competition/documents/race");
 }