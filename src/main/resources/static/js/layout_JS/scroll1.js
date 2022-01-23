$(window).scroll(function(){
  var scrollTop = $(document).scrollTop();
  if (scrollTop < 180) {
   scrollTop = 200;
  }
  $("#sidebox1").stop();
  $("#sidebox1").animate( { "top" : scrollTop });
  });