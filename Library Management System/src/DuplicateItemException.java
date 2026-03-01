public class DuplicateItemException extends Exception{
    public DuplicateItemException(String message){
        super(message);
    }
    public DuplicateItemException(){
        super("The item attempting to be added already exists in the system.");
    }
}
