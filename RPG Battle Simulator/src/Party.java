import java.util.ArrayList;

public class Party {
    private String partyName;
    private ArrayList<Character> members;
    private int reputation;

    public Party(String partyName,ArrayList<Character> members){
        this.partyName=partyName;
        this.members=members;
        int sum=0;
        for(Character c:members){
            sum+=c.getLevel();
        }
        reputation=sum;
    }
    public Party(){
        partyName="default";
        members=new ArrayList<>();
        reputation=0;
    }
    public String getPartyName(){return partyName;}
    public void setPartyName(String partyName){this.partyName=partyName;}
    public ArrayList<Character> getMembers(){return members;}
    public void setMembers(ArrayList<Character> members){this.members=members;}
    public int getReputation(){return reputation;}
    public void setReputation(int reputation){this.reputation=reputation;}

    public void addMember(Character character){
        if(!members.contains(character)){
            if(members.size()<10) {
                members.add(character);
            }else{
                System.out.println("Party is full!");
            }
        }else{
            System.out.println("This character already exist!");
        }
    }
    public void removeMember(Character character){
        if(members.contains(character)){
            members.remove(character);
        }else{
            System.out.println("This character doesn't exist!");
        }
    }
    public void calculateReputation(){
        int sum=0;
        for(Character c:members){
            sum+=c.getLevel();
        }
        reputation=sum;
    }
    public void printPartyInfo(){
        System.out.println("--Party Info--");
        System.out.println("Party Members: ");
        for(Character c:members){
            System.out.print(c.getName()+", ");
        }
        calculateReputation();
        System.out.println("Party Reputation: "+reputation);
    }
}