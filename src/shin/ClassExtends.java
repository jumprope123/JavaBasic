package shin;
// 상속(확장)
// 객체 지향 3대 개념중 하나
// 기존 클래스에 기능을 추가하거나 재정의해서
// 새로운 클래스를 만드는 것

// 상속을 이용하면 기존의 정의되어 있는
// 클래스의 모든 필드와 메서드를 물려받음
// 기존 클래스를 부모/상위/슈퍼 클래스라 하고
// 새롭게 작성된 클래스를 자식/하위/서브 클래스라 함

// 상속의 장점
// 기존 작성된 클래스 재활용
// 클래스의 계층적 구조 파악 용이
// 소프트웨어 생산성 향상

import shin.cooperation.Student;

public class ClassExtends {
    public static void main(String[] args) {
        StudentWorkers sw = new StudentWorkers();
        Reserchers rs = new Reserchers();
        System.out.println(sw.work());
        System.out.println(sw.eat());
        System.out.println(rs.sleep());
        System.out.println(rs.reserch());
    }//main

} //ClassExtends 종료지점

class Persons {
    private String name;

    //생성자
    public Persons() {}
    public Persons(String name) {this.name = name;}

    //setter getter
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    //메서드
    public String speak(){return "말하는 중";}
    public String eat(){return "먹는 중";}
    public String walk(){return "걷는 중";}
    public String sleep(){return "자는 중";}
} // Persons 클래스 종료지점

//Persons 클래스를 상속받는 Students 클래스 생성
//class '클래스명' extends '부모클래스'{}
class Students extends Persons {
    public String study(){return "공부하는 중";}
}//Students 클래스 종료지점

class StudentWorkers extends Students {
    public String work() {return "일하는 중";}
}//StudentWorkers 클래스 종료지점

class Reserchers extends Persons{
    public String reserch(){return "연구하는 중";}
}//Reserchers 클래스 종료지점

class Professors extends Reserchers{
    public String teach(){return "가르치는 중";}
}// Professors 클래스 종료지점