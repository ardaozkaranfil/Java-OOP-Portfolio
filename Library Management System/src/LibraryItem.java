public class LibraryItem{
    private String title;
    private int itemId;
    private boolean isBorrowed;

    public LibraryItem(String title,int itemId){
        if(title==null||title.trim().isEmpty()){
            throw new InvalidItemTitleException();
        }
        this.title=title;
        this.itemId=itemId;
        isBorrowed=false;
    }

    public String getTitle(){return title;}
    public void setTitle(String title){
        if(title==null||title.trim().isEmpty()){
            throw new InvalidItemTitleException();
        }
        this.title=title;
    }
    public int getItemId(){return itemId;}
    public void setItemId(int itemId){this.itemId=itemId;}
    public boolean isBorrowed(){return isBorrowed;}
    public void setBorrowed(boolean borrowed){isBorrowed=borrowed;}
}