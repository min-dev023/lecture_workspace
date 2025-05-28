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
    오프닝 - 로딩 바 애니메이션
-------------------------------------------------------------*/
window.addEventListener("DOMContentLoaded", () => {
            const barContainer = document.getElementById("loading-bar-container");
            setTimeout(() => {
                barContainer.classList.add("fade-out");
            }, 3000);
});

