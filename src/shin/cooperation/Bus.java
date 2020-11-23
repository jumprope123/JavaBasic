package shin.cooperation;

public class Bus {
    int busNumber;
    int passangerCount;
    int money;

    public Bus(int busNumber) {
        this.busNumber = busNumber;
    }

    public void take(int money){
        this.money += money;
        passangerCount++;
    }

    public void showInfo(){
        System.out.println("버스" + busNumber + "번의 승객은"+ passangerCount + "명이고, 수입은" + money + "입니다.");
    }
}
