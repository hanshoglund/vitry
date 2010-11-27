
function toggle() {    
  $("#TOC").stop(true, true).slideToggle(200);
}

$().ready(function(){
  $("#TOC").click(function() {
    toggle();
  });
  
  
});    
