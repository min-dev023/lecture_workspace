// 감정별 색상 클래스 매핑
const emotionClassMap = {
  '기쁨': 'joy',
  '슬픔': 'sadness',
  '분노': 'anger',
  '불안': 'anxiety',
  '평온': 'calm',
  '무감정': 'neutral'
};

function deleteDiary() {
  if(confirm("정말 데이터를 전부 삭제하시나요?")) {
    localStorage.clear();
  }
  updateDiaryList();
  updateEmotionStats()
}

// 데이터 저장
function saveDiary() {
  const emotion = document.getElementById('emotion-select').value.trim();
  const content = document.getElementById('diary-entry').value.trim();
  // const date = new Date().toISOString().slice(0, 10);
  const now = new Date();

  const year = now.getFullYear();
  const month = ('0' + (now.getMonth() + 1)).slice(-2);
  const day = ('0' + now.getDate()).slice(-2);

  const date = year + '-' + month  + '-' + day;

  console.log(date);

  if (!content) {
    alert("일기 내용을 입력해주세요.");
    return;
  }

  const diaryData = JSON.parse(localStorage.getItem('diaryData') || '[]');
  diaryData.push({ date, emotion, content });
  localStorage.setItem('diaryData', JSON.stringify(diaryData));

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
    li.textContent = `[${entry.date}] (${entry.emotion}) ${entry.content}`;
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
    bar.className = `emotion-bar ${emotionClass}`;
    bar.textContent = `${emotion} (${count})`;
    bar.style.width = `${count * 20}px`;
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

    // // 모달 열기/닫기
    // function showModal(date, content) {
    //   document.getElementById('modal-date').textContent = date;
    //   document.getElementById('modal-content').textContent = content;
    //   document.getElementById('goal-modal').style.display = 'block';
    //   document.getElementById('modal-overlay').style.display = 'block';
    // }

    // function closeModal() {
    //   document.getElementById('goal-modal').style.display = 'none';
    //   document.getElementById('modal-overlay').style.display = 'none';
    // }

    // // 캘린더 렌더링
    // function renderCalendar() {
    //   const goalData = JSON.parse(localStorage.getItem('goalData') || '{}');
    //   const events = Object.entries(goalData).map(([date, title]) => ({
    //     title: '다짐 있음',
    //     start: date,
    //     allDay: true,
    //     extendedProps: { detail: title }
    //   }));

    //   const calendarEl = document.getElementById('goal-calendar');
    //   const calendar = new FullCalendar.Calendar(calendarEl, {
    //     initialView: 'dayGridMonth',
    //     locale: 'ko',
    //     height: 500,
    //     events,
    //     eventClick: function(info) {
    //       const date = info.event.startStr;
    //       const content = info.event.extendedProps.detail;
    //       showModal(date, content);
    //     }
    //   });
    //   calendar.render();
    // }

    // // 기존 addGoal에 캘린더 갱신 추가
    // function addGoal() {
    //   const date = document.getElementById('goal-date').value;
    //   const text = document.getElementById('goal-text').value.trim();

    //   if (!date || !text) {
    //     alert("날짜와 다짐을 모두 입력해주세요.");
    //     return;
    //   }

    //   const goalData = JSON.parse(localStorage.getItem('goalData') || '{}');
    //   goalData[date] = text;
    //   localStorage.setItem('goalData', JSON.stringify(goalData));

    //   document.getElementById('goal-date').value = "";
    //   document.getElementById('goal-text').value = "";
    //   updateGoalList();
    //   renderCalendar(); // 캘린더도 다시 렌더링
    // }

    // // 초기 렌더링
    // updateDiaryList();
    // updateEmotionStats();
    // updateGoalList();
    // renderCalendar();

// 초기 로딩 시
updateDiaryList();
updateEmotionStats();
updateGoalList();
