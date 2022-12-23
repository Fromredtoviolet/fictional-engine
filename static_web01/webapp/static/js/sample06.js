function addItem(form, targetId) {
    var target = document.getElementById(targetId);
    var li = document.createElement("li");
    li.innerText = form.item.value;
    form.item.value = "";

    if(form.location.value === "f") {
        target.prepend(li);
    } else if(form.location.value === "e") {
        target.append(li);
    }    
}

function validCheck(form) {
    if(form.pass2.nextElementSibling !== null) {
        form.pass2.nextElementSibling.remove();
    }
    if(form.pass1.value !== form.pass2.value) {
        let span = document.createElement("span");
        span.innerText = "패스워드를 다시 확인하세요.";
        form.pass2.value = "";

        form.pass2.after(span);
        return false;
    }
}

// 번호는 tbody의 행수로 계산하여(tr의 수) +1씩 증가
// 조회수는 초기값 0
// 작성일은 new Date(); 를 활용하여 현재 날짜로.
function addRow() {

}
