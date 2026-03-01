public class InvalidMemberNameException extends RuntimeException{
    public InvalidMemberNameException(String message) {
        super(message);
    }
    public InvalidMemberNameException(){
        super("Operation failed: The provided member name is invalid or empty.");
    }
}
