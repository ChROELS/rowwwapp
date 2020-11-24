$(document).ready(function(){

});
$(document).ready(function(){
    $(buttonTeamToggle).click(function(){
        $(teamForm).toggle(1000);
    });
});
function loadPageResults(){
    window.location.assign("http://localhost:8080/rowwwapp/competition/results");
}
function loadPageTeam(){
    window.location.assign("http://localhost:8080/rowwwapp/competition/team");
}
$(document).ready(function(){
$(function(){
    $("#repeater").createRepeater();
});
});
  