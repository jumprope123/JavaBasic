package shin;

// 클래스 종류
// VO / DTO : ValueObject , Data Transfer Object
// 계층간 데이터 교환을 위한 자바빈즈를 의미
// 값만 저장하기 위해 생성하는 클래스
// 주로 데이터베이스 테이블의 각 열과 연계해서 작성

// DAO : data access object
// 데이터베이스를 사용해서 데이터를 추가/조회/수정/삭제하는 기능을 전담하는 클래스

// vo 클래스와 연계해서 작성함
// 인터페이스로 기능을 정의하고 클래스로 구현함

// Service : 비지니스 로직 처리를 담당하는 클래스
// VO로 저장된 데이터를 DAO로 넘기기 전에 처리해야하는 일반적인 작업을 기능으로 구현한 클래스

// 일반적인 프로그래밍 작성흐름
// J2EE 개발에 최적화된 방식
// VO -> Service -> DAO
public class ClassMakeRule {
    public static void main(String[] args) {
        // 세금계산을 위한 객체 생성
        ComputeTax choi = new ComputeTax(3500,1);
        System.out.println(choi.manageTax());

        choi = new ComputeTax(7000,0);
        System.out.println(choi.manageTax());

    }
}

class ComputeTax {
    private  int salary;
    private  int isMarried; //0이면 예 , 1이면 아니오.

    // 기본 생성자
    public ComputeTax() {
    }

    // 생성자
    public ComputeTax(int salary, int isMarried) {
        this.salary = salary;
        this.isMarried = isMarried;
    }

    //세터 게터
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getIsMarried() {
        return isMarried;
    }

    public void setIsMarried(int isMarried) {
        this.isMarried = isMarried;
    }
    // 여기까지가 VO클래스 작성


    //    세금계산
    public double manageTax() {
        double tax = 0;
        if (isMarried == 0) { //기혼
            if (salary < 6000) { //연봉 6천미만
                tax = salary * 0.15;
            } else { //6천이상]
                tax = salary * 0.35;
            }
        } else { //미혼
            if (salary < 3000){
                tax = salary * 0.1;
            }else {
                tax = salary *0.25;
            }
        }
        return tax;
    }
    // 여기까지가 Service 클래스 작성

}
