
// 감정별 색상 클래스 매핑
let emotionClassMap = {
    'joy': 'joy',
    'sadness': 'sadness',
    'anger': 'anger',
    'anxiety': 'anxiety',
    'calm': 'calm',
    'neutral': 'neutral'
};

// 영문 표시된 감정을 한글+이모지 변환
let emojiText;
let emoRange;
function printEmoji(emotion) {
    switch (emotion){
        case "joy":
            emojiText = "기쁨😊";
            break;
        case "sadness":
            emojiText = "슬픔😢";
            break;
        case "anger":
            emojiText = "분노😡";
            break;
        case "anxiety":
            emojiText = "불안😵";
            break;
        case "calm":
            emojiText = "평온😌";
            break;
        case "neutral":
            emojiText = "무감정😶";
            break;
        }
}

// 데이터 삭제
function deleteDiary() {
    if(confirm("정말 데이터를 전부 삭제하시나요?")) {
        localStorage.clear();
    }
    updateDiaryList();
    updateEmotionStats();
    updateGoalList();
}

// 데이터 저장
function saveDiary() {
    // 감정 선택
    let emotion = document.getElementById('emotion-select').value.trim();
    // 감정 레벨
    let emoLevel = document.getElementById('rangeInput');
    let emoLevelNum = Number(emoLevel.value);
    console.log(emoLevelNum);

    // 일기 내용
    let content = document.getElementById('diary-entry').value.trim();
    // 날짜
    let now = new Date();
    let year = now.getFullYear();
    let month = ('0' + (now.getMonth() + 1)).slice(-2);
    let day = ('0' + now.getDate()).slice(-2);

    let date = year + '-' + month  + '-' + day;

    if (!content) {
        alert("일기 내용을 입력해주세요.");
        return;
    }

    let diaryData = JSON.parse(localStorage.getItem('diaryData') || '[]');
    diaryData.push({ date, emotion, content, emoLevelNum });
    localStorage.setItem('diaryData', JSON.stringify(diaryData));

    // emoRange = null;
    document.getElementById('diary-entry').value = "";
    updateDiaryList();
    updateEmotionStats();
}

// 감정 일기 목록 출력
function updateDiaryList() {
    const diaryList = document.getElementById('diary-list');
    const diaryData = JSON.parse(localStorage.getItem('diaryData') || '[]');
    diaryList.innerHTML = "";

    // 날짜 최신순으로 정렬
    diaryData.sort((a, b) => new Date(b.date) - new Date(a.date));

    diaryData.slice().reverse().forEach(entry => {
        const capsule = document.createElement('div');
        capsule.classList.add('diary-capsule', entry.emotion); // 감정에 따라 클래스 부여

        capsule.innerHTML = `
            <div class="capsule-header">
                <span class="capsule-date">${entry.date}</span>
                <span class="capsule-emotion">Lv.${entry.emoLevelNum} ${getEmoji(entry.emotion)}</span>
            </div>
            <div class="capsule-content">
                ${entry.content}
            </div>
        `;

        diaryList.appendChild(capsule);
    });
}

// 감정에 따른 이모지 반환 함수
function getEmoji(emotion) {
    switch (emotion) {
        case "joy": return "😊";
        case "sadness": return "😢";
        case "anger": return "😠";
        case "anxiety": return "😰";
        case "calm": return "😌";
        case "neutral": return "😐";
        default: return "📝";
    }
}

// 감정 통계 시각화
function updateEmotionStats() {
    let diaryData = JSON.parse(localStorage.getItem('diaryData') || '[]');
    let statsContainer = document.getElementById('emotion-stats');
    statsContainer.innerHTML = "";

    let counts = {};
    diaryData.forEach(entry => {
        let emotion = entry.emotion.trim();
        counts[emotion] = (counts[emotion] || 0) + 1;
    });

    for (let [emotion, count] of Object.entries(counts)) {
        let emotionClass = emotionClassMap[emotion] || 'neutral';
        let bar = document.createElement('div');

        switch (emotion){
        case "joy":
            emojiText = "기쁨😊";
            break;
        case "sadness":
            emojiText = "슬픔😢";
            break;
        case "anger":
            emojiText = "분노😡";
            break;
        case "anxiety":
            emojiText = "불안😵";
            break;
        case "calm":
            emojiText = "평온😌";
            break;
        case "neutral":
            emojiText = "무감정😶";
            break;
        }
        bar.className = `emotion-bar ${emotionClass}`;
        bar.textContent = `${emojiText} x${count}`;
        bar.style.width = `${70 + count * 50}px`;
        bar.style.borderLeft = 20 +"px";
        statsContainer.appendChild(bar);
    }
}

// 다짐 저장
function addGoal() {
    let date = document.getElementById('goal-date').value;
    let text = document.getElementById('goal-text').value.trim();

    if (!date || !text) {
        alert("날짜와 다짐을 모두 입력해주세요.");
        return;
    }

    let goalData = JSON.parse(localStorage.getItem('goalData') || '{}');
    goalData[date] = text;
    localStorage.setItem('goalData', JSON.stringify(goalData));

    document.getElementById('goal-date').value = "";
    document.getElementById('goal-text').value = "";
    updateGoalList();
}

// 날짜별 다짐 목록 보기
// function updateGoalList() {
//     let goalList = document.getElementById('goal-list');
//     let goalData = JSON.parse(localStorage.getItem('goalData') || '{}');
//     goalList.innerHTML = "";

    
//     let sortedDates = Object.keys(goalData).sort().reverse();
//     sortedDates.forEach(date => {
//         let [year, month, day] = date.split("-");
//         let formattedMonth = month.padStart(2, '0');
//         let formattedDay = day.padStart(2, '0');
//         let formattedDate = `${year}년 ${formattedMonth}월 ${formattedDay}일`;

//         let li = document.createElement('li');
//         li.textContent = `[${formattedDate}] ${goalData[date]}`;
//         goalList.appendChild(li);
//     });
// }

function updateGoalList() {
    const goalList = document.getElementById('goal-list');
    const goalData = JSON.parse(localStorage.getItem('goalData') || '{}');
    goalList.innerHTML = "";

    const sortedDates = Object.keys(goalData).sort().reverse(); // 최신순 정렬

    sortedDates.forEach(date => {
        const [year, month, day] = date.split("-");
        const formattedDate = `${year}년 ${month.padStart(2, '0')}월 ${day.padStart(2, '0')}일`;

        const capsule = document.createElement('div');
        capsule.classList.add('goal-capsule');

        capsule.innerHTML = `
            <div class="goal-header">
                <span class="goal-date">${formattedDate}</span>
                <span class="goal-icon">🎯</span>
            </div>
            <div class="goal-content">
                ${goalData[date]}
            </div>
        `;

        goalList.appendChild(capsule);
    });
}


function navShowCal() {
    document.getElementById("content").style.display = "none";

    console.log("New");
}

    
addEventListener("load", ()=>{
    document.querySelector('.rangeInput').addEventListener('input',function(event){
        var gradient_value = 100 / event.target.attributes.max.value;
        event.target.style.background = 'linear-gradient(to right, #FFE283 0%, #FFE283 '+gradient_value * (event.target.value - 1) +'%, rgb(236, 236, 236) ' +gradient_value *  event.target.value + '%, rgb(236, 236, 236) 100%)';
    });
    // 초기 로딩 시
    updateDiaryList();
    updateEmotionStats();
    updateGoalList();
  
});
