package lab.Q81;

public class Cars {
    private String carNum;
    private String maker;
    private String model;
    private String level;
    private String old;
    private String gear;
    private String color;
    private String mileage;
    private String price;
    private String type;

    //default constructor
    public Cars() {
    }

    // constructor
    public Cars(String carNum, String maker, String model, String level, String old, String gear, String color, String mileage, String price, String type) {
      setCarNum(carNum);
      setMaker(maker);
      setModel(model);
      setLevel(level);
      setOld(old);
      setGear(gear);
      setColor(color);
      setMileage(mileage);
      setPrice(price);
      setType(type);
    }

    //setter
    public void setCarNum(String carNum) {
        this.carNum = carNum;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setOld(String old) {
        this.old = old;
    }

    public void setGear(String gear) {
        this.gear = gear;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

//getter
    public String getCarNum() {
        return carNum;
    }

    public String getMaker() {
        return maker;
    }

    public String getModel() {
        return model;
    }

    public String getLevel() {
        return level;
    }

    public String getOld() {
        return old;
    }

    public String getGear() {
        return gear;
    }

    public String getColor() {
        return color;
    }

    public String getMileage() {
        return mileage;
    }

    public String getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }
}
