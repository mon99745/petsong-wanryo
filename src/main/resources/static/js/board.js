// 게시판에 대한 글, 글의 CRUD에 해당하는 JS
'use strict';

let index = {
    init: function () {
        // 글 작성
        $("#btn-save").on("click", () => {
            this.save();
        });
        // 글 삭제
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        // 글 수정
        $("#btn-update").on("click", () => {
            this.update();
        });
    },
    // 글 작성
    save: function () {
        let data = {
            title: $("#title").val(),
            content: $("#content").val(),
        }

        $.ajax({
            type: "POST",
            url: "/api/v1/board",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("글작성이 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });


    },

    // 글 삭제
    // 삭제같은 경우는 data가 필요가없고 id만 필요
    // board-detail.html에서 글 번호로 id값을 받음.
    // let id = $("#id").text();에서 뒤에 val()가 아니라 text()라는 점을 주의하면 됩니다. input 태그가 아니기 때문
    deleteById: function () {
        let id = $("#id").text();

        $.ajax({
            type: "DELETE",
            url: "/api/v1/board/" + id,
            dataType: "json"
        }).done(function (res) {
            alert("글삭제가 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

    // 글 수정
    update: function () {
        let id = $("#id").val();

        let data = {
            title: $("#title").val(),
            content: $("#content").val()
        }

        $.ajax({
            type: "PUT",
            url: "/api/v1/board/" + id,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (res) {
            alert("글수정이 완료되었습니다.");
            location.href = "/";
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    }
}
index.init();