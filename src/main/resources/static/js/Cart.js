$(document).ready(function(){
    /*웹페이지 열었을 때*/
    $(".empty-heart").show();
    $(".red-heart").hide();

    /*img1을 클릭했을 때 img2를 보여줌*/
    $(".empty-heart").click(function(){
        Swal.fire({
            title: '찜 완료!',
            imageUrl: '/src/main/resources/static/image/red-heart.png',
            imageWidth: 100,
            imageHeight: 100,
            imageAlt: 'Custom image',
        
            onAfterClose:() =>{
                $(".red-heart").show();
                $(".empty-heart").hide();
            }
          })     
         
    });

    /*img2를 클릭했을 때 img1을 보여줌*/
    $(".red-heart").click(function(){
         $(".empty-heart").show();
         $(".red-heart").hide();
    });
});


$(document).ready(function(){
    /*웹페이지 열었을 때*/
   $(".empty-cart").show();
    $(".full-cart").hide();

    /*img1을 클릭했을 때 img2를 보여줌*/
    $(".empty-cart").click(function(){
            
         $(".full-cart").show();
         $(".empty-cart").hide();
          if(confirm("관심상품으로 이동하시겠습니까")==true){
           location.href = "/src/main/resources/templates/TopMenu/wish.html";
         }
         else{
           return false;
         }
    });

    /*img2를 클릭했을 때 img1을 보여줌*/
    $(".full-cart").click(function(){
         $(".empty-cart").show();
         $(".full-cart").hide();
    });
});

