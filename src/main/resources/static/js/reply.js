// 게시판에 대한 댓글, 댓글 CRUD에 해당하는 JS
'use strict';

let replyIndex = {
    init: function () {
        $("#reply-btn-save").on("click", () => {
            this.replySave();
        });
    },

    // 댓글 작성
    replySave: function () {
        let data = {
            content: $("#reply-content").val(),
        }
        let boardId = $("#boardId").val();
        console.log(data);
        console.log(boardId);
        $.ajax({
            type: "POST",
            url: `/api/v1/board/${boardId}/reply`,
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "text"
        }).done(function (res) {
            alert("댓글작성이 완료되었습니다.");
            location.href = `/board/${boardId}`;
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    },

    // 댓글 삭제
    replyDelete: function (boardId, replyId) {
        $.ajax({
            type: "DELETE",
            url: `/api/v1/board/${boardId}/reply/${replyId}`,
            dataType: "text"
        }).done(function (res) {
            alert("댓글삭제가 완료되었습니다.");
            location.href = `/board/${boardId}`;
        }).fail(function (err) {
            alert(JSON.stringify(err));
        });
    }

}
replyIndex.init();