/*-------------------------------------------------------------
    사이드 바 불러오기
-------------------------------------------------------------*/
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

/*-------------------------------------------------------------
    변수 초기화
-------------------------------------------------------------*/
let stats;

document.addEventListener("DOMContentLoaded", () => {
    stats = {
        name: "마음이",
        happy: 50,
        health: 50,
        exp: 0,
        level: 1,
        hp: 10,
        maxHp: 10,
        happiness: 20,
        coins: 120
    };
});

/*-------------------------------------------------------------
    오프닝 - 로딩 바 애니메이션
-------------------------------------------------------------*/
window.addEventListener("DOMContentLoaded", () => {
    let barContainer = document.getElementById("loading-bar-container");
    let bar = document.getElementById("window-top"); // 로딩바 barContainer 의 부모.

    setTimeout(() => {
        // 로딩 바 숨기기
        barContainer.classList.add("fade-out");
        bar.removeChild(barContainer); // 로딩바의 기능을 다하면 지우기.

        // 캐릭터와 상태창 삽입
        let topContainer = document.getElementById("window-top-container");

        // 캐릭터 이미지
        let characterImg = document.createElement("img");
        characterImg.src = "./res/emoji/normal.png";
        characterImg.alt = "캐릭터";
        characterImg.id = "window-top-character";
        characterImg.style.width = "60px";
        characterImg.style.height = "60px";
        characterImg.style.display = "block";
        characterImg.style.margin = "0 auto";

        // 상태창
        let statusBox = document.createElement("div");
        statusBox.id = "window-top-status";
        statusBox.style.fontSize = "12px";
        statusBox.style.textAlign = "center";
        statusBox.style.marginTop = "6px";

        statusBox.innerHTML = `
            😊 행복도: ${stats.happy} |
            💪 체력: ${stats.health} |
            🎓 경험치: ${stats.exp} |
            ⭐ 레벨: ${stats.level}
        `;

        // 삽입
        topContainer.appendChild(characterImg);
        topContainer.appendChild(statusBox);

    }, 3000);
});

/*-------------------------------------------------------------
    오늘 한 일 function
-------------------------------------------------------------*/

let logModal = document.getElementById("log-modal");
let logOptions = document.getElementById("log-options");
let logConfirm = document.getElementById("log-confirm");

// function todayEvent() {

    let goodEvents = [
    { name: "운동했다", effect: +10 },
    { name: "샤워했다", effect: +5 },
    { name: "공부했다", effect: +7 }
    ];
    let badEvents = [
    { name: "지각했다", effect: -7 },
    { name: "친구와 싸웠다", effect: -10 },
    { name: "숙제를 안했다", effect: -5 }
    ];

    let selectedEvent = null;

    // 버튼 클릭 시 모달 열기
    document.querySelector('[data-action="log"]').addEventListener("click", () => {
        logModal.classList.remove("hidden");
        logOptions.innerHTML = "";
        logOptions.classList.add("hidden");
        logConfirm.classList.add("hidden");
        selectedEvent = null;
    });

    // 좋은 일 / 나쁜 일 선택
    document.querySelectorAll(".log-type-btn").forEach(btn => {
        btn.addEventListener("click", () => {
            let type = btn.dataset.type;
            let events = type === "good" ? goodEvents : badEvents;
            logOptions.innerHTML = events.map(e => `<div class="log-option" data-effect="${e.effect}">${e.name}</div>`).join('');
            logOptions.classList.remove("hidden");
            logConfirm.classList.add("hidden");

            // 이벤트 선택
            document.querySelectorAll(".log-option").forEach(opt => {
                opt.addEventListener("click", () => {
                    document.querySelectorAll(".log-option").forEach(o => o.style.background = "");
                    opt.style.background = "#ddd";
                    selectedEvent = parseInt(opt.dataset.effect);
                    logConfirm.classList.remove("hidden");
                });
            });
        });
    });

    // 확인 버튼
    logConfirm.addEventListener("click", () => {
        if (selectedEvent !== null) {
            stats.happy += selectedEvent;
            updateStats();
            logModal.classList.add("hidden");
        }
    });

// }

/*-------------------------------------------------------------
    메인화면 진입
-------------------------------------------------------------*/

function updateStats() {
    let topStatus = document.getElementById("window-top-status");
    if (topStatus) {
        topStatus.innerHTML = `
            😊 행복도: ${stats.happy} |
            💪 체력: ${stats.health} |
            🎓 경험치: ${stats.exp} |
            ⭐ 레벨: ${stats.level}
        `;
    }
}

/*-------------------------------------------------------------
    하단 화면 - 버튼 클릭 이벤트
-------------------------------------------------------------*/
document.querySelectorAll(".game-action").forEach(button => {
    button.addEventListener("click", () => {
    let action = button.dataset.action;
        switch (action) {
            case "exercise":
                stats.health += 5;
                stats.exp += 10;
                break;
            case "eat":
                stats.happy += 10;
                stats.health += 5;
                break;
            case "rest":
                stats.health += 8;
                break;
            case "log":
            break;
            case "shop":
                alert("🛍 상점 기능은 추후 구현!");
            break;
        }

        // 경험치가 일정 이상이면 레벨업
        if (stats.exp >= 100) {
            stats.level++;
            stats.exp = 0;
            alert("🎉 레벨 업!");
        }

        updateStats();
    });
});

document.getElementById("log-close").addEventListener("click", () => {
    document.getElementById("log-modal").classList.add("hidden");
});

/*-------------------------------------------------------------
    페이지 로드
-------------------------------------------------------------*/
addEventListener("load", function(){
    updateStats(); // 초기 렌더링
});