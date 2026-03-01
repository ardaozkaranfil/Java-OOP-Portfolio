public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String message){
        super(message);
    }
    public ItemNotFoundException(){
        super("The requested item could not be found in the database.");
    }
}
