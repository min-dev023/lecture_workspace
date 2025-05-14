/* 게임에 등장할 모든 객체의 최상위 객체를 정의한다.
공동적인 속성과 기능들을 중복 작성하지 않기 위해서... 즉 재사용성을 위해
*/
class GameObject {
    constructor(container, src, x, y, width, height, velX, velY){
        this.container = container;
        this.img = document.createElement("img");
        this.src = src;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velX = velX;
        this.velY = velY;

        // style
        this.img.src =src;
        this.img.style.position ="absolute";
        this.img.style.left = this.x + "px";
        this.img.style.top = this.y + "px";

        this.img.style.width = this.width + "px";
        this.img.style.height = this.height + "px";

        // 컨테이너에 부착
        this.container.appendChild(this.img);
    }

    // 중복되는 메서드를 부모클래스에 정의하는 것은 올바른 개발방식이다.
    // But! 게임에 등장할 모든 객체들의 움직임을 부모가 미래 예측 불가능

    // 물리량 변화시키기
    tick(){}; // {몸체}가 없는 메서드를 추상메서드라고 함.
    
    // 변화된 물리량을 화면에 반영하기
    render() {}; 
}