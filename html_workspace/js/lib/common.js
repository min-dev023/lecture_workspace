/* 원하는 정수를 반환받ㄷ기 위해서는 n값을 호출시 결정하자
ex) getRandom(1001)dmf sjarlaus 0~1000 반환
ex) getRandom(901)을 넘기면 0~900 반환
function getRandom(n) {
    return parseInt(Math.random() * n);
}
*/
function getRandom(max) {
    return parseInt(Math.random() * (max + 1)); // 0보다 크고 1보다 작은 난수
}

/*---------------------------------------------------------- 
    n이 한자리수이면, 앞에 0 문자를 붙dlrl
*----------------------------------------------------------*/ 
function zeroString(n) {
    let str = n;
    if (n < 10 && n >= 0) {
        str = "0" + n;
    }
    return str;
}
/*----------------------------------------------------------*/ 


/*---------------------------------------------------------- 
    해당월의 시작 요일 구하기
    API 사용 예) 2025년 5월 getStartDay(2025,4)
*----------------------------------------------------------*/ 
function getStartDay(yy, mm) {
    let d = new Date(yy, mm, 1); // 2025년 5월 1일...
    return d.getDay();
}
/*----------------------------------------------------------*/


/*---------------------------------------------------------- 
    영어 또는 한국어로 요일을 변환하여 말하기
    API 사용 예) convertDay(2, "kor")
*----------------------------------------------------------*/ 
function convertDay(n, lang) {
    let korArray = ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'];
    let engArray = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    let day = (lang == "kor") ? korArray[n] : engArray[n];
    return day;
}
/*----------------------------------------------------------*/

/*---------------------------------------------------------- 
    해당 월의 마지막 날 구하기
    API 사용 예) getLastDate(원하는 연도, 원하는 월)
*----------------------------------------------------------*/ 
function getLastDate(yy, mm) {
    let d = new Date(yy, mm + 1, 0);

    return d.getDate();
}
/*----------------------------------------------------------*/

/*---------------------------------------------------------- 
    충돌 체크 함수
*----------------------------------------------------------*/ 
function collisionCheck(me, target) {
    let me_x = parseInt(me.style.left);
    let me_y = parseInt(me.style.top);
    let me_width = parseInt(me.style.width);
    let me_height = parseInt(me.style.height);

    let target_x = parseInt(target.style.left);
    let target_y = parseInt(target.style.top);
    let target_width = parseInt(target.style.width);
    let target_height = parseInt(target.style.height);

    return !(
        me_x + me_width < target_x ||   // me의 오른쪽이 타겟의 왼쪽보다 왼쪽에 있으면
        me_x > target_x + target_width ||  // me의 왼쪽이 타겟의 우측보다 오른쪽에 있으면
        me_y + me_height < target_y ||  // 나의 아래쪽이 타겟보다 위에 있으면
        me_y > target_y + target_height // 나의 위쪽이 타겟보다 아래에 있으면
    );
}
/*----------------------------------------------------------*/ 


/*---------------------------------------------------------- 
    범위를 지정한 랜덤
    getRandomByRange(5, 8) : 5부터 8 사이의 랜덤값
*----------------------------------------------------------*/ 
function getRandomByRange(min, max) {
    return parseInt(Math.random() * (max - min + 1) + min);
}
/*----------------------------------------------------------*/