package mk.ukim.finki.wp.lab.model.exeptions;

public class TooMuchSpicyException extends RuntimeException {

    public TooMuchSpicyException(String errorMessage){
        super(errorMessage);
    }
}