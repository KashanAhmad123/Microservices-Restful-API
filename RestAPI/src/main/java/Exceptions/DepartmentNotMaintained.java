package Exceptions;

public class DepartmentNotMaintained extends Exception{
    private String message;

    public DepartmentNotMaintained(String message){
        super(message);
    }
}
