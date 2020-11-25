package shin;

// 클래스/인터페이스 형변환
// 특정 객체가 자식클래스/인터페이스의 타입에서
// 부모클래스/인터페이스 타입 또는 반대로 형 변환하는것을 의미
public class OOPCasting {
    public static void main(String[] args) {
        Unit u1 = new Unit();
        Marine m1 = new Marine();
        Firebat f1 = new Firebat();
        Unit unit = new Marine();
        //Marine 객체는 자동으로 Unit객체로 형 변환
        // 이처럼 상속관계에 있는 클래스간의 객체생성시
        // 자식클래스 타입의 객체가 부모클래스 타입의 객체로
        // 선언하는 경우 업 캐스팅(UpCasting)이라고 함.
        // Firebat f2 = (Firebat) new Unit();
        // Unit 객체를 Firebat 객체로 형 변환하려면
        // 명시적 형 변환 필요
        // 부모클래스 타입의 객체를 자식 클래스 타입의 객체로
        // 선언하는 경우는 다운캐스팅이라고 한다.
        // 단 컴파일시에는 오류가 나지 않지만
        // 실행시 오류 발생!

        Marine m3 = (Marine) unit;
        // marine을 토대로 unit을 만들었으니 다시 unit으로 돌리기 가능.
        // Unit 객체변수를 Marin 객체로 다운캐스팅
        u1.attack();
        m1.attack();
        f1.attack();
        unit.attack();
        //f2.attack();
        m3.attack();
    }
}

class Unit {
    protected int hp;
    protected int ap;

    public void attack(){
        System.out.println("공격 중 입니다...");
    }
}

class Marine extends Unit {
    @Override
    public void attack() {
        System.out.println("마린이 공격중");
    }
}

class Firebat extends Unit {
    @Override
    public void attack() {
        System.out.println("파이어뱃이 공격중");
    }
}