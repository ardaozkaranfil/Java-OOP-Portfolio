public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
    public UserNotFoundException(){
        super("The requested user could not be found in the database.");
    }
}
