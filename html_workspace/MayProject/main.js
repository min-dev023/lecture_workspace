fetch('sidebar.html')
  .then(response => response.text())
  .then(data => {
    const parser = new DOMParser();
    const doc = parser.parseFromString(data, 'text/html');
    const sidebarDiv = doc.querySelector('.side-nav');

    if (sidebarDiv) {
      document.getElementById('sidebar-container').appendChild(sidebarDiv);

      // ✅ 사이드바 로딩 후에 요소들을 찾아야 함!
      const menuBtn = document.querySelector('.menu-btn');
      const nav = document.querySelector('nav');
      const lineOne = document.querySelector('nav .menu-btn .line--1');
      const lineTwo = document.querySelector('nav .menu-btn .line--2');
      const lineThree = document.querySelector('nav .menu-btn .line--3');
      const link = document.querySelector('nav .side-nav-left');

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
  .catch(error => console.error('Error loading sidebar:', error));

  

// 감정별 색상 클래스 매핑
const emotionClassMap = {
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
  updateEmotionStats()
}

// 데이터 저장
function saveDiary() {
  // 감정 선택
  const emotion = document.getElementById('emotion-select').value.trim();
  // 감정 레벨
  const emoLevel = document.getElementById('rangeInput');
  const emoLevelNum = Number(emoLevel.value);
  console.log(emoLevelNum);

  // 일기 내용
  const content = document.getElementById('diary-entry').value.trim();
  // 날짜
  const now = new Date();
  const year = now.getFullYear();
  const month = ('0' + (now.getMonth() + 1)).slice(-2);
  const day = ('0' + now.getDate()).slice(-2);

  const date = year + '-' + month  + '-' + day;

  if (!content) {
    alert("일기 내용을 입력해주세요.");
    return;
  }

  const diaryData = JSON.parse(localStorage.getItem('diaryData') || '[]');
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

  
  diaryData.slice().reverse().forEach(entry => {
    const li = document.createElement('li');
    printEmoji(entry.emotion);
    li.textContent = `[${entry.date}] (${emojiText}, lv ${entry.emoLevelNum}) ${entry.content}`;
    diaryList.appendChild(li);
  });
}

// 감정 통계 시각화
function updateEmotionStats() {
  const diaryData = JSON.parse(localStorage.getItem('diaryData') || '[]');
  const statsContainer = document.getElementById('emotion-stats');
  statsContainer.innerHTML = "";

  const counts = {};
  diaryData.forEach(entry => {
    const emotion = entry.emotion.trim();
    counts[emotion] = (counts[emotion] || 0) + 1;
  });

  for (const [emotion, count] of Object.entries(counts)) {
    const emotionClass = emotionClassMap[emotion] || 'neutral';
    const bar = document.createElement('div');

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
    bar.style.width = `${70 + count * 20}px`;
    bar.style.borderLeft = 20 +"px";
    statsContainer.appendChild(bar);
  }
}

// 다짐 저장
function addGoal() {
  const date = document.getElementById('goal-date').value;
  const text = document.getElementById('goal-text').value.trim();

  if (!date || !text) {
    alert("날짜와 다짐을 모두 입력해주세요.");
    return;
  }

  const goalData = JSON.parse(localStorage.getItem('goalData') || '{}');
  goalData[date] = text;
  localStorage.setItem('goalData', JSON.stringify(goalData));

  document.getElementById('goal-date').value = "";
  document.getElementById('goal-text').value = "";
  updateGoalList();
}

// 날짜별 다짐 목록 보기
function updateGoalList() {
  const goalList = document.getElementById('goal-list');
  const goalData = JSON.parse(localStorage.getItem('goalData') || '{}');
  goalList.innerHTML = "";

  const sortedDates = Object.keys(goalData).sort().reverse();
  sortedDates.forEach(date => {
    const li = document.createElement('li');
    li.textContent = `[${date}] ${goalData[date]}`;
    goalList.appendChild(li);
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
