package lab;

public class Professor {
    int professorNum;
    String professorName;
    String majorOfProfessor;

Professor(int professorNum, String professorName, String majorOfProfessor){
    this.professorNum = professorNum;
    this.professorName = professorName;
    this.majorOfProfessor = majorOfProfessor;
}

Professor(){
    professorNum = 556;
    professorName = "김유신";
    majorOfProfessor = "식품영양";
}
}


