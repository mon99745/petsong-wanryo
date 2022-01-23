
    // ---------------------------------메뉴바 상단 고정시키기 기능-------------------
    window.onscroll = function () { myFunction() };

    var header = document.getElementById("menu");
    var sticky = header.offsetTop;

    function myFunction() {
        if (window.pageYOffset > sticky) {
            header.classList.add("sticky");
        } else {
            header.classList.remove("sticky");
        }
    }


    // 메뉴바 와 드롭박스에 마우스 커서 올라갈 경우 드롭박스 유지 , 마우스 커서 없을 시 자동 닫힘
    $(" #Main_drop ").mouseover(function () {
        $(" #drop ").addClass('show');
    })
    $(" #drop ").mouseover(function () {
        $(" #drop ").addClass('show');
    })
    $("#Main_drop").mouseleave(function () {
        $(" #drop").removeClass('show');
    })
    $("#drop").mouseleave(function () {
        $(" #drop").removeClass('show');
    })




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



