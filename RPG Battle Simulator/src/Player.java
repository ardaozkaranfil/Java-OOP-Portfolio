import java.util.*;

public class Player {
    private String name;
    private String password;
    private ArrayList<Character> characters;
    public Player(String name,String password,ArrayList<Character> characters){
        this.name=name;
        this.password=password;
        this.characters=characters;
    }
    public Player(){
        name=" ";
        password="";
        characters=new ArrayList<>();
    }
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    public ArrayList<Character> getCharacters(){return characters;}
    public void setCharacters(ArrayList<Character> characters){this.characters=characters;}

    public void printPlayerInfo(){
        System.out.println("===PLAYER INFO===");
        System.out.println("Name: "+getName()+"\nPassword: "+getPassword()+"\nCharacter Info's:");
        for(Character c:characters){
            c.printInfo();
        }
    }
}

class Achievement{
    private List<String> unlockedAchievements=new ArrayList<String>();
    public void addAchievement(String achievement){
        unlockedAchievements.add(achievement);
    }
}