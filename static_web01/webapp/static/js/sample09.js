window.onload = function() {
    form = document.forms[0];
    createMonthOption();
    form.username.addEventListener("blur", function(e) { requiredValid(e); });
    form.username.addEventListener("change", function(e) { lengthValid(e, 5, 20, "{1}~{2}자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다."); });
                                                                                    // {}로 포맷팅 따로 해줘야함 (맨밑에 스크롤 내리면 있음)
    form.username.addEventListener("change", function(e) { charValid(e, "5~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.", lower=true, upper=false, number=true, special=true, specialChar="_-"); });
    // blur는 focus에서 벗어났을 때, change는 값이 변경되었을 때

    form.password[0].addEventListener("blur", function(e) { requiredValid(e); });
    form.password[0].addEventListener("change", function(e) { lengthValid(e, 8, 16, "{1}~{2}자의 영문 대 소문자, 숫자와 특수문자를 사용하세요."); });
                                                                                    // {}로 포맷팅 따로 해줘야함 (맨밑에 스크롤 내리면 있음)
    form.password[0].addEventListener("change", function(e) { charValid(e, "8~16자의 영문 대소문자, 숫자, 특수문자를 사용하세요.", lower=true, upper=true, number=true, special=true); });

    form.password[1].addEventListener("blur", function(e) { requiredValid(e); });
    form.password[1].addEventListener("change", function(e) { lengthValid(e, 8, 16, "{1}~{2}자의 영문 대 소문자, 숫자와 특수문자를 사용하세요."); });
    form.password[1].addEventListener("change", function(e) { equalValue(e, form.password[0]) });
};

function createAuthNumber() {
    var num = (Math.random() * 9000 + 1000).toFixed(0); // 랜덤번호 생성
    alert(num); // 알람으로 띄우기
    form.authNumber.disabled = false; // 인증번호 입력칸 비활성화 해제
    form.submitButton.disabled = true; // 가입하기 버튼 비활성화
    validReset(form.authNumber); // 인증번호 또 받으면 리셋
    form.authNumber.value = "";
    form.authNumber.addEventListener("change", function (e) {
        if(e.target.value == num) {
            validMessage(e.target, "인증 번호가 일치 합니다.");
            form.submitButton.disabled = false; // 가입하기 버튼 다시 활성화
        } else {
            errorMessage(e.target, "인증 번호가 일치하지 않습니다.");
        }
    });
}

function createMonthOption() {
    for(let m = 1; m <= 12; m++) {
        let option = document.createElement("option");
        option.innerText = m + "월";
        option.value = m;
        form.month.append(option);
    }
}

function requiredValid(event) {
    var inputElement = event.target;
    if(inputElement.value === "") {
        errorMessage(inputElement, "필수 입력 입니다.");
    }
}

function lengthValid(event, min, max, message) {
    var inputElement = event.target;
    if(inputElement.value.length < min || inputElement.value.length > max) {
        errorMessage(inputElement, format(message, min, max));
        event.stopImmediatePropagation();
    } else {
        validMessage(inputElement, "정상입니다.");
    }
}

function equalValue(event, other) {
    var inputElement = event.target;
    if(inputElement.value === other.value) {
        validMessage(inputElement, "정상입니다.");
    } else {
        errorMessage(inputElement, "비밀번호를 다시 확인하세요.");
    }
}

function charValid(event, message, lower=false, upper=false, number=false, special=false, specialChar="") {
    /**
     * {lower: true, upper: true, number: true, special: true, specialChar: "_-"}
     */
    var inputElement = event.target;
    var isLower = lower ? lowerCheck(inputElement.value) : !lowerCheck(inputElement.value);
    var isUpper = upper ? upperCheck(inputElement.value) : !upperCheck(inputElement.value);
    var isNumber = number ? numberCheck(inputElement.value) : !numberCheck(inputElement.value);
    var isSpecial = special ? specialCheck(inputElement.value, specialChar) : !specialCheck(inputElement.value, specialChar);

    if(isLower && isUpper && isNumber && isSpecial) {
        validMessage(inputElement, "정상입니다.");
    } else {
        errorMessage(inputElement, message);
    }
}

function specialCheck(string, specialChar = "") {
    var specialCharList = ["~", "!", "`", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "[", "]", "{", "}", ";", "'", ":", "\"", ".", "/", "<", ">", "?", "\\", "|"];
    for(let idx = 0; idx < specialCharList.length; idx++) {
        if(string.indexOf(specialCharList[idx]) >= 0) {
            if(specialChar !== "") {
                if(specialChar.indexOf(specialCharList[idx]) === -1) {
                    return false;
                }
            }
        }
    }
    return true;
}

function lowerCheck(string) {
    return charRangeCheck(string, "a".charCodeAt(0), "z".charCodeAt(0));
}

function upperCheck(string) {
    return charRangeCheck(string, "A".charCodeAt(0), "Z".charCodeAt(0));
}

function numberCheck(string) {
    return charRangeCheck(string, "0".charCodeAt(0), "9".charCodeAt(0));
}

function charRangeCheck(string, min, max) {
    for(let idx = 0; idx < string.length; idx++) {
        if(string.charCodeAt(idx) >= min && string.charCodeAt(idx) <= max) {
            return true;
        }
    }
    return false;
}

function errorMessage(element, message) {
    var divError = document.createElement("div");
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
       element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        divError = element.parentElement.lastElementChild;
    }
    divError.innerText = message;
    divError.className = "invalid-feedback";
    element.parentElement.append(divError);
    element.classList.remove("is-valid");
    element.classList.add("is-invalid");
}

function validMessage(element, message) {
    var divValid = document.createElement("div");
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
       element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        divValid = element.parentElement.lastElementChild;
    }
    divValid.innerText = message;
    divValid.className = "valid-feedback";
    element.parentElement.append(divValid);
    element.classList.remove("is-invalid");
    element.classList.add("is-valid");
}

function validReset(element) {
    if(element.parentElement.lastElementChild.classList.contains("invalid-feedback") ||
       element.parentElement.lastElementChild.classList.contains("valid-feedback")) {
        element.parentElement.lastElementChild.remove();
    }
    element.classList.remove("is-valid");
    element.classList.remove("is-invalid");
}

function format(string, ...args) {
    for(let idx = 0; idx < args.length; idx++) {
        string = string.replace("{" + (idx + 1) + "}", args[idx]);
    }
    return string;
}
