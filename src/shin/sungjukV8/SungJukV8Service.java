package shin.sungjukV8;

import com.sun.org.apache.xpath.internal.objects.XStringForChars;
import shin.sungjukV5.SungJukVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * SungJukV8GenericService
 * 성적 처리 추상클래스를 상속해서 만든 클래스
 */
public class SungJukV8Service extends SungJukV8GenericService {

    //멤버변수 선언
    // 입력받은 모든 성적 데이터를 저장하는 동적 배열 변수 선언
    List<SungJukVO> sjdata = new ArrayList<>();

    //입력받은 성적 데이터를 저장하기 위한 변수
    SungJukVO sj = null;

    /**
     * 이름과 성적 데이터를 입력받아
     * 총점,평균,학점을 계산한 뒤
     * 동적배열에 추가함
     */
    @Override
    public void newSungJuk() {
        String name;
        int kor, eng, mat;

        Scanner sc = new Scanner(System.in);
        System.out.print("이름을 입력하세요 : ");
        name = sc.nextLine();
        System.out.print("국어를 입력하세요 : ");
        kor = sc.nextInt();
        System.out.print("영어를 입력하세요 : ");
        eng = sc.nextInt();
        System.out.print("수학을 입력하세요 : ");
        mat = sc.nextInt();

            //입력받은 성적 데이터를 동적 배열에 저장
       sj = new SungJukVO(name,kor,eng,mat, 0,0,'가');
        //총점, 평균, 학점을 계산
        computeSungJuk(sj);
            //처리된 성적 데이터를 동적 배열에 저장
        sjdata.add(sj);
    }

    /**
     * 저장된 성적 데이터들 중에서
     * 번호, 이름, 국어, 영어, 수학만 뽑아서 리스트형태로 출력
     * */
    @Override
    public void readSungJuk() {
        //동적 배열에 저장된 데이터를 출력하는 Iterator
        Iterator<SungJukVO> iter = sjdata.iterator();
        StringBuilder sb = new StringBuilder();
        while (iter.hasNext()){
            SungJukVO sj = iter.next();
            sb.append("이름 : ").append(sj.getName()).append(", ")
                    .append("국어 : ").append(sj.getKor()).append(", ")
                    .append("영어 : ").append(sj.getEng()).append(", ")
                    .append("수학 : ").append(sj.getMat()).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 상세조회할 학생 이름을 입력받아
     * 이름, 국어, 영어, 수학, 총점, 평균, 학점을 출력
     */
    @Override
    public void readOneSungJuk() {
        String fmt = "이름 : %s, 국어 : %d, 영어 : %d, 수학 : %d" +
                "총점 : %d, 평균 : %.1f, 학점 : %s\n";

        //상세 조회할 학생 이름 입력 받음
        Scanner sc = new Scanner(System.in);
        System.out.print("조회할 학생 이름은? ");
        String name = sc.nextLine();

        // 입력받은 이름으로 데이터 검색 후 결과출력
        for (SungJukVO sj : sjdata){
            if(sj.getName().equals(name)){
                System.out.printf(fmt,sj.getName(),sj.getKor(),
                        sj.getEng(),sj.getMat(),sj.getSum(),sj.getMean(),
                        sj.getGrd());
                break;
            }
        }


    }

    /**
     * 성적처리프로그램의 메뉴 출력 메서드
     */
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
        .append("성적 처리프로그램 v8\n")
        .append("-------------------\n")
        .append("1. 성적 데이터 입력\n")
        .append("2. 성적 데이터 조회\n")
        .append("3. 성적 데이터 상세조회\n")
        .append("4. 성적 데이터 수정\n")
        .append("5. 성적 데이터 삭제\n")
        .append("0. 프로그램 종료\n")
        .append("-------------------\n")
        .append("원하시는 작업은 ? ");
        System.out.print(sb);
    }

    //
    public void computeSungJuk(SungJukVO sj) {
        sj.setSum(sj.getKor() + sj.getEng() + sj.getMat());
        sj.setMean((double) sj.getSum() / 3);
        switch ((int) (sj.getMean() / 10)) {
            case 10:
            case 9:
                sj.setGrd('수');
                break;
            case 8:
                sj.setGrd('우');
                break;
            case 7:
                sj.setGrd('미');
                break;
            case 6:
                sj.setGrd('양');
                break;
            default:
                sj.setGrd('가');
        } // switch
    } // computeSunjuk
    }

