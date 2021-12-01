$(function() {
    var lnb = $("#top").offset().top;
   
    $(window).scroll(function() {
     
      var window = $(this).scrollTop();
      
      if(lnb <= window) {
        $("#top").addClass("fixed");
      }else{
        $("#top").removeClass("fixed");
      }
    })
  });

$(function() {
    var lnb = $("#menu").offset().top;
   
    $(window).scroll(function() {
     
      var window = $(this).scrollTop();
      
      if(lnb <= window) {
        $("#menu").addClass("fixed");
      }else{
        $("#menu").removeClass("fixed");
      }
    })
  });