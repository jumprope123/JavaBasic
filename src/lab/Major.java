package lab;

public class Major {
    String major;
    String phoneNum;
    String location;
    String majorBossNum;

    public Major(String major, String phoneNum, String location, String majorBossNum){
        this.major = major;
        this.phoneNum = phoneNum;
        this.location = location;
        this.majorBossNum = majorBossNum;
    }

    public Major(){
        major = "식품영양";
        phoneNum = "345-6789-0123";
        location = "F동 8층";
        majorBossNum = "556";
    }

}
