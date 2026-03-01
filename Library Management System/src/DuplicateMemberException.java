public class DuplicateMemberException extends Exception{
    public DuplicateMemberException(String message){
        super(message);
    }
    public DuplicateMemberException(){
        super("The member attempting to be added already exists in the system.");
    }
}
