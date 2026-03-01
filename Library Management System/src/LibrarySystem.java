import java.util.ArrayList;

public class LibrarySystem{
    private ArrayList<LibraryItem> items;
    private ArrayList<LibraryMember> members;

    public LibrarySystem(){
        items=new ArrayList<>();
        members=new ArrayList<>();
    }
    public LibrarySystem(ArrayList<LibraryItem> items,ArrayList<LibraryMember> members){
        this.items=items;
        this.members=members;
    }

    public void registerMember(LibraryMember member) throws DuplicateMemberException{
        if(members.contains(member)){
            throw new DuplicateMemberException();
        }
        else{
            members.add(member);
        }
    }
    public void addNewItem(LibraryItem item) throws DuplicateItemException{
        if(items.contains(item)){
            throw new DuplicateItemException();
        }
        else{
            items.add(item);
        }
    }

    public LibraryMember findMemberById(int id){
        for(LibraryMember member:members){
            if(member.getMemberId()==id){
                return member;
            }
        }
        return null;
    }
    public LibraryItem findItemById(int id){
        for(LibraryItem item:items){
            if(item.getItemId()==id){
                return item;
            }
        }
        return null;
    }

    public void borrowItem(int memberId,int itemId)throws UserNotFoundException,ItemNotFoundException,OverLimitException{
        LibraryMember member=findMemberById(memberId);
        if(member==null){
            throw new UserNotFoundException();
        }
        LibraryItem item=findItemById(itemId);
        if(item==null){
            throw new ItemNotFoundException();
        }
        if(member.getBorrowLimit()<=member.getBorrowedCount()){
            throw new OverLimitException();
        }
        else{
            item.setBorrowed(true);
        }
    }
    public void returnItem(int memberId,int itemId)throws UserNotFoundException,ItemNotFoundException{
        LibraryMember member=findMemberById(memberId);
        if(member==null){
            throw new UserNotFoundException();
        }
        LibraryItem item=findItemById(itemId);
        if(item==null){
            throw new ItemNotFoundException();
        }
        member.setBorrowedCount(member.getBorrowedCount()-1);
        item.setBorrowed(false);
    }

    public void printAllMembers(){
        System.out.println("--Member Informations--");
        for(LibraryMember member:members){
            System.out.println("Name: "+member.getName()+"\nID: "+member.getMemberId()+"\nBorrowed Count: "+member.getBorrowedCount()+"\nBorrow Limit: "+member.getBorrowLimit());
        }
    }
    public void printAllItems(){
        System.out.println("==Item Informations==");
        for(LibraryItem item:items){
            System.out.println("Title: "+item.getTitle()+"\nID: "+item.getItemId()+"\n Is Borrowed: "+item.isBorrowed());
        }
    }
}
