package semiProject2;

public class EmployeeJDBC extends EmployeeUtil{
    // JDBC에서 사용할 SQL문
    static String insertSQL = "insert into employees values (?,?,?,?,?,?,?,?,?,?,?)";

    static String readSQL = "select * from employees";

    static String readOneSQL = "select * from employees where employee_id = ?";

    static String modifySQL = "update employees set first_name = ? , last_name = ?, email = ?, phone_number = ?, hire_date = ? where employee_id = ?";

    static String deleteSQL = "delete from employees where employee_id = ?";
}
