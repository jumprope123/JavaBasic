package sungjukTest;

import shin.SungJukV10DAO;

import java.util.ArrayList;
import java.util.Iterator;
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
        System.out.print("이름을 입력하세요");
        String name = scan.nextLine();
        System.out.print("국어성적을 입력하세요");
        int kor = Integer.parseInt(scan.nextLine());
        System.out.print("영어성적을 입력하세요");
        int eng = Integer.parseInt(scan.nextLine());
        System.out.print("수학성적을 입력하세요");
        int mat = Integer.parseInt(scan.nextLine());
        SungJukVO sjv = new SungJukVO(name,kor,eng,mat);
        computeSungJuk(sjv);
        String result = SungJukDAO.insertSQL(sjv);
        System.out.println(result);


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
        ArrayList<SungJukVO> sjvs = SungJukDAO.selectSQL();
        Iterator<SungJukVO> iter = sjvs.iterator();
        StringBuilder sb = new StringBuilder();
        String fmt = "%8s %8s %8s %8s\n";
        String result = String.format(fmt,"sjno","name","mean","grd");
        sb.append(result);
        while (iter.hasNext()){
            SungJukVO sv = iter.next();
            result = String.format(fmt,sv.getSjno(),sv.getName(),sv.getMean(),sv.getGrd());
            sb.append(result);
        }
        System.out.print(sb.toString());

    }

    @Override
    public void readOneSungJuk() {
        SungJukVO sv = SungJukDAO.selectOneSQL();
        String fmt = " %s %s %s %s %s %s %s %s %s";
        String result = String.format(fmt,sv.getSjno(),sv.getName(),sv.getKor(),sv.getEng(),sv.getMean(),sv.getSum(),sv.getMean(),sv.getGrd(),sv.getRegdate());
        System.out.println(result);
    }

    @Override
    public void modifySungJuk() {
        SungJukVO sj = new SungJukVO();

        System.out.print("수정할 성적번호를 입력하세요");
        sj.setSjno(scan.nextInt());
        System.out.print("수정할 국어성적을 입력하세요");
        sj.setKor(scan.nextInt());
        System.out.print("수정할 영어성적을 입력하세요");
        sj.setEng(scan.nextInt());
        System.out.print("수정할 수학성적을 입력하세요");
        sj.setMat(scan.nextInt());
        computeSungJuk(sj);

        String result = SungJukDAO.updateSungJuk(sj);
        System.out.println(result);
    }

    @Override
    public void deleteSungJuk() {
        System.out.print("삭제할 성적번호를 입력하세요");
        int sjno = scan.nextInt();
        String result = SungJukDAO.deleteSungJuk(sjno);
        System.out.println(result);

    }
}
