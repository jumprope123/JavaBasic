package semiProject2;

public class EmployeeJDBC extends EmployeeUtil{
    // JDBC에서 사용할 SQL문
    static String insertSQL = "insert into employees values (?,?,?,?,?,?,?,?,?,?,?)";

    static String readSQL = "select * from employees";

    static String readOneSQL = "select * from employees where employee_id = ?";

}
