package semiProject;

import javax.imageio.ImageReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class EmployeeV1Service extends EmployeeV1GenericService {
    List<EmployeeVO> evolist = new ArrayList<>();

    private int empNo;
    private String fName;
    private String lName;
    private String eMail;
    private String phone;
    private  String hDate;
    private String jobId;
    private int sal;
    private double cmmm;
    private int mgrId;
    private int deptId;

    @Override
    public void newPInfo() {
        Scanner scan = new Scanner(System.in);
        System.out.print("사번을 입력하세요 : ");
        empNo = Integer.parseInt(scan.nextLine());
        System.out.print("성을 입력하세요 : ");
        fName = scan.nextLine();
        System.out.print("이름을 입력하세요 : ");
        lName = scan.nextLine();
        System.out.print("메일을 입력하세요 : ");
        eMail = scan.nextLine();
        System.out.print("핸드폰 번호를 입력하세요 : ");
        phone = scan.nextLine();
        System.out.print("입사일을 입력하세요 : ");
        hDate = scan.nextLine();
        System.out.print("Job_Id를 입력하세요 : ");
        jobId = scan.nextLine();
        System.out.print("월급을 입력하세요 : ");
        sal = Integer.parseInt(scan.nextLine());
        System.out.print("커미션률을 입력하세요 : ");
        try {
            cmmm = Double.parseDouble(scan.nextLine());
        }catch (NumberFormatException e){
            cmmm = 0;
        }
        System.out.print("매니저Id를 입력하세요 : ");
        try{
            mgrId = Integer.parseInt(scan.nextLine());
        }catch (NumberFormatException e){
            mgrId = 0;
        }
        System.out.print("부서번호를 입력하세요 : ");
        deptId = Integer.parseInt(scan.nextLine());

        EmployeeVO evo = new EmployeeVO(empNo,fName,lName,eMail,phone,hDate,jobId,sal,cmmm, mgrId,deptId);
        evolist.add(evo);

    }

    @Override
    public void readPInfo() {
        Iterator<EmployeeVO> itr = evolist.iterator();
        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            EmployeeVO evo = itr.next();
            sb.append("사번 : ").append(evo.getEmpNo()).append(", ")
                    .append("성 : ").append(evo.getfName()).append(", ")
                    .append("이름 : ").append(evo.getlName()).append(", ")
                    .append("메일 : ").append(evo.geteMail()).append(", ")
                    .append("job_id : ").append(evo.getJobId()).append(", ")
                    .append("매니저Id : ").append(evo.getMgrId()).append(", ")
                    .append("부서번호 : ").append(evo.getDeptId()).append("\n");
        }
        System.out.println(sb);
    }

    @Override
    public void readOnePInfo() {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int inputNum;
        System.out.print("상세조회를 원하는 사번을 입력하세요 : ");
        inputNum = scan.nextInt();
        Iterator<EmployeeVO> evo = evolist.iterator();
        while (evo.hasNext()){
            EmployeeVO evo1 = evo.next();
            if (evo1.getEmpNo() == inputNum){
                sb.append("사번 : ").append(evo1.getEmpNo()).append(", ")
                        .append("성 : ").append(evo1.getfName()).append(", ")
                        .append("이름 : ").append(evo1.getlName()).append(", ")
                        .append("메일 : ").append(evo1.geteMail()).append(", ")
                        .append("폰번호 : ").append(evo1.getPhone()).append(", ")
                        .append("입사일 : ").append(evo1.gethDate()).append(", ")
                        .append("job_id : ").append(evo1.getJobId()).append(", ")
                        .append("월급 : ").append(evo1.getSal()).append(", ")
                        .append("커미션률 : ").append(evo1.getCmmm()).append(", ")
                        .append("매니저Id : ").append(evo1.getMgrId()).append(", ")
                        .append("부서번호 : ").append(evo1.getDeptId());
                break;
            }
        }
        System.out.println(sb);

    }

    @Override
    public void modifyPInfo() {
        System.out.println("수정을 원하는 직원의 사번을 입력하세요");
        Scanner scan = new Scanner(System.in);
        int inputNum = scan.nextInt();
        Iterator<EmployeeVO> evo = evolist.iterator();
        while (evo.hasNext()){
            EmployeeVO evo1 = evo.next();
            if (evo1.getEmpNo() == inputNum){
                String blink = scan.nextLine(); // /r /n skip
                System.out.print("성을 입력하세요 : ");
                evo1.setfName(scan.nextLine());
                System.out.print("이름을 입력하세요 : ");
                evo1.setlName(scan.nextLine());
                System.out.print("메일을 입력하세요 : ");
                evo1.seteMail(scan.nextLine());
                System.out.print("핸드폰 번호를 입력하세요 : ");
                evo1.setPhone(scan.nextLine());
                System.out.print("입사일을 입력하세요 : ");
                evo1.sethDate(scan.nextLine());
                System.out.print("Job_Id를 입력하세요 : ");
                evo1.setJobId(scan.nextLine());
                System.out.print("월급을 입력하세요 : ");
                evo1.setSal(Integer.parseInt(scan.nextLine()));
                System.out.print("커미션률을 입력하세요 : ");
                try {
                    evo1.setCmmm(Double.parseDouble(scan.nextLine()));
                }catch (NumberFormatException e){
                    evo1.setCmmm(0);
                }
                System.out.print("매니저Id를 입력하세요 : ");
                try{
                    evo1.setMgrId(Integer.parseInt(scan.nextLine()));
                }catch (NumberFormatException e){
                    evo1.setMgrId(0);
                }
                System.out.print("부서번호를 입력하세요 : ");
                evo1.setDeptId(Integer.parseInt(scan.nextLine()));
            }
            else {
                System.out.println("일치하는 직원이 없습니다.");
            }
        }
    }

    @Override
    public void removePInfo() {
        super.removePInfo();
    }

    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("인사관리 프로그램 v8\n")
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
