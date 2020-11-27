package semiProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * EmployeeV1Service
 * 인사정보 처리 인터페이스를 구현한 클래스
 * 인사정보 처리에 대한 CRUD 코드를 작성해 둠
 */
public class EmployeeV1Service extends EmployeeV1GenericService {

    List<EmployeeVO> empdata = new ArrayList<>();
    EmployeeVO emp;
    @Override
    public void newEmployee() {
        emp = new EmployeeVO(0,"","","","","","",0,0,0,0);
        Scanner sc = new Scanner(System.in);
        System.out.print("사번을 입력하세요 : ");
        emp.setEmpNo(Integer.parseInt(sc.nextLine()));
        System.out.print("성을 입력하세요 : ");
        emp.setfName(sc.nextLine());
        System.out.print("이름을 입력하세요 : ");
        emp.setlName(sc.nextLine());
        System.out.print("메일을 입력하세요 : ");
        emp.seteMail(sc.nextLine());
        System.out.print("핸드폰 번호를 입력하세요 : ");
        emp.setPhone(sc.nextLine());
        System.out.print("입사일을 입력하세요 : ");
        emp.sethDate(sc.nextLine());
        System.out.print("Job_Id를 입력하세요 : ");
        emp.setJobId(sc.nextLine());
        System.out.print("월급을 입력하세요 : ");
        emp.setSal(Integer.parseInt(sc.nextLine()));
        System.out.print("커미션률을 입력하세요 : ");
        emp.setCmmm(Double.parseDouble(sc.nextLine()));
        System.out.print("매니저Id를 입력하세요 : ");
        emp.setMgrId(Integer.parseInt(sc.nextLine()));
        System.out.print("부서번호를 입력하세요 : ");
        emp.setDeptId(Integer.parseInt(sc.nextLine()));

        empdata.add(emp);

    }

    /**
     * 기본인사정보 출력
     */
    @Override
    public void readEmployee() {
        //데이터 출력시 간격 유지를 위해 숫자 사용
       String fmt = "%8s %8s %8s %8s %8s %8s\n";

       Iterator<EmployeeVO> iter = empdata.iterator();
        System.out.printf(fmt,"empno","lname","email","jobid","mgrid","detid");


       while (iter.hasNext()){
           EmployeeVO e = iter.next();
           System.out.printf(fmt,e.getEmpNo(),e.getlName(),e.geteMail(),e.getJobId(),e.getMgrId(),e.getDeptId());
       }
    }

    @Override
    /**
     * 인사정보 상세 출력
     * 사원 번호를 입력받아서 출력함
     */
    public void readOneEmployee() {
        String fmt = "%8s %8s %8s %8s %8s %8s %8s %8s %8s %8s %8s\n";

        EmployeeVO emp = new EmployeeVO();
        Scanner sc = new Scanner(System.in);
        System.out.print("상세조회를 원하는 사번을 입력하세요 : ");
        emp.setEmpNo( Integer.parseInt(sc.nextLine()));

        for (EmployeeVO e : empdata) {
            // 입력한 사원번호와 순회해서 꺼낸 사원정보의 사원번호를 비교
            // 일치하면 이것을 출력하기 위해 다른 변수에 저장함
            if(e.getEmpNo() == emp.getEmpNo()){
                emp = e;
            }
        }
        System.out.printf(fmt,"empno","fname","lname","email","phone","hdate","jobid","sal","comm","mgrid","detid");
        System.out.printf(fmt,emp.getEmpNo(),emp.getfName(),emp.getlName(),emp.geteMail(),emp.getPhone(),
                emp.gethDate(),emp.getJobId(),emp.getSal(),emp.getCmmm(),emp.getMgrId(),emp.getDeptId());
    }


    @Override
    public void modifyEmployee() {
        EmployeeVO emp = new EmployeeVO();
        System.out.println("수정하실 직원의 직원번호를 적어주세요");
        Scanner sc = new Scanner(System.in);
        emp.setEmpNo(Integer.parseInt(sc.nextLine()));
        Iterator<EmployeeVO> iter = empdata.iterator();
        int checkcnt = 0;
        while (iter.hasNext()){
            EmployeeVO e = iter.next();
            if (e.getEmpNo() == emp.getEmpNo()){
                emp = e;
                checkcnt = 1;
            }
        }
        if (checkcnt == 0){
            System.out.println("해당 직원번호는 존재하지 않습니다.");
        }
        System.out.print("성을 입력하세요 : ");
        emp.setfName(sc.nextLine());
        System.out.print("이름을 입력하세요 : ");
        emp.setlName(sc.nextLine());
        System.out.print("메일을 입력하세요 : ");
        emp.seteMail(sc.nextLine());
        System.out.print("핸드폰 번호를 입력하세요 : ");
        emp.setPhone(sc.nextLine());
        System.out.print("입사일을 입력하세요 : ");
        emp.sethDate(sc.nextLine());
        System.out.print("Job_Id를 입력하세요 : ");
        emp.setJobId(sc.nextLine());
        System.out.print("월급을 입력하세요 : ");
        emp.setSal(Integer.parseInt(sc.nextLine()));
        System.out.print("커미션률을 입력하세요 : ");
        emp.setCmmm(Double.parseDouble(sc.nextLine()));
        System.out.print("매니저Id를 입력하세요 : ");
        emp.setMgrId(Integer.parseInt(sc.nextLine()));
        System.out.print("부서번호를 입력하세요 : ");
        emp.setDeptId(Integer.parseInt(sc.nextLine()));

    }
    @Override
    public void removeEmployee() {
        EmployeeVO emp = new EmployeeVO();
        System.out.println("삭제를 원하시는 직원의 직원번호를 입력해주세요");
        Scanner scan = new Scanner(System.in);
        emp.setEmpNo(Integer.parseInt(scan.nextLine()));
        int checkCnt = 0;
        for (EmployeeVO ev : empdata){
            if (ev.getEmpNo() == emp.getEmpNo()){
                break;
            }
            checkCnt++;
        }
        System.out.println("진짜 삭제하시겠습니까? y/n");
        String yesOrNo = scan.nextLine();
        if(yesOrNo.equals("y")||yesOrNo.equals("Y")){
            empdata.remove(checkCnt);}
    }

    /**
     * 인사 정보 처리 UI 출력
     */
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
            .append("인사관리 프로그램 v1\n")
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

}
