public class InvalidItemTitleException extends RuntimeException{
    public InvalidItemTitleException(String message){
        super(message);
    }
    public InvalidItemTitleException(){
        super("Operation failed: The provided item title is invalid or empty.");
    }
}
