class Hero extends GameObject{
    // js에서는 생성자를 작성하기만 하면, 무조건 생성자내에서 super() 명시.
    // 주의! 부모님의 생성자에 매개변수가 있다면, 그에 맞게 호출
    constructor(container, src, x, y, width, height, velX, velY){
        super(container, src, x, y, width, height, velX, velY);

    }

    // 부모가 완성하지 못했던, 메서드를 자식이 자신의 상황에 맞게 커스텀하는
    // 메서드 정의 기법을 메서드 오버라이딩이라 한다.
    // 부모꺼 무시하고 업그레이드 하는 행위 (Overring)

    // 물리량 변화시키기
    tick() {
        this.x += this.velX;
        this.y += this.velY;
    }

    // 변화된 물리량을 화면에 반영하기
    render() {
        this.img.style.left = this.x + "px";
        this.img.style.top = this.y + "px";
    }
}