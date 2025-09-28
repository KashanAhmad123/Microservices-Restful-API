package Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(value = DepartmentNotMaintained.class)
    public Object handleDepartmentNotFound(DepartmentNotMaintained ex, WebRequest request, Model model){
        String acceptHeader= request.getHeader("Accept");
        if(acceptHeader!=null && acceptHeader.contains("text/html")){
            model.addAttribute("errorMessage", ex.getMessage());
            return "department";
        }

        Response r= new Response(
                HttpStatus.NO_CONTENT.name(),
                404,ex.getMessage(), request.getDescription(false)
        );

        return new ResponseEntity<>(r,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(value = WrongDepartmentID.class)
    public Object handleWrongDepartmentID(WrongDepartmentID ex, WebRequest request, Model model){
        String acceptHeader= request.getHeader("Accept");
        if(acceptHeader!=null && acceptHeader.contains("text/html")){
            model.addAttribute("errorMessage", ex.getMessage());
            return "department";
        }

        Response erorrResponse= new Response(
                HttpStatus.NOT_FOUND.name(), 404,"Department not exist with this ID",ex.getMessage()
        );
        return  new ResponseEntity<>(erorrResponse,HttpStatus.NOT_FOUND);

    }
}
