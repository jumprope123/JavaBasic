package lab;

public class Student {
    int studnetNum;
    String name;
    String address;
    String birthYMD;
    String major;
    String professorNum;

    public Student(){
        studnetNum = 201252110;
        name = "전지현";
        address = "경기도 의정부시";
        birthYMD = "1986.4.30";
        major = "의상디자인";
        professorNum = "445";

    }
    public Student(int studnetNum, String name, String address,
                   String birthYMD, String major , String professorNum){

        this.studnetNum = studnetNum;
        this.name = name;
        this.address = address;
        this.birthYMD = birthYMD;
        this.major = major;
        this.professorNum = professorNum;
    }
}

