package shin;

import java.util.Scanner;

/**
 * 파일명 : SungJukV1
 * 작성일 : 2020.11.17
 *
 * 프로그램 설명 : 성적처리 프로그램 v1
 * 이름, 국어 , 영어, 수학점수를 설정하면
 * 총점, 평균, 학점을 계산하고 결과 출력
 * name, kor, eng, mat, sum, mean , grd
 * 단, 학점기준은 '수우미양가'로 함 (10점 간격)
*/

public class SungJukV1 {
    public static void main(String[] args) {
        String name;
        int kor, eng, mat, sum;
        double mean;
        char grd;

        name = "shin";
        kor = 99;
        eng = 99;
        mat = 97;
        sum = kor+eng+mat;
        mean = (double)sum / 3;


        //삼항연산자
        grd = (mean>=90)?'수':(mean>=80)?'우':(mean>=70)?'미':(mean>=60)?'양':'가';

        /*
        if(mean>=90){
            grd = '수';
        }else if(mean>=80){
            grd = '우';
        }else if(mean>=70){
            grd = '미';
        }else if(mean>=60){
            grd = '양';
        }else{
            grd ='가';
        }
*/

        System.out.printf("이름: %s\n",name);
        System.out.printf("국어: %d\n",kor);
        System.out.printf("영어: %d\n",eng);
        System.out.printf("수학: %d\n",mat);
        System.out.println("-------------");
        System.out.printf("총점: %d\n",sum);
        System.out.printf("평균: %.1f\n",mean);
        System.out.printf("그레이드: %c",grd);


    }
}
