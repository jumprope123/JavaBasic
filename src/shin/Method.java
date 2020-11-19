package shin;

import java.util.Scanner;

/**
 * 파일명 : SungJukV4
 * 작성일 : 2020.11.18
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 v4
 * 학생 3명의 성적 데이터를 키보드로 입력받아
 * 총점, 평균, 학점을 계산하고 결과 출력
 * 단 평균은 소숫점 첫째 자리 까지
 * name, kor, eng, mat, sum, mean , grd
 * 단, 학점기준은 '수우미양가'로 함,
 * 학점 계산시 switch 문으로 (10점 간격)
 * 삼항연산자 : (조건식) ?  참일때처리 : 거짓일때처리
 * 단, 성적처리 결과를 출력시 출력문을 하나만 사용하기로 함
 * 성적처리 기능을 구현함으로써 코드가 길어지고
 * 내용파악이 어려워지는 것을 방지하기 위해
 * 함수(메서드)로 재정의 해서 코드를 개선함
 */

public class Method {

//    메서드
//    특정 작업을 수행하기 위해 작성한 명령어들의 묶음
//    c언어의 함수와 비슷한 성격을 가지는 프로그래밍 요소
//    입력값을 통해 무언가를 하고 그 결과를 도출하는
//    수학의 함수(블랙박스)와 비슷한 개념

//    메서드의 목적
//    프로그램을 작성하다 보면 반복적으로 쓰인 코드를
//    종종 보는데, 효율적으로 작성하려면 반복문으로
//    처리하면 되지만, 만일 반복문이 반복된다면?
//    메서드를 사용하면 기능별로 모듈화를 적용할 수 있기 때문에
//    프로그램의 가독성이 좋아지고, 협업시에도 유용하며, 기능변경시 유지보수에도 좋음

    //    메서드 정의
//    접근제한자 리턴타입 메서드이름(타입 매개변수명){
//        메서드 몸체
//    }
    public static void main(String[] args) {
//        Hello, World!! 메세지 출력
        /*     System.out.println("Hello,World!!");*/
//    Hello, World!! 메세지 3번 출력
     /*   for (int i=0; i<3; i++){
            System.out.println("Hello,World!!");*/
//        }
//        3번 출력을 3번 반복

//        Hello,World 메세지에서 HelloJava로 변경시엔 Hello,World를 Hello,Java로 바꿈

//        인사말 출력 메서드 호출(call)
        sayHello();
//        인사말을 3번 출력하는 메서드 : sayHello2

        sayHello2();

        sayHello3("Hello Java!!");

        String result = sayHello4("안녕하세요, 세상아!");
        System.out.println(result);

        computeNum(10, 5);

        System.out.println();
        computeAllSum(1, 10);

        computeAllSumGauss(1,10);
        computeAllSumGauss(10,1);

    }

    //간단한 인사말 출력 메서드
//    public : 접근제한자, 외부 클래스의 메서드 사용허가 여부
//    static : 정적 메서드 , 객체 생성없이 바로 사용가능 메서드
//    void : 메서드의 리턴값이 없다.
    public static void sayHello() {
        System.out.println("Hello,World!!");
    }

    //간단한 인사말 출력 메서드2
    public static void sayHello2() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Hello,World!!");
        }
    }

    //간단한 인사말 출력 메서드3
//    단 인삿말은 언제든 변경 가능하도록 재작성
//    매개변수 : 메서드 처리시 필요로 하는 입력값
    public static void sayHello3(String msg) {
        System.out.println(msg);
    }

    //간단한 인사말 출력 메서드4
//    단 인삿말은 언제든 변경 가능하도록 재작성
//    단 인삿말 출력을 메서드가 바로 하지 않고
//    인삿말 생성 후 호출한 대상에게 넘김
//    return : 메서드내에서 처리한 값을 외부로 보내려면
//    return 이라는 명령문 사용
//    return시 값의 type과 메서드의 return type은 일치해야 함
    public static String sayHello4(String name) {
        return name;
    }

    // 두개의 정수를 매개변수로 선언하고 사칙연산한 결과를 출력하는 메서드: computeNum
    public static void computeNum(int a, int b) {
        System.out.println("a는 " + a + " b는 " + b);
        System.out.println("a + b 의 결과는 : " + (a + b));
        System.out.println("a - b 의 결과는 : " + (a - b));
        System.out.println("a * b 의 결과는 : " + (a * b));
        double div = (double) a / b;
        System.out.printf("a ÷ b 의 결과는 : %.2f", div);
    }

    //    두개의 정수를 매개변수로 선언하고 두 정수를 범위로 설정해서 합을 구하고 출력하는
//    메서드 : computeAllSum
//    ex) 5 , 1 -> 1+2+3+4+5 => 15
    public static void computeAllSum(int a, int b) {
        int sum = 0;
        int min = a;
        int max = b;
        String fmt = "%d ~ %d 정수범위의 총 합 : %d\n";
        if (a > b) {
            min = b;
            max = a;
        }
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        System.out.printf(fmt,min,max,sum);
    }

    public static void computeAllSumGauss(int a, int b){
        int cnt = Math.abs(b-a) + 1;
        int gausssum = (a+b)*cnt/2;
        System.out.println("가우스함수를 이용한 합은? : "+ gausssum);

    }

}