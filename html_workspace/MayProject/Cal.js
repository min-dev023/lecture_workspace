addEventListener("load", ()=>{
    document.getElementById("nextMonth").addEventListener('click',function(){
        console.log("담달");
    });
});

fetch('sidebar.html')
  .then(response => response.text())
  .then(data => {
    const parser = new DOMParser();
    const doc = parser.parseFromString(data, 'text/html');
    const sidebarDiv = doc.querySelector('.side-nav');

    if (sidebarDiv) {
      document.getElementById('sidebar-container').appendChild(sidebarDiv);
    } else {
      console.error('sidebar div not found in sidebar.html');
    }
  })
  .catch(error => console.error('Error loading sidebar:', error));

