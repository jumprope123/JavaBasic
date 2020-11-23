package shin.cooperation;

public class Taxi {
    int money;
    int carNum;
    int count;

    public Taxi(int carNum) {
        this.carNum = carNum;
    }

    public void take(int money){
        this.money += money;
        count++;
    }
    public void showInfo(){
        System.out.println("해당 택시는"+carNum+"번 택시이며 현재까지 택시가 번 돈은"+money+"이며, 총 이용수는"+count+"입니다.");
    }
}
