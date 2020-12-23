package semiProject2;

import javafx.scene.transform.Scale;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class EmployeeV3Service extends EmployeeGeneric{
    Scanner scan = new Scanner(System.in);

    public void showMenu(){
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("인사관리 프로그램 v3\n")
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
    public void newEmployee() {
        System.out.print("직원 번호를 입력하세요. 중복금지");
        int empid = Integer.parseInt(scan.nextLine());
        System.out.print("직원 성을 입력하세요");
        String empfname = scan.nextLine();
        System.out.print("직원 이름을 입력하세요");
        String emplname = scan.nextLine();
        System.out.print("직원 이메일을 입력하세요");
        String empemail = scan.nextLine();
        System.out.print("직원 폰번호를 입력하세요");
        String emppnum = scan.nextLine();
        System.out.print("직원 고용일을 입력하세요");
        String emphdate = scan.nextLine();
        System.out.print("직원 직책을 입력하세요");
        String empjid = scan.nextLine();
        System.out.print("직원 연봉을 입력하세요");
        int empsal = Integer.parseInt(scan.nextLine());
        System.out.print("직원 커미션을 입력하세요");
        double empcm = Double.parseDouble(scan.nextLine());
        System.out.print("직원의 상사번호를 입력하세요");
        int empmid = Integer.parseInt(scan.nextLine());
        System.out.print("직원 부서번호를 입력하세요");
        int dpmtid = Integer.parseInt(scan.nextLine());

        EmployeeVO empvo = new EmployeeVO(empid,empfname,emplname,empemail,emppnum,emphdate,empjid,empsal,empcm,empmid,dpmtid);
        String result = EmployeeV3DAO.insertEmp(empvo);
        System.out.println(result);
    }

    @Override
    public void readEmployee() {
        ArrayList<EmployeeVO> evo = EmployeeV3DAO.readEMP();
        StringBuilder sb = new StringBuilder();
        String fmt = "%12s %12s %12s %12s %12s\n";// id,fname,lname,jobid,dept
        String result;
        result = String.format(fmt,"empNo","Fname","Lname","jobId","DeptId");
        sb.append(result);

        Iterator<EmployeeVO> itr = evo.iterator();
        while (itr.hasNext()){
           EmployeeVO ev = itr.next();
            result = String.format(fmt,ev.getEmpNo(),ev.getfName(),ev.getlName(),ev.getJobId(),ev.getDeptId());
            sb.append(result);
        }

        System.out.println(sb);

    }

    @Override
    public void readOneEmployee() {
        Scanner scan = new Scanner(System.in);
        System.out.println("검색하실 사원번호를 입력하세요");
        int inputid = Integer.parseInt(scan.nextLine());
        EmployeeVO ev = EmployeeV3DAO.readOneEMP(inputid);
        String fmt = "%10s %10s %10s %10s %10s %10s %10s %10s %10s %10s %10s";

        String result = String.format(fmt, ev.getEmpNo(),ev.getfName(),ev.getlName(),ev.geteMail(),ev.getPhone(),ev.gethDate()
        ,ev.getJobId(),ev.getSal(),ev.getComm(),ev.getMgrId(),ev.getDeptId());

        System.out.println(result);
    }

    @Override
    public void modifyEmployee() {
        System.out.print("수정하실 직원 번호를 입력하세요");
        int empid = Integer.parseInt(scan.nextLine());
        System.out.print("직원 성을 입력하세요");
        String empfname = scan.nextLine();
        System.out.print("직원 이름을 입력하세요");
        String emplname = scan.nextLine();
        System.out.print("직원 이메일을 입력하세요");
        String empemail = scan.nextLine();
        System.out.print("직원 폰번호를 입력하세요");
        String emppnum = scan.nextLine();
        System.out.print("직원 고용일을 입력하세요");
        String emphdate = scan.nextLine();

        EmployeeVO ev = new EmployeeVO(empid,empfname,emplname,empemail,emppnum,emphdate);

        String result = EmployeeV3DAO.modifySQL(ev);
        System.out.println(result);

    }

    @Override
    public void deleteEmployee() {
        System.out.println("삭제하실 사원번호를 입력하세요");
        int empid = Integer.parseInt(scan.nextLine());
        String result = EmployeeV3DAO.deleteSQL(empid);
        System.out.println(result);
    }
}
