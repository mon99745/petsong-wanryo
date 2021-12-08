// 메뉴바 와 드롭박스에 마우스 커서 올라갈 경우 드롭박스 유지 , 마우스 커서 없을 시 자동 닫힘
// ----------------------DOG-------------------------
$(" #DOG ").mouseover(function () {
	$(" #drop1 ").addClass('show1');
})
$(" #drop1 ").mouseover(function () {
	$(" #drop1 ").addClass('show1');
})
$("#DOG").mouseleave(function () {
  $(" #drop1").removeClass('show1');
})
$("#drop1").mouseleave(function () {
  $(" #drop1").removeClass('show1');
})
//----------------------CAT---------------------------
$(" #CAT ").mouseover(function () {
	$(" #drop2 ").addClass('show2');
})
$(" #drop2 ").mouseover(function () {
	$(" #drop2 ").addClass('show2');
})
$("#CAT").mouseleave(function () {
  $(" #drop2").removeClass('show2');
})
$("#drop2").mouseleave(function () {
  $(" #drop2").removeClass('show2');
})
//----------------------LIVING---------------------------

$(" #LIVING ").mouseover(function () {
	$(" #drop3 ").addClass('show3');
})
$(" #drop3 ").mouseover(function () {
	$(" #drop3 ").addClass('show3');
})
$("#LIVING").mouseleave(function () {
  $(" #drop3").removeClass('show3');
})
$("#drop3").mouseleave(function () {
  $(" #drop3").removeClass('show3');
})
//----------------------FOOD---------------------------

$(" #FOOD ").mouseover(function () {
	$(" #drop4 ").addClass('show4');
})
$(" #drop4 ").mouseover(function () {
	$(" #drop4 ").addClass('show4');
})
$("#FOOD").mouseleave(function () {
  $(" #drop4").removeClass('show4');
})
$("#drop4").mouseleave(function () {
  $(" #drop4").removeClass('show4');
})
//----------------------COMMUNITY---------------------------

$(" #COMMUNITY ").mouseover(function () {
	$(" #drop5 ").addClass('show5');
})
$(" #drop5 ").mouseover(function () {
	$(" #drop5 ").addClass('show5');
})
$("#COMMUNITY").mouseleave(function () {
  $(" #drop5").removeClass('show5');
})
$("#drop5").mouseleave(function () {
  $(" #drop5").removeClass('show5');
})

// -----------------------------------뉴스 슬라이드 쇼----------------------------------------
     var myImage = document.getElementById("mainImage");
            var imageArray = ["/src/main/resources/static/image/product1.jpeg",
                "/src/main/resources/static/image/product2.jpeg",
                "/src/main/resources/static/image/product3.jpeg",
                "/src/main/resources/static/image/product4.jpeg",
                "/src/main/resources/static/image/product5.jpg"

            ];
            var imageIndex = 0;

            function changeImage() {
                myImage.setAttribute("src", imageArray[imageIndex]);
                imageIndex++;
                if (imageIndex >= imageArray.length) {
                    imageIndex = 0;
                }
            }
            setInterval(changeImage, 2000);