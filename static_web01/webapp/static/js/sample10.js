$(document).ready(function() {
    $("form button").on("click", addBookmark); //.on("이벤트명", 함수명/익명함수)
    $("form button").off("click", addBookmark);
    $("form button").one("click", addBookmark); // 한번만 동작. 일회용
    $("form button").hover(addBookmark, addBookmark); // 첫번째는 mouseenter에 동작, 두번째는 mouseleave에 동작
});
// $(document).ready(function()는 window.onload = function()했던것과 같은 기능을 한다!

function addBookmark(event) {
    var url = $(event.target.form.url).val();
    var name = $(event.target.form.name).val();

    var aTag = $("<a>").attr("href", url).text(name);
    var liTag = $("<li>");
    liTag.append(aTag);

    $(".bookmark-list").first().append(liTag);
}