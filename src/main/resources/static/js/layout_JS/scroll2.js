$(window).scroll(function(){
  var scrollTop = $(document).scrollTop();
  if (scrollTop < 180) {
   scrollTop = 200;
  }
  $("#sidebox2").stop();
  $("#sidebox2").animate( { "top" : scrollTop });
  });