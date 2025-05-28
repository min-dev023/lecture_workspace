// 사이드바 연결
fetch('sidebar.html')
    .then(response => response.text())
    .then(data => {
        let parser = new DOMParser();
        let doc = parser.parseFromString(data, 'text/html');
        let sidebarDiv = doc.querySelector('.side-nav');
        
        if (sidebarDiv) {
        document.getElementById('sidebar-container').appendChild(sidebarDiv);
        
        // ✅ 사이드바 로딩 후에 요소들을 찾아야 함!
        let menuBtn = document.querySelector('.menu-btn');
        let nav = document.querySelector('nav');
        let lineOne = document.querySelector('nav .menu-btn .line--1');
        let lineTwo = document.querySelector('nav .menu-btn .line--2');
        let lineThree = document.querySelector('nav .menu-btn .line--3');
        let link = document.querySelector('nav .side-nav-left');
        
        if (menuBtn && nav && lineOne && lineTwo && lineThree && link) {
            menuBtn.addEventListener('click', () => {
            nav.classList.toggle('nav-open');
            lineOne.classList.toggle('line-cross');
            lineTwo.classList.toggle('line-fade-out');
            lineThree.classList.toggle('line-cross');
            link.classList.toggle('fade-in');
            });
        } else {
            console.error('Some sidebar elements not found after loading.');
        }
        } else {
        console.error('sidebar div not found in sidebar.html');
        }
    })
    .catch(error => console.error('Error loading sidebar:', error))
;

//----------------------------------------------------------------------------
let nowDate = new Date();
let nowCurrYear = nowDate.getFullYear();
let nowCurrMonth = nowDate.getMonth();


let date = new Date();
let currYear = date.getFullYear();
let currMonth = date.getMonth();
let lastDateofMonth; // 월의 마지막 날짜
let firstDayofMonth;
let lastDayofMonth;
let lastDateofLastMonth;

let goalData;

let liTag;

let months = [
  'January',
  'February',
  'March',
  'April',
  'May',
  'June',
  'July',
  'August',
  'September',
  'October',
  'November',
  'December',
];

//----------------------------------------------------------------------------

// 날짜 별 상세 내용 표시
function showDetail(deYear, deMonth, deDay) {
    console.log("상세" + deYear + "년" + (deMonth+1) + "월" + deDay +"일");

    goalData = JSON.parse(localStorage.getItem('goalData') || '{}');

    // 월과 일이 1자리인 경우 0을 붙여서 두 자리로 만듦
    let monthStr = String(deMonth+1).padStart(2, '0');
    let dayStr = String(deDay).padStart(2, '0');

    // yyyy-mm-dd 형식으로 조합
    let key = `${deYear}-${monthStr}-${dayStr}`;

    // 콘솔에 출력
    console.log(goalData[key]);

    // 또는 화면에 표시
    let emotionLogList = document.getElementById('session');


    let entryDiv = document.createElement('div');
    entryDiv.classList.add('emotion-log-entry');

    emotionLogList.textContent = "";
    if (goalData[key]) {
        entryDiv.innerHTML = `
        <strong>📅 날짜 : </strong> ${deYear}년 ${deMonth+1}월 ${dayStr}일 <br>
        <strong>📝다짐 : </strong> ${goalData[key]} <br>
        `;
    } else {
        entryDiv.innerHTML = `
        <strong>📅 날짜 : </strong> ${deYear}년 ${deMonth+1}월 ${dayStr}일 <br>
        <strong>❌ 등록된 다짐이 없습니다.</strong> <br>
        `;
    }
    emotionLogList.appendChild(entryDiv);
}

//----------------------------------------------------------------------------

