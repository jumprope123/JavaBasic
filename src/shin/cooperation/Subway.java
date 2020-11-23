package shin.cooperation;

public class Subway {
    String lineNumber;
    int passangerCount;
    int money;

    public Subway(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void take(int money){
        this.money += money;
        passangerCount++;
    }

    public void showInfo(){
        System.out.println(lineNumber + "의 승객은" + passangerCount + "명이고 , 수입은" + money + "입니다");
    }
}
