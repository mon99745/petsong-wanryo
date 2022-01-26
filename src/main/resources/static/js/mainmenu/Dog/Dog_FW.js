

// -----------------------------------뉴스 슬라이드 쇼----------------------------------------

// -----------------------------------뉴스 슬라이드 쇼----------------------------------------

// -----------------------------------뉴스 슬라이드 쇼----------------------------------------
     var myImage = document.getElementById("mainImage");
            var imageArray = ["../../../static/image/Dog_FW/Dog_FW1.jpg",
                "../../../static/image/Dog_FW/Dog_FW2.jpg",
                "../../../static/image/Dog_FW/Dog_FW3.jpg",

            ];
            var imageIndex = 0;

            function changeImage() {
                myImage.setAttribute("src", imageArray[imageIndex]);
                imageIndex++;
                if (imageIndex >= imageArray.length) {
                    imageIndex = 0;
                }
            }
            setInterval(changeImage, 1500);


// -----------------------------------메뉴바 클릭시 하단 메뉴 변경
var top1 = $("#top1 > ul > li");     //각각의 버튼을 변수에 저장
var bottommainmiddle = $("#bottom-main-middle > div");//각각의 콘텐츠를 변수에 저장

//컨텐츠 내용을 숨겨주세요!
bottommainmiddle.hide().eq(0).show();

top1.click(function(){
  var target = $(this);         //버튼의 타겟(순서)을 변수에 저장
  var index = target.index();   //버튼의 순서를 변수에 저장
  top1.removeClass("active");    //버튼의 클래스를 삭제
  target.addClass("active");       //타겟의 클래스를 추가
  bottommainmiddle.css("display","none");
  bottommainmiddle.eq(index).css("display","block");

});


// -----------------------------------페이지 순서 버튼 클릭 시 메뉴 변경----------------------
var buttons = $(".buttons > ul > li");     //각각의 버튼을 변수에 저장
var bottommainmiddle = $("#bottom-main-middle > div");//각각의 콘텐츠를 변수에 저장

//컨텐츠 내용을 숨겨주세요!
bottommainmiddle.hide().eq(0).show();

buttons.click(function(){
  var target = $(this);         //버튼의 타겟(순서)을 변수에 저장
  var index = target.index();   //버튼의 순서를 변수에 저장
  buttons.removeClass("active");    //버튼의 클래스를 삭제
  target.addClass("active");       //타겟의 클래스를 추가
  bottommainmiddle.css("display","none");
  bottommainmiddle.eq(index).css("display","block");

});
   //뒤로 가기 기능
 // history.scrollRestoration = 'auto'; // default 설정값



// -------------------------------메뉴, 순서 버튼 클릭 시 현재 스크롤 위치 고정-----------------

$("#top1").click(function() {
  $("html, body").animate({ scrollTop: 1100}, "slow");
  return false;
});

$(".buttons").click(function() {
  $("html, body").animate({ scrollTop: 1100}, "slow");
  return false;
});


// ---------------------------------------하트, 장바구니 클릭 변환------------------


$(document).ready(function(){
            /*웹페이지 열었을 때*/
            $(".empty-heart").show();
            $(".red-heart").hide();
 
            /*img1을 클릭했을 때 img2를 보여줌*/
            $(".empty-heart").click(function(){
              
                 $(".red-heart").show();
                 $(".empty-heart").hide();
                  if(confirm("장바구니으로 이동하시겠습니까")==true){
                   location.href = "/src/main/resources/templates/TopMenu/wish.html";
                 }
                 else{
                   return false;
                 }
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

   