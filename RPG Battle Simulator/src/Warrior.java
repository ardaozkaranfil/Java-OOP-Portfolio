public class Warrior extends Character{
    private int energy;
    private int defense;

    public Warrior(String name,double hitPoint,String gender){
        super(name,hitPoint,gender);
        energy=20;
        defense=5;
    }
    public Warrior(){
        super();
        energy=20;
        defense=5;
    }

    private void rest(){
        energy+=20;
        System.out.println("Energy:"+energy);
    }
    @Override
    public void regeneratePower() {
        super.regeneratePower();
        rest();
    }
    @Override
    public double calculateDamage() {
        return getHitPoint()*1.2;
    }
    @Override
    public void attack() {
        if(energy<=10) {
            System.out.println("Not enough energy. Get rest…");
        }else{
            energy-=10;
            super.attack();
            System.out.println("Remaining Energy: "+energy);
        }
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Energy: "+energy+"\nDamage: "+calculateDamage()+"\nDefense: "+defense);
    }
}