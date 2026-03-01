import java.util.Random;
public class Mage extends Character{
    private int mana;
    private double criticalChance;

    public Mage(String name,double hitPoint,String gender){
        super(name,hitPoint,gender);
        mana=10;
        criticalChance=10;
    }
    public Mage(){
        super();
        mana=10;
        criticalChance=10;
    }

    private void drinkPotion(){
        mana+=10;
    }
    @Override
    public void regeneratePower() {
        super.regeneratePower();
        drinkPotion();
    }
    @Override
    public double calculateDamage() {
        Random random=new Random();
        boolean isCriticalHit=random.nextInt(100)<criticalChance;
        double damage=getHitPoint()*0.8;
        if(isCriticalHit) {
            damage*=2;
            System.out.println("Critical Hit!");
        }
        return damage;
    }
    @Override
    public void attack() {
        if(mana<=5) {
            System.out.println("Not enough mana. Drink potion…");
        }else{
            mana-=5;
            super.attack();
            System.out.println("Remaining Mana: "+mana);
        }
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Mana: "+mana+"\nNormal/Critical Damage: "+getHitPoint()*0.8+"/"+getHitPoint()*0.8*2);
    }
}