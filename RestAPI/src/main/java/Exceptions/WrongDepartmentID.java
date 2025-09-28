package Exceptions;

public class WrongDepartmentID extends Exception{
    private String message ;

    public  WrongDepartmentID(String message){
        super(message);
    }
}
