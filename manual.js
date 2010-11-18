var tocVisible = false;

function toggle() {
  
  tocVisible = !tocVisible;
    
    if(tocVisible) {
      $('html').animate({
        scrollTop: 0
      }, 200);

      $('#toc-toggle').html("Hide table of contents");
      
      $("#content").stop(true, true).animate({
        "margin-left": "+=250",
        "max-width": "-=250"
      }, 200, function() {
        if (tocVisible)
          $("#TOC").fadeIn(200);
      }); 
      
    } else {
      $('#toc-toggle').html("Show table of contents");
      
      $("#TOC").stop(true, true).fadeOut(200, function() {
        $("#content").stop(true, true).animate({
          "margin-left": "-=250",
          "max-width": "+=250"
        }, 200);
      });
    }
}

// Read a page's GET URL variables and return them as an associative array.
function getUrlVars()
{
    var vars = [], hash;
    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');

    for(var i = 0; i < hashes.length; i++)
    {
        hash = hashes[i].split('=');
        vars.push(hash[0]);
        vars[hash[0]] = hash[1];
    }

    return vars;
}


