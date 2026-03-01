public class OverLimitException extends RuntimeException{
    public OverLimitException(String message){
        super(message);
    }
    public OverLimitException(){
        super("Operation failed: The defined capacity or limit has been exceeded.");
    }
}
