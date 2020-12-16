package sungjukTest;

import java.util.Scanner;

public class SungJukService extends SungJukGeneral{
    Scanner scan = new Scanner(System.in);




    public void displayMenu() {
            StringBuilder sb = new StringBuilder();
            sb.append("-------------------\n")
                    .append("인사관리 프로그램 vt\n")
                    .append("-------------------\n")
                    .append("1. 인사 정보 입력\n")
                    .append("2. 인사 정보 조회\n")
                    .append("3. 인사 정보 상세조회\n")
                    .append("4. 인사 정보 수정\n")
                    .append("5. 인사 정보 삭제\n")
                    .append("0. 프로그램 종료\n")
                    .append("-------------------\n")
                    .append("원하시는 작업은 ? ");
            System.out.print(sb);
    }

    @Override
    public void newSungJuk() {
        SungJukVO sjv = new SungJukVO();
        System.out.print("이름을 입력하세요");
        String name = scan.nextLine();
        System.out.print("국어성적을 입력하세요");
        int kor = Integer.parseInt(scan.nextLine());
        System.out.print("영어성적을 입력하세요");
        int eng = Integer.parseInt(scan.nextLine());
        System.out.print("수학성적을 입력하세요");
        int mat = Integer.parseInt(scan.nextLine());
        computeSungJuk(sjv);
        String result = SungJukDOA.insertSungJuk(sjv);


    }
    public void computeSungJuk(SungJukVO sjv){
        sjv.setSum(sjv.getKor()+sjv.getEng()+sjv.getMat());
        sjv.setMean((double)sjv.getSum()/3);
        switch ((int)sjv.getMean()/10){
            case 10 :
            case 9 : sjv.setGrd('수'); break;
            case 8:sjv.setGrd('우');break;
            case 7:sjv.setGrd('미');break;
            case 6:sjv.setGrd('양');break;
            default:sjv.setGrd('가');
        }
    }

    @Override
    public void readSungJuk() {
        super.readSungJuk();
    }

    @Override
    public void readOneSungJuk() {
        super.readOneSungJuk();
    }

    @Override
    public void modifySungJuk() {
        super.modifySungJuk();
    }

    @Override
    public void deleteSungJuk() {
        super.deleteSungJuk();
    }
}
