package shin;

import java.util.Scanner;

/**
 * 파일명 : SungJukV2
 * 작성일 : 2020.11.17
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 v2
 * 이름, 국어 , 영어, 수학점수를 키보드로 입력받아
 * 총점, 평균, 학점을 계산하고 결과 출력
 * 단 평균은 소숫점 첫째 자리 까지
 * name, kor, eng, mat, sum, mean , grd
 * 단, 학점기준은 '수우미양가'로 함,
 * 학점 계산시 switch 문으로 (10점 간격)
 * 삼항연산자 : (조건식) ?  참일때처리 : 거짓일때처리
 * 단, 성적처리 결과를 출력시 출력문을 하나만 사용하기로 함
 * 그리고, Math.round()를 이용해서 평균은 소수점 둘째 자리까지 출력
 */

public class SungJukV2b {
    public static void main(String[] args) {
//    변수 선언

        String name;
        int kor;
        int eng;
        int mat;
        int sum;
        double mean;
        char grd;
        String fmt = "이름 : %s\n국어 : %d\n영어 : %d\n수학 : %d\n총점 : %d\n평균 : %.2f\n학점 : %c";
        String result;

//    처리
        Scanner sc = new Scanner(System.in);

        System.out.print("이름을 입력하세요 : ");
        name = sc.nextLine();

        System.out.print("국어를 입력하세요 : ");
        kor = sc.nextInt();

        System.out.print("영어를 입력하세요 : ");
        eng = sc.nextInt();

        System.out.print("수학을 입력하세요 : ");
        mat = sc.nextInt();

        sum = kor + eng + mat;
        mean = (double) sum / 3;


        switch ((int)(mean/10)) {
            case 10:
            case 9:  grd = '수'; break;
            case 8:  grd = '우'; break;
            case 7:  grd = '미'; break;
            case 6:  grd = '양'; break;
            default: grd = '가';
                };



//        Math.round(값) : 반올림하는 메소드
        mean = Math.round(mean*100)/100.0;
        result = String.format(fmt, name, kor, eng, mat, sum, mean, grd);
//    결과 출력
        /*System.out.println("이름 : "+ name + "\n국어 : " + kor + "\n영어 : " + eng + "\n수학 : " + mat + "\n--------" +
                "\n총점 : " + sum + "\n평균 : " + mean + "\n학점 : " + grd);*/
//        문자열 연결 연산자(+)로 문장을 만드는 경우
//        String 변수의 특성 때문에 성능저하 발생
        System.out.println(result);
    }
}
