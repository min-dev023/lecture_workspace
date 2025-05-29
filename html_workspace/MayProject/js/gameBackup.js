/*-------------------------------------------------------------
    변수 초기화
-------------------------------------------------------------*/
let stats;
let characterImg;

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
        characterImg = document.createElement("img");
        characterImg.src = "./res/emoji/normal.png";
        characterImg.alt = "캐릭터";
        characterImg.id = "window-top-character";
        characterImg.style.width = "60px";
        characterImg.style.height = "60px";
        characterImg.style.display = "block";
        characterImg.style.margin = "0 auto";
        characterImg.style.marginTop = "100px";

        // 상태창
        let statusBox = document.createElement("div");
        statusBox.id = "window-top-status";
        statusBox.style.fontSize = "14px";
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
    모달 - 오늘 한 일 function
-------------------------------------------------------------*/

let logModal = document.getElementById("log-modal");
let logOptions = document.getElementById("log-options");
let logConfirm = document.getElementById("log-confirm");


let goodEvents = [
    { name: "운동을 했어요", effect: +10 },
    { name: "샤워를 했어요", effect: +5 },
    { name: "공부를 했어요", effect: +7 }
];
let badEvents = [
    { name: "지각 했어요", effect: -7 },
    { name: "친구와 싸웠어요", effect: -10 },
    { name: "숙제를 안했어요", effect: -5 }
];

let selectedEvent = null;

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
                characterImg.src = "./res/emoji/heart.png";
                break;
            case "eat":
                stats.happy += 10;
                stats.health += 5;
                characterImg.src = "./res/emoji/good.png";
                break;
            case "rest":
                stats.health += 8;
                characterImg.src = "./res/emoji/peace.png";
                break;
            case "log":
                // 버튼 클릭 시 모달 열기
                logModal.classList.remove("hidden");
                logOptions.innerHTML = "";
                logOptions.classList.add("hidden");
                logConfirm.classList.add("hidden");
                selectedEvent = null;
                break;
            case "diary":
                alert("🛍 일기 기능은 추후 구현!");
                break;
            case "shop":
                alert("🛍 상점 기능은 추후 구현!");
                break;
        }

        // ✅ 캐릭터 이미지 임시 변경
        if (characterImg) {
            // 3초 후 원래 이미지로 복구
            setTimeout(() => {
                characterImg.src = "./res/emoji/normal.png";
            }, 1000);
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