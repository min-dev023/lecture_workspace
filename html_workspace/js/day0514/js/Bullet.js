class Bullet extends GameObject{
    constructor(container, src, x, y, width, height, velX, velY){
        super(container, src, x, y, width, height, velX, velY);
    }

    // 총알 제거 메서드
    removeObject(array, target) {
        // 1) 화면에서 제거
        // this: 나의 인스턴스를 가리키는 대명사, 총알 입장에서 "나"
        let obj = array[array.indexOf(target)];
        this.container.removeChild(obj.img);

        // 2) 총알이 있던 배열에서도 제거 (제거 안하면 계속 총알이 있는 줄 안다.)
        array.splice(array.indexOf(target), 1);
    }

    // 물리량 변화시키기
    tick() {
        this.x += this.velX;
    }

    // 변화된 물리량을 화면에 반영하기
    render() {
        // 총알이 한 걸음씩 나아갈 때마다, 총알과 적군과의 충돌을 체크해서 제거처리...
        for(let i = 0; i < enemyArray.length; i ++){
            let enemy = enemyArray[i]; // 적군 한마리 꺼내기

            if(collisionCheck(this.img, enemy.img)){ // 충돌 했다면...
                this.removeObject(enemyArray, enemy);
                this.removeObject(bulletArray, this);
                setScore(10); // 10점 증가
            }
        }

        // 적군에 충돌하지 않은 총알은 자동 제거, 1000 픽셀을 넘어설 때 제거 처리
        if(this.x > 1400) {
            // 화면에서 제거
            this.removeObject(bulletArray, this);

            // 배열에서 제거
        }


        this.img.style.left = this.x + "px";
    }
}