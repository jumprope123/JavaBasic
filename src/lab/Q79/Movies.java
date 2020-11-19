package lab.Q79;

public class Movies {
    private String title;
    private String openingDay;
    private String runnigTime;
    private String maker;
    private String[] genre;
    private String[] director;
    private String[] actor;
    private String synopsis;
    private String[] introduce;

//    defalut constructor
    public Movies(){
    }

//    constructor
    public Movies(String title, String openingDay, String runnigTime, String maker, String[] genre, String[] director, String[] actor, String synopsis, String[] introduce) {
        setTitle(title);
        setOpeningDay(openingDay);
        setRunnigTime(runnigTime);
        setMaker(maker);
        setGenre(genre);
        setDirector(director);
        setActor(actor);
        setSynopsis(synopsis);
        setIntroduce(introduce);
    }

    //    setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setOpeningDay(String openingDay) {
        this.openingDay = openingDay;
    }

    public void setRunnigTime(String runnigTime) {
        this.runnigTime = runnigTime;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public void setDirector(String[] director) {
        this.director = director;
    }

    public void setActor(String[] actor) {
        this.actor = actor;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setIntroduce(String[] introduce) {
        this.introduce = introduce;
    }

    //getter


    public String getTitle() {
        return title;
    }

    public String getOpeningDay() {
        return openingDay;
    }

    public String getRunnigTime() {
        return runnigTime;
    }

    public String getMaker() {
        return maker;
    }

    public String[] getGenre() {
        return genre;
    }

    public String[] getDirector() {
        return director;
    }

    public String[] getActor() {
        return actor;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String[] getIntroduce() {
        return introduce;
    }
}
