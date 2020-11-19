package lab;

public class Ex01 {
    public static void main(String[] args) {

        Student std = new Student();
        Major mj = new Major();
        Subject sj = new Subject();
        Professor pf = new Professor();

        /*
        std.studnetNum = 201350050;
        std.name = "김태희";
        std.address = "경기도 고양시";
        std.birthYMD = "1985.3.22";
        std.professorNum = "504";

        mj.major = "컴퓨터공학";
        mj.phoneNum = "123-4567-8901";
        mj.location = "E동 2층";
        mj.majorBossNum = "504";

        sj.subjectNum = "0205";
        sj.subject = "프로그래밍";
        sj.subjectOutline = "자바 프로그래밍";
        sj.chargeProfessorNum = 301;

        pf.professorNum = 301;
        pf.professorName = "이순신";
        pf.majorOfProfessor = "프로그래밍";
        */
        System.out.println(std.studnetNum);
        System.out.println(std.name);
        System.out.println(std.address);
        System.out.println(std.birthYMD);
        System.out.println(std.professorNum);

        System.out.println(mj.major);
        System.out.println(mj.phoneNum);
        System.out.println(mj.location);
        System.out.println(mj.majorBossNum);

        System.out.println(sj.subjectNum);
        System.out.println(sj.subject);
        System.out.println(sj.subjectOutline);
        System.out.println(sj.chargeProfessorNum);

        System.out.println(pf.professorNum);
        System.out.println(pf.professorName);
        System.out.println(pf.majorOfProfessor);

        System.out.println("-----------------");

        // 매개변수를 사용하는 생성자로 객체생성
        Student std2 = new Student(201250006,"송혜교","서울영등포구","1988.9.17","컴퓨터","301");
        Major mj2 = new Major("의상디자인","234-5678-9012","A동 1층","301");
        Subject sj2 = new Subject("0211","드레스코드","옷입기의기초",445);
        Professor pf2 = new Professor(445,"정약용","의상디자인");



        System.out.println(std2.studnetNum);
        System.out.println(std2.name);
        System.out.println(std2.address);
        System.out.println(std2.birthYMD);
        System.out.println(std2.professorNum);

        System.out.println(mj2.major);
        System.out.println(mj2.phoneNum);
        System.out.println(mj2.location);
        System.out.println(mj2.majorBossNum);

        System.out.println(sj2.subjectNum);
        System.out.println(sj2.subject);
        System.out.println(sj2.subjectOutline);
        System.out.println(sj2.chargeProfessorNum);

        System.out.println(pf2.professorNum);
        System.out.println(pf2.professorName);
        System.out.println(pf2.majorOfProfessor);
    }


}
