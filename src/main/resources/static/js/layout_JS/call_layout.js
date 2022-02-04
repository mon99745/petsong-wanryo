$(document).ready(function () {
    $("#headers").load("/src/main/resources/templates/layout/header.html");
    $("#footers").load("/src/main/resources/templates/layout/footer.html");
    $("#scrolls1").load("/src/main/resources/templates/layout/scroll1.html");
    $("#scrolls2").load("/src/main/resources/templates/layout/scroll2.html");
}
);
// 서버 측에 보여주기 위함
// 화면단 사용을 위해서는 위 주석을 풀어줘야 함
//$(document).ready(function () {
//    $("#headers").load("../layout/header.html");
//    $("#footers").load("../layout/footer.html");
//    $("#scrolls1").load("../layout/scroll1.html");
//    $("#scrolls2").load("../layout/scroll2.html");
//}
//);