package lab.Q81;

public class Members {
    private String type; //nomal , dealer
    private String name;
    private String id;
    private String birth;
    private String regNum;
    private String address;
    private String callNum;
    private String phoneNum;
    private String list;
    private String credit;
    private String companyCallNum;

    //nomal_customer constructor
    public Members(String name, String id, String birth, String regNum, String address, String callNum, String phoneNum) {
        this.type = "normal_customer";
        this.name = name;
        this.id = id;
        this.birth = birth;
        this.regNum = regNum;
        this.address = address;
        this.callNum = callNum;
        this.phoneNum = phoneNum;
    }

    //dealer_customer constructor
    public Members(String name, String id, String birth, String regNum, String address, String callNum, String phoneNum, String list, String credit, String companyCallNum) {
        this.type = "dealer_customer";
        this.name = name;
        this.id = id;
        this.birth = birth;
        this.regNum = regNum;
        this.address = address;
        this.callNum = callNum;
        this.phoneNum = phoneNum;
        this.list = list;
        this.credit = credit;
        this.companyCallNum = companyCallNum;
    }

    //setter
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCallNum(String callNum) {
        this.callNum = callNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setList(String list) {
        this.list = list;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public void setCompanyCallNum(String companyCallNum) {
        this.companyCallNum = companyCallNum;
    }

    //getter
    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getBirth() {
        return birth;
    }

    public String getRegNum() {
        return regNum;
    }

    public String getAddress() {
        return address;
    }

    public String getCallNum() {
        return callNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getList() {
        return list;
    }

    public String getCredit() {
        return credit;
    }

    public String getCompanyCallNum() {
        return companyCallNum;
    }
}

