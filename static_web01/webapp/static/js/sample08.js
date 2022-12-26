/*
 * 실시간 검사
 *      아이디는 6 ~ 12 자 사이의 값을 입력하였는지 실시간으로 검사하여 문제가 있는 경우
 *      붉은색 테두리와 에러 메세지로 사용자에게 즉시 알릴 수 있도록 하고, 정상 입력인 경우
 *      초록색 테두리와 정상 메세지로 사용자에게 알릴 수 있도록 한다.
 * 
 *      패스워드는 4 ~ 12 자 사이의 값을 입력하였는지 실시간으로 검사하여 위의 아이디와
 *      동일한 처리를 하도록 한다.
 * 
 *      패스워드 확인은 기존에 입력한 패스워드와 동일한 값인지를 실시간으로 검사하여 위의
 *      아이디와 동일한 처리를 하도록 한다.
 */

function usernameValid(e) {
    var username = e.target;
    if(username.value.length >= 6 && username.value.length <= 12) {
        username.style.borderColor = "green";
        username.style.borderWidth = "5px";
    } else {
        username.style.borderColor = "red";
        username.style.borderWidth = "5px";
    }
}

var form = document.forms[0];
form.username.addEventListener("input", usernameValid);
// 순서상 usernameValid보다 얘가 뒤로 와야함! 
// 코드는 순서대로 실행되므로, usernameValid라는 함수가 로드되어야 이 자리에서 제대로 동작하기 때문에.


function pass1Valid(e) {
    var pass1 = e.target;
    if(pass1.value.length >= 4 && pass1.value.length <= 12) {
        pass1.style.borderColor = "green";
        pass1.style.borderWidth = "5px";
    } else {
        pass1.style.borderColor = "red";
        pass1.style.borderWidth = "5px";
    }
}

var form = document.forms[0];
form.pass1.addEventListener("input", pass1Valid);

