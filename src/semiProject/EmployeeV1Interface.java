package semiProject;

import java.io.IOException;

/**
 * EmployeeV1Interface
 * 인사정보 처리 인터페이스
 */
public interface EmployeeV1Interface {
    void newEmployee() throws IOException;
    void readEmployee();
    void readOneEmployee();
    void modifyEmployee();
    void removeEmployee();
}
