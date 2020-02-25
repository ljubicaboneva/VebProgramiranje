package mk.ukim.finki.wp.lab.web.rest;

public class ApiException extends RuntimeException {

    public ApiException(String errorMessage){
        super(errorMessage);
    }
}
