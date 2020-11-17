package shin;

import java.util.Scanner;

/**
 * 파일명 : SungJukV1
 * 작성일 : 2020.11.17
 * <p>
 * 프로그램 설명 : 성적처리 프로그램 v1
 * 이름, 국어 , 영어, 수학점수를 설정하면
 * 총점, 평균, 학점을 계산하고 결과 출력
 * name, kor, eng, mat, sum, mean , grd
 * 단, 학점기준은 '수우미양가'로 함 (10점 간격)
 * 삼항연산자 : (조건식) ?  참일때처리 : 거짓일때처리
 */

public class SungJukV1 {
    public static void main(String[] args) {
//    변수 선언
        String name = "지환";
        int kor = 99;
        int eng = 99;
        int mat = 98;
        int sum = 0;
        double mean = 0.0;
        char grd = '가';

//    처리
        sum = kor + eng + mat;
        mean = (double) sum / 3;
        grd = (mean >= 90) ? '수' : (mean >= 80) ? '우' : (mean >= 70) ? '미' : (mean >= 60) ? '양' : '가';

//    결과 출력
        System.out.println("이름 : " + name);
        System.out.println("국어 : " + kor);
        System.out.println("영어 : " + eng);
        System.out.println("수학 : " + mat);
        System.out.println("--------");
        System.out.println("총점 : " + sum);
        System.out.println("평균 : " + mean);
        System.out.println("학점 : " + grd);


    }
}
