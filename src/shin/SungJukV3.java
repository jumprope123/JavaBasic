package shin;

import java.util.Scanner;

/**
 * 파일명 : SungJukV3
 * 작성일 : 2020.11.17
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 v3
 * 학생 3명의 성적 데이터를 키보드로 입력받아
 * 총점, 평균, 학점을 계산하고 결과 출력
 * 단 평균은 소숫점 첫째 자리 까지
 * name, kor, eng, mat, sum, mean , grd
 * 단, 학점기준은 '수우미양가'로 함,
 * 학점 계산시 switch 문으로 (10점 간격)
 * 삼항연산자 : (조건식) ?  참일때처리 : 거짓일때처리
 * 단, 성적처리 결과를 출력시 출력문을 하나만 사용하기로 함
 * 그리고, Math.round()를 이용해서 평균은 소수점 둘째 자리까지 출력
 */

public class SungJukV3 {
    public static void main(String[] args) {
//      변수 선언
        final int studenNum = 3;

        String[] name = new String[studenNum];
        int[] kor = new int[studenNum];
        int[] eng = new int[studenNum];
        int[] mat = new int[studenNum];
        int[] sum = new int[studenNum];
        double[] mean = new double[studenNum];
        char[] grd = new char[studenNum];
        String fmt = "이름 : %s\n국어 : %d\n영어 : %d\n수학 : %d\n총점 : %d\n평균 : %.2f\n학점 : %c";

        String[] result= new String[studenNum];

//    처리
        Scanner sc = new Scanner(System.in);

    for (int i=0; i<studenNum; i++) {
        System.out.println((i+1) + "번째 학생 성적 입력중...");
        System.out.print("이름을 입력하세요 : ");
        name[i] = sc.nextLine();

        System.out.print("국어를 입력하세요 : ");
        kor[i] = Integer.parseInt(sc.nextLine());

        System.out.print("영어를 입력하세요 : ");
        eng[i] = Integer.parseInt(sc.nextLine());

        System.out.print("수학을 입력하세요 : ");
        mat[i] = Integer.parseInt(sc.nextLine());
//        sc.skip("\r\n|[\n\r]");

//        수학 성적 입력시 같이 입력된 enter키가 다음 데이터(이름) 입력시 입력값으로 자동으로 전달됨.
//        그러한 상황을 해결하기 위해 미리 엔터키를 제거하는 코드 삽입

        sum[i] = kor[i] + eng[i] + mat[i];
        mean[i] = (double) sum[i] / studenNum;


        switch ((int) (mean[i] / 10)) {
            case 10:
            case 9: grd[i] = '수'; break;
            case 8: grd[i] = '우'; break;
            case 7: grd[i] = '미'; break;
            case 6: grd[i] = '양'; break;
            default: grd[i] = '가';
        }


//        Math.round(값) : 반올림하는 메소드
        mean[i] = Math.round(mean[i] * 100) / 100.0;
    }
//        String.valueOf(값)
//        숫자를 문자로 변환
        for (int i=0;i<studenNum;i++) {
            result[i] = String.format(fmt, name[i], kor[i], eng[i], mat[i], sum[i], mean[i], grd[i]);
//    결과 출력
        /*System.out.println("이름 : "+ name + "\n국어 : " + kor + "\n영어 : " + eng + "\n수학 : " + mat + "\n--------" +
                "\n총점 : " + sum + "\n평균 : " + mean + "\n학점 : " + grd);*/
//        문자열 연결 연산자(+)로 문장을 만드는 경우
//        String 변수의 특성 때문에 성능저하 발생
            System.out.println(result[i]);
            System.out.println("----------------");
        }
    }
}