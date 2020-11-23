package lab.movies;

public class Movie {
    //멤버변수 선언
    private String title;
    private String year;
    private int runtime;
    private String prdtin;
    private String[] genre;
    private String[] dirtor;
    private String[] actor;
    private String summary;
    private String desc;

    //생성자
    public Movie() {
    }

    public Movie(String title, String year, int runtime, String prdtin, String[] genre, String[] dirtor, String[] actor, String summary, String desc) {
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.prdtin = prdtin;
        this.genre = genre;
        this.dirtor = dirtor;
        this.actor = actor;
        this.summary = summary;
        this.desc = desc;
    }

    //setter

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public void setPrdtin(String prdtin) {
        this.prdtin = prdtin;
    }

    public void setGenre(String[] genre) {
        this.genre = genre;
    }

    public void setDirtor(String[] dirtor) {
        this.dirtor = dirtor;
    }

    public void setActor(String[] actor) {
        this.actor = actor;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    //getter

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public int getRuntime() {
        return runtime;
    }

    public String getPrdtin() {
        return prdtin;
    }

    public String[] getGenre() {
        return genre;
    }

    public String[] getDirtor() {
        return dirtor;
    }

    public String[] getActor() {
        return actor;
    }

    public String getSummary() {
        return summary;
    }

    public String getDesc() {
        return desc;
    }
}
