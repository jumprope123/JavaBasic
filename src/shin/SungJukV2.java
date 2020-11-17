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
 */

public class SungJukV2 {
    public static void main(String[] args) {
//    변수 선언

        Scanner scan = new Scanner(System.in);

        System.out.printf("이름을 입력하세요");
        String name = scan.nextLine();

        System.out.printf("국어점수를 입력하세요");
        int kor = scan.nextInt();

        System.out.println("영어점수를 입력하세요");
        int eng = scan.nextInt();

        System.out.println("수학점수를 입력하세요");
        int mat = scan.nextInt();

        int sum = 0;
        int num;
        double mean = 0.0;
        char grd = '가';

//    처리
        sum = kor + eng + mat;
        mean = (double) sum / 3;
//        grd = (mean >= 90) ? '수' : (mean >= 80) ? '우' : (mean >= 70) ? '미' : (mean >= 60) ? '양' : '가';

        num = (int) (mean / 10);
        switch (num) {
            case 10:
                grd = '수';
                break;
            case 9:
                grd = '수';
                break;
            case 8:
                grd = '우';
                break;
            case 7:
                grd = '미';
                break;
            case 6:
                grd = '양';
                break;
            default:
                grd = '가';
                break;


        }

//    결과 출력
        System.out.println("이름 : " + name);
        System.out.println("국어 : " + kor);
        System.out.println("영어 : " + eng);
        System.out.println("수학 : " + mat);
        System.out.println("--------");
        System.out.println("총점 : " + sum);
        System.out.printf("평균 : %.1f\n", mean);
        System.out.println("학점 : " + grd);


    }
}
