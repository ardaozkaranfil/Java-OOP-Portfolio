public class LibraryMember{
    private String name;
    private int memberId;
    private int borrowedCount;
    private int borrowLimit;

    public LibraryMember(String name, int memberId){
        if(name==null||name.trim().isEmpty()){
            throw new InvalidMemberNameException();
        }
        this.name=name;
        this.memberId=memberId;
        borrowedCount=0;
        borrowLimit=5;
    }

    public String getName(){return name;}
    public void setName(String name){
        if(name==null||name.trim().isEmpty()){
            throw new InvalidMemberNameException();
        }
        this.name=name;
    }
    public int getMemberId(){return memberId;}
    public void setMemberId(int memberId){this.memberId=memberId;}
    public int getBorrowedCount(){return borrowedCount;}
    public void setBorrowedCount(int borrowedCount){this.borrowedCount=borrowedCount;}
    public int getBorrowLimit(){return borrowLimit;}
    public void setBorrowLimit(int borrowLimit){this.borrowLimit=borrowLimit;}
}
