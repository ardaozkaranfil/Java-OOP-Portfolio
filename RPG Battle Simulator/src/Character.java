public class Character {
    private String name;
    private double hitPoint;
    private String gender;
    protected int level=0;
    protected int experience=0;

    public Character(String name,double hitPoint,String gender){
        this.name=name;
        this.hitPoint=hitPoint;
        this.gender=gender;
    }
    public Character(){
        gender="default";
        name="default";
        hitPoint=0.0;
    }
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public double getHitPoint(){return hitPoint;}
    public void setHitPoint(double hitPoint){hitPoint=this.hitPoint;}
    public String getGender(){return gender;}
    public void setGender(String gender){gender=this.gender;}
    public int getLevel(){return level;}

    public double calculateDamage(){
        return hitPoint;
    }
    public void attack(){
        System.out.println("Attacking...Damage is: "+calculateDamage());
        gainExperience(20);
    }
    public void regeneratePower(){
        System.out.println("Regenerating Power...");
    }
    public void gainExperience(int xp){
        experience+=20;
        if(experience>=100){
            levelUp();
        }
    }
    public void levelUp(){
        level++;
        experience-=100;
    }
    public void printInfo(){
        System.out.println("*PLAYER INFORMATION*");
        System.out.println("Name: "+getName()+"\nGender: "+getGender()+"\nLevel: "+level);
    }
}