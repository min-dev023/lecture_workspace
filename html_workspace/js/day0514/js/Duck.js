// ES6부터는 클래스 뿐 아니라 상속까지도 java 언어와 흡사
class Duck extends Bird{
    /* js와 java 둘 다 상속관계에서 자식의 인스턴스가 초기화되기 전에
    부모의 인스턴스 초기화가 앞서야 함은 동일하지만
    js는 개발자가 자식의 클래스에서 생성자를 정의만 해도,
    무조건 생성자 호출을 의무사항 명시 */
    constructor(color, age) {
        super(color, age); // 부모님을 먼저 초기화
                 // super()는 부모의 constructor()를 의미
        this.color = color;
        this.age = age;
    }
    fly() {
        console.log("오리날다.")
    }
}