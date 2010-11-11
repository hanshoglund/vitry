var tocVisible = false;

function toc(status) {  
  tocVisible = status;
    
    if(status) {
      $('html').animate({
        scrollTop: 0
      }, 200);

      $('#toc-toggle').html("Hide table of contents");
      
      $("#content").animate({
        "margin-left": "+=250",
        "max-width": "-=250"
      }, 200, function() {
        $("#TOC").fadeIn(200);
      });
      
      
    } else {
      $('#toc-toggle').html("Show table of contents");
      
      $("#TOC").fadeOut(200, function() {
        $("#content").animate({
          "margin-left": "-=250",
          "max-width": "+=250"
        }, 200);
      });
      
    }
}

function toggle() {
    toc(!tocVisible);
}
