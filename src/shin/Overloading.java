package shin;

// 메서드 다중정의
// 객체지향 중요 개념중 하나인 다형성에 해당
// 같은 이름의 메서드를 중복해서 정의하는 것을 의미
// 한 클래스에 같은 이름의 메서드가 2개 이상 존재할 수 있음
// 이때 메서드의 서명만 다르게 작성한다면 정의 가능

public class Overloading {
    public static void main(String[] args) {
        NonOverloading nol = new NonOverloading();
        ApplyOverloading aol = new ApplyOverloading();
        System.out.println(nol.plusTwoInt(10,10));
        System.out.println(nol.plusThreeInt(10,10,10));
        System.out.println(nol.plusTwoDouble(10.0,10.0));
        System.out.println(aol.add(10,10));
        System.out.println(aol.add(10.0,10.0));
        System.out.println(aol.add(10,10,10));
    }
}

class NonOverloading{
    int sumInt;
    double sumDouble;
    // 간단한 덧셈 프로그램
    // 1. 정수 2개를 더하는 프로그램
    // 2. 실수 2개를 더하는 프로그램
    // 2. 정수 3개를 더하는 프로그램

    public int plusTwoInt(int a, int b){
        sumInt = a + b;
        return sumInt;
    }

    public double plusTwoDouble(double a, double b){
        sumDouble = a+ b;
        return sumDouble;
    }


    public int plusThreeInt(int a, int b, int c){
        sumInt = a + b + c;
        return sumInt;
    }

    // 메서드 오버로딩이 구현되지 않은 경우
    // 생성한 메소드마다 이름을 제각각으로 정해야 하므로
    // 개발자가 일일히 기억해서 사용해야 하는 불편 초래

}

class ApplyOverloading{
    public int add(int a, int b){
        return a+b;
    }
    public double add(double a, double b){
        return a+b;
    }
    public int add(int a, int b , int c){
        return a+b+c;
    }

    // 메서드 오버로딩을 적용하면 메서드의 이름을 하나로 통일해서 작성 가능
    // 개발자가 외울 메서드의 이름이 줄어듬
    // 단, 메서드를 어떻게 호출할지만 알고있으면 된다.
}