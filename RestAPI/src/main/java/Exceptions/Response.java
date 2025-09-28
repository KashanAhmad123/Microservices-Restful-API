package Exceptions;

public class Response {
private String name;
private int code;
private String message;
private String location;

    public Response(String name, int code, String message, String location) {
        this.name = name;
        this.code = code;
        this.message = message;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getLocation() {
        return location;
    }
}
