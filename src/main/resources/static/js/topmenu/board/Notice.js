$( document ).ready(function() {
    $('.trigger').on('click', function() {
       $('.modal-wrapper').toggleClass('open');
      $('.page-wrapper').toggleClass('blur-it');
       return false;
    });
   
  });
   $('.modal-wrapper').draggable({
       handle: "#modal-top" });
  
  
  $(function() {
          $( "#modal-wrapper" ).draggable();
      });