package mk.ukim.finki.wp.lab.model.exeptions;

public class IngredientNameException extends RuntimeException {

    public IngredientNameException(String errorMessage){
        super(errorMessage);
    }
}