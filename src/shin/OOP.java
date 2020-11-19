package shin;
// 객체 지향 프로그래밍 개요
// 현실의 모든 사물을 객체로 취급하여 소프트웨어를 개발하는 방식
// 객체 : 실생활에서 우리가 인식하는 유/무형의 사물
// ex) 집, 자동차, 사람, 급여, 주문, ...
// 클래스 : 객체를 만들어 내기 위한 틀, 설계도
// 클래스에는 객체의 상태를 나타내는 필드/속성과
// 객체의 기능을 나타내는 메서드로 구성됨

// 클래스는 객체의 설계도이기 때문에
// 실제 정보는 저장할 수 없다
// 실제 정보를 저장하려면 이것의 객체가 필요한데
// 객체를 선언하는 과정을 객체화(instantate)라고 함
// 객체화를 통해 나온 결과물을 객체/인스턴스라 하는데
// 클래스에 정의된 필드와 기능이 실제 메모리상에 할당된 것

public class OOP {

    public static void main(String[] args) {
//         클래스에 대한 객체화
//        클래스명 객체명 = new 생성자;
        Person choi = new Person();
        Person lee = new Person();
        Person kim = new Person();

        //객체의 변수(멤버변수)에 값 대입 :

        choi.name = "최승희";
        choi.job = "의사";
        choi.age = 45;
        choi.gender = "여";
        choi.blood = "A";

        //멤버변수 출력
        System.out.println(choi.name);
        System.out.println(choi.job);
        System.out.println(choi.age);
        System.out.println(choi.gender);
        System.out.println(choi.blood);


        lee.name = " 김미녀";
        lee.job = "골프선수";
        lee.age = 28;
        lee.gender = "여";
        lee.blood = "O";

        kim.name = "김미남";
        kim.job = "교수";
        kim.age = 47;
        kim.gender = "남";
        kim.blood = "AB";
    }
}//class

//클래스 정의 : 접근 제한자 클래스 명 {
//   필드
//   메서드
// }
// 최승희: 의사,45,여,A
// 이미녀: 골프선수,28,여,O
// 김미남: 교수,47,남,AB

class Person {
    String name;
    String job;
    int age;
    String gender;
    String blood;
}
