package booksJDBC;

public class BooksVO {
    int bookid;
    String bookname;
    String publisher;
    int price;

    public BooksVO() {
    }

    public BooksVO(int bookid, String bookname, String publisher, int price) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.publisher = publisher;
        this.price = price;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
