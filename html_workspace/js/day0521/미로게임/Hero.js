class Hero extends GameObject{
    constructor(container, x, y, width, height, velX, velY, bg, border, borderColor) {
        // js는 java 처럼 super() 자동으로 호출해주는 기능 없고, 개발자가 무조건 직접 나서야함.
        super(container, x, y, width, height, velX, velY, bg, border, borderColor);
        
        // 4개의 센서를 보유하자 Has-a관계
        // this.upSensor;
        this.rightSensor = new RightSensor(this.div, this, this.width - 3, 3, 3, this.height - 6, "blue", 0, "" );
        // this.downSensor;
        // this.leftSensor;
    }

    // 부모의 메서드 오버라이딩
    tick() {
        this.x += this.velX;
        this.y += this.velY;
    }
    render() {
        //현재 화면에 등장한 벽돌과 나와의 교차여부 체크(collision check)
        for(let i=0;i<brickArray.length;i++){
            for(let a=0;a<brickArray[i].length;a++){
                let brick=brickArray[i][a];
                // console.log(brick);
                
                if(brick !=0){
                    if(collisionCheck(this.div, brick.div)){
                        //주인공 색상을 분홍색으로...        
                        this.div.style.background="pink";
                    }
                }
            }
        }

        this.div.style.left=this.x+"px";
        this.div.style.top=this.y+"px";
    }
}