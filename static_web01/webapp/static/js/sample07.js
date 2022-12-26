/*
 * 아이디, 패스워드 검사 후 오류가 발생하는 경우 사용자 입력 폼에 에러 메세지가 담긴 span 태그를
 * 추가하고 입력 양식에는 테두리를 붉게 설정하여 사용자가 잘못된 입력이라는 것을 알 수 있도록 한다.
 * 
 * 아이디는 6자리 미만인 경우 오류가 발생하게 합니다.
 * 패스워드는 패스워드와 패스워드 확인이 동일하지 않을 때 오류가 발생하게 합니다.
 * 패스워드도 아이디처럼 4자리 미만인 경우 오류가 발생하게 합니다. 
 */
function validCheck(form) {
    var isValid = true;
    if(form.username.nextElementSibling !== null) {
        form.username.nextElementSibling.remove();
    }
    if(form.username.value.length < 6) {
        let span = document.createElement("span");
        span.innerText = "아이디는 6자리 이상 입력해야 합니다.";
        span.style.color = "red";
        form.username.style.borderColor = "red";
        form.username.after(span);
        isValid = false;
    }
    if(form.pass1.nextElementSibling !== null) {
        form.pass1.nextElementSibling.remove();
    }
    if(form.pass1.value.length < 4) {
        let span = document.createElement("span");
        span.innerText = "패스워드는 4자리 이상 입력해야 합니다.";
        span.style.color = "red";
        form.pass1.style.borderColor = "red";
        form.pass1.after(span);
        isValid = false;
    }
    if(form.pass2.nextElementSibling !== null) {
        form.pass2.nextElementSibling.remove();
    }
    if(form.pass1.value !== form.pass2.value) {
        let span = document.createElement("span");
        span.innerText = "패스워드를 다시 확인하세요.";
        span.style.color = "red";
        form.pass2.style.borderColor = "red";
        form.pass2.after(span);
        isValid = false;
    }
    return isValid;
}