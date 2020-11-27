package semiProject;

public class EmployeeVO {
    private int empNo;
    private String fName;
    private String lName;
    private String eMail;
    private String phone;
    private String hDate;
    private String jobId;
    private int sal;
    private double comm;
    private int mgrId;
    private int deptId;

    //생성자
    public EmployeeVO() {
    }

    public EmployeeVO(int empNo, String fName, String lName, String eMail, String phone, String hDate, String jobId, int sal, double comm, int mgrId, int deptId) {
        this.empNo = empNo;
        this.fName = fName;
        this.lName = lName;
        this.eMail = eMail;
        this.phone = phone;
        this.hDate = hDate;
        this.jobId = jobId;
        this.sal = sal;
        this.comm = comm;
        this.mgrId = mgrId;
        this.deptId = deptId;
    }

//세터즈 게터즈
    public int getEmpNo() {return empNo;}

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String gethDate() {
        return hDate;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public double getCmmm() {return comm;}

    public void setCmmm(double comm) {this.comm = comm;}

    public int getMgrId() {
        return mgrId;
    }

    public void setMgrId(int mgrId) {
        this.mgrId = mgrId;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
