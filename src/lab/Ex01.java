package lab;

public class Ex01 {
    public static void main(String[] args) {

        Student std = new Student();
        Major mj = new Major();
        Subject sj = new Subject();
        Professor pf = new Professor();

        std.studnetNum = 201350050;
        std.name = "김태희";
        std.address = "경기도 고양시";
        std.birthYMD = "1985,3,22";
        std.professorNum = 504;

        mj.major = "컴퓨터공학";
        mj.phoneNum = "123,4567,8901";
        mj.location = "E동 2층";
        mj.MajorBossNum = 504;

        sj.subjectNum = 0205;
        sj.subject = "프로그래밍";
        sj.subjectOutline = "자바 프로그래밍";
        sj.ChargeProfessorNum = 301;

        pf.professorNum = 301;
        pf.professorName = "이순신";
        pf.majorOfProfessor = "프로그래밍";
    }
}