// 달력 생성
function renderCalendar() {
    goalData = JSON.parse(localStorage.getItem('goalData') || '{}'); // 다짐 목록 불러오기

    lastDateofMonth = new Date(currYear, currMonth + 1, 0).getDate(); // 월의 마지막 날

    // header에 월*년도 출력
    let currentDate = document.querySelector('.current-date');

    currentDate.innerHTML = `${months[currMonth]} ${currYear}`;

    if(months[currMonth].indexOf >= 11) {
        currMonth = 0;
    }
    
    currentDate.innerHTML = `${months[currMonth]} ${currYear}`;

    // 날짜 출력
    let daysTag = document.querySelector('.days');

    firstDayofMonth = new Date(currYear, currMonth, 1).getDay(); // 이번달이 시작하는 요일 (0: 일요일, 6: 토요일)
    lastDayofMonth = new Date(currYear, currMonth, lastDateofMonth).getDay(); // 이번달이 끝나는 요일 (0: 일요일, 6: 토요일)
    lastDateofLastMonth = new Date(currYear, currMonth, 0).getDate(); // 이전 달의 마지막 날짜

    liTag = ''; // li 일자 출력 초기화

    // 이전 달 '일' 표시
    for (let i = firstDayofMonth; i > 0; i--) {
        liTag += `<li class = "inactivePrev">${lastDateofLastMonth - i + 1}</li>`;
    }

    // 이번 달 '일' 표시
    for (let i = 1; i <= lastDateofMonth; i++) {
        // 오늘 날짜 표시하기
        let isToday =
            i === date.getDate() &&
            currMonth === new Date().getMonth() &&
            currYear === new Date().getFullYear()
            ? 'active' : ''
        ;

        // 다짐 영역 색깔 표시를 위해 name 지정

        // 날짜 형식을 yyyy-mm-dd로 조합
        let monthStr = String(currMonth + 1).padStart(2, '0');
        let dayStr = String(i).padStart(2, '0');
        let key = `${currYear}-${monthStr}-${dayStr}`;

        // 다짐이 있는 경우 promise 클래스 추가
        let hasGoal = goalData[key] ? 'promise' : '';

        // 클래스 조합 (isToday나 hasGoal이 있을 수 있음)
        let classList = `${isToday} ${hasGoal}`.trim();


        // 클래스 추가 (날짜가 오늘인 경우 id="today", 나머지는 id는 없고 name="evtDay"로 지정)
        // liTag += `<li id="${isToday}" name="evtDay">${i}</li>`;
        liTag += `<li class="${classList}" name="evtDay">${i}</li>`;
    }

    // 다음 달 '일' 표시
    for (let i = lastDayofMonth; i < 6; i++) {
        liTag += `<li class = "inactiveNext">${i - lastDayofMonth + 1}</li>`;
    }
    
    daysTag.innerHTML = liTag;


    // 날짜 별 해당 일의 "다짐" 상세 내용 표시 (클릭 이벤트 연결)
    let li = document.querySelectorAll('li[name="evtDay"]');

    li.forEach(li => {
        li.addEventListener('click', function () {
            let day = li.textContent;
            console.log(currYear + "년" + currMonth + "월" + day +"일");
            showDetail(currYear, currMonth, day);
        });
    });

    // 이전 달의 <li> 클릭 시 이전 달로 이동
    let liPrev = document.querySelectorAll('li[class="inactivePrev"]');

    liPrev.forEach(li => {
        li.addEventListener('click', function () {
            console.log(`이전`);
            getCurrentTime(currYear, currMonth - 1);
            renderCalendar();
        });
    });

    // 다음 달의 <li> 클릭 시 다음 달로 이동
    let liNext= document.querySelectorAll('li[class="inactiveNext"]');

    liNext.forEach(li => {
        li.addEventListener('click', function () {
            console.log(`이후`);
            getCurrentTime(currYear, currMonth + 1);
            renderCalendar();
        });
    });
}

// 버튼과 연결, 다음or이전 달 자동 계산
function getCurrentTime(year, month) {
    // 0이하가 되면 연도 자동 이전 년도 처리, 11이 넘어가면 연도도 자동계산
    let d = new Date(year, month);
    currYear = d.getFullYear();
    currMonth = d.getMonth();
}

/*-------------------------------------------------------------
이전 달력 출력
-------------------------------------------------------------*/
function prev(year, month) {
    getCurrentTime(currentYear, currentMonth - 1);
    printTitle(); // 달력 제목 출력
    clearCell(); // 기존에 출력된 날짜 및 아이콘 지우기.
    printNum(); // 기존 셀에 날짜 출력
}
/*-------------------------------------------------------------
다음 달력 출력
-------------------------------------------------------------*/
function next(year, month) {
    getCurrentTime(currentYear, currentMonth + 1);
    printTitle(); // 달력 제목 출력
    clearCell(); // 기존에 출력된 날짜 및 아이콘 지우기.
    printNum(); // 기존 셀에 날짜 출력
}








addEventListener("load", ()=>{
    // 달력 호출
    renderCalendar();
    
    // Button prevMonth -> onClick : 이전 달 이동
    document.getElementById("prevMonth").addEventListener('click',function(){
        getCurrentTime(currYear, currMonth - 1);
        renderCalendar();
    });
    // Button nextMonth -> onClick : 다음 달 이동
    document.getElementById("nextMonth").addEventListener('click',function(){
        getCurrentTime(currYear, currMonth + 1);
        renderCalendar();
    });
    // Button btnNow -> onClick : 오늘 날짜로 이동
    document.getElementById("btnNow").addEventListener('click',function(){
        getCurrentTime(nowCurrYear, nowCurrMonth);
        renderCalendar();
    });
});