package booksJDBC;

public class BooksJDBC extends BooksUtil{
    static String insertJDBC = "insert into books values (?,?,?,?)";

    static String selectJDBC = "select * from books";

    static String selectOneJDBC = "select * from books where bookid = ?";

    static String modifyJDBC = "update books set bookname = ?, publisher = ? , price = ? where bookid = ?";

    static String romoveJDBC = "delete from books where bookid = ?";
}
