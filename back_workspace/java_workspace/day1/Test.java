class Test {
    String home = "아 집에 가고 싶다";
    //System.out.println(home);

    // 자바클래스를 실행하려면 반드시 메인 함수 정의해야함
    // 이미 정해전 함수명이므로, 절대 다르게 해서는 안됨
    public static void main(String[] args) {
        System.out.println("집 가고 싶다");
        
       for(int i = 9; i >= 1; i--){
            for(int j = 1; j<= 9; j++){
                System.out.print(j + " * " + i + " = " + (i * j) + "   "); 
            }
            System.out.println("");
        }
    }

    /* javascript는 개발자가 변수에 할당한 데이터의 종류 판단을,
    실행할 때 마다 해석... 
    interpretor 언어 : 브라우저로 매번 실행
    장점 = 수시로 데이터를 바꾸면서 그 결과를 확인할 때
    java는 자료형에 대한 판단을, 실행 전에 문법 검사시에 시도한다
    그리고 그 결과를 파일로 저장해놓고 프로그램을 실행할 때는
    두번 다시 자료형이나 문법에 대한 판단을 하지 않는다.
    이러한 방식의 언어를 컴파일 언어라고 한다.*/
}
