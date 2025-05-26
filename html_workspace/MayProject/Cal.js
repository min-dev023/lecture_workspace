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
  
addEventListener("load", ()=>{
    document.getElementById("nextMonth").addEventListener('click',function(){
        console.log("담달");
    });
});