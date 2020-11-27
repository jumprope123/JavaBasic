package semiProject;

import javax.swing.text.SimpleAttributeSet;
import java.io.*;
import java.util.Iterator;

public class EmployeeV2Service extends EmployeeV1Service {

    private String fpath = "c:/Java/employee.dat";
    protected FileWriter fw;
    protected BufferedWriter bw;
    protected FileReader fr;
    protected BufferedReader br;

    public EmployeeV2Service() {
        //맨 처음 해당 클래스의 객체가 만들어질때 할 일로, 파일을 읽어온다.
        try {
            loadEmployee();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("읽어올 파일의 경로가 띠용? 없거나 잘못됫네 ?");
        }
    }

    /**
     * 인사 정보 처리 UI 출력
     */
    public void displayMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------\n")
                .append("인사관리 프로그램 v2\n")
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
        super.newEmployee();
        //여기까지 empdata 라는 List에 저장

        //wirteEmployee 함수로 묶어서 try/catch문을 써서 한번에 오류처리
        try {
            writeEmployee();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 저장함수 구현, 오류는 저 위로 쓰로잉함
    * @throws IOException
     */
    protected void writeEmployee() throws IOException {
        fw = new FileWriter(fpath,true);
        bw = new BufferedWriter(fw);
        String fmt = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        String data = String.format(fmt,emp.getEmpNo(),emp.getfName(),emp.getlName(),emp.geteMail(),
        emp.getPhone(),emp.gethDate(),emp.getJobId(),emp.getSal(),emp.getCmmm(),emp.getMgrId(),emp.getDeptId());
        bw.write(data);
        bw.newLine();
        bw.close();
        fw.close();

    }



    protected void outWriteEmployee() throws IOException {
        fw = new FileWriter(fpath);
        bw = new BufferedWriter(fw);
        String fmt = "%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s";
        Iterator<EmployeeVO> itr = empdata.iterator();
        while (itr.hasNext()) {
            emp = itr.next();
            String data = String.format(fmt, emp.getEmpNo(), emp.getfName(), emp.getlName(), emp.geteMail(),
                    emp.getPhone(), emp.gethDate(), emp.getJobId(), emp.getSal(), emp.getCmmm(), emp.getMgrId(), emp.getDeptId());
            bw.write(data);
            bw.newLine();
        }
        bw.close();
        fw.close();

    }


    /**
     * 최초실행시 파일에서 정보를 읽어오는 loadEmployee 함수 생성
     */
    protected void loadEmployee() throws IOException {
        fr = new FileReader(fpath);
        br = new BufferedReader(fr);

        while (br.ready()){
            String[] s = br.readLine().split(","); //split자체가 배열형태로 반환
/*
           emp = new EmployeeVO(Integer.parseInt(s[0]),s[1],s[2],s[3],s[4],s[5],s[6],Integer.parseInt(s[7]),
                   Double.parseDouble(s[8]),Integer.parseInt(s[9]),Integer.parseInt(s[10]));*/

            emp = new EmployeeVO();
            emp.setEmpNo(Integer.parseInt(s[0]));
            emp.setfName(s[1]);
            emp.setlName(s[2]);
            emp.seteMail(s[3]);
            emp.setPhone(s[4]);
            emp.sethDate(s[5]);
            emp.setJobId(s[6]);
            emp.setSal(Integer.parseInt(s[7]));
            emp.setCmmm(Double.parseDouble(s[8]));
            emp.setMgrId(Integer.parseInt(s[9]));
            emp.setDeptId(Integer.parseInt(s[10]));

            empdata.add(emp);

        }
        fr.close();
        br.close();
    }

}

