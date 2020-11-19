package lab;

public class Subject {
    String subjectNum;
    String subject;
    String subjectOutline;
    int chargeProfessorNum;


    public Subject(String subjectNum, String subject, String subjectOutline, int chargeProfessorNum){
        this.subjectNum = subjectNum;
        this.subject = subject;
        this.subjectOutline=subjectOutline;
        this.chargeProfessorNum = chargeProfessorNum;
    }

    public Subject(){
        subjectNum = "5029";
        subject = "생활의 참견";
        subjectOutline = "음식의 영양";
        chargeProfessorNum = 556;

    }
}
