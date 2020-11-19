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
 * 코드의 가독성과 유지보수를 용이하게 하기 위해
 * 메서드 기반 코드로 재작성
 */

public class SungJukV4 {
    public static void main(String[] args) {
//      변수 선언

        String[] name = new String[3];
        int[] kor = new int[3];
        int[] eng = new int[3];
        int[] mat = new int[3];
        int[] sum = new int[3];
        double[] mean = new double[3];
        char[] grd = new char[3];
        String fmt = "이름 : %s\n국어 : %d\n영어 : %d\n수학 : %d\n총점 : %d\n평균 : %.2f\n학점 : %c";
        String[] result = new String[3];

        readSungJuk(name, kor, eng, mat, sum, mean);
        computeSungJuk(kor, eng, mat, sum, mean, grd);
        printSungJuk(fmt, name, kor, eng, mat, sum, mean, grd, result);
    }
//main

    // 성적 읽어오기 : readSungJuk
    public static void readSungJuk(String name[], int kor[], int eng[], int mat[], int[] sum, double[] mean) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + "번째 학생 성적 입력중...");
            System.out.print("이름을 입력하세요 : ");
            name[i] = sc.nextLine();

            System.out.print("국어를 입력하세요 : ");
            kor[i] = Integer.parseInt(sc.nextLine());

            System.out.print("영어를 입력하세요 : ");
            eng[i] = Integer.parseInt(sc.nextLine());

            System.out.print("수학을 입력하세요 : ");
            mat[i] = Integer.parseInt(sc.nextLine());
            sum[i] = kor[i] + eng[i] + mat[i];
            mean[i] = (double) sum[i] / 3;
        }
    }//readSungJuk

    //성적 데이터 총점,평균,학점 처리 : computeSungJuk
    public static void computeSungJuk(int kor[], int eng[], int mat[], int sum[], double mean[], char grd[]) {
        for (int i = 0; i < 3
                ; i++) {
            switch ((int) (mean[i] / 10)) {
                case 10:
                case 9:
                    grd[i] = '수';
                    break;
                case 8:
                    grd[i] = '우';
                    break;
                case 7:
                    grd[i] = '미';
                    break;
                case 6:
                    grd[i] = '양';
                    break;
                default:
                    grd[i] = '가';

                    mean[i] = Math.round(mean[i] * 100) / 100.0;

            }
        }

    } // computeSungJuk

    // 처리 결과 출력 : printSungJuk
    public static void printSungJuk(String fmt, String[] name, int[] kor, int[] eng, int[] mat, int[] sum, double[] mean, char[] grd, String[] result) {
        for (int i = 0; i < 3; i++) {
            result[i] = String.format(fmt, name[i], kor[i], eng[i], mat[i], sum[i], mean[i], grd[i]);
            System.out.println(result[i]);
            System.out.println("----------------");
        }
    } // printSungJuk

}