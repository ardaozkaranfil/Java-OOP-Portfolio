import java.util.ArrayList;

public class ShippingSystem{
    private ArrayList<Package> packages;

    public ShippingSystem(ArrayList<Package>packages){
        this.packages=packages;
    }
    public ShippingSystem(){
        packages=new ArrayList<>();
    }

    public void addPackage(Package newPackage){
        if(!packages.contains(newPackage)){
            packages.add(newPackage);
        }
        else{
            System.out.println("This package already exists.");
        }
    }
    public void removePackage(Package oldPackage){
        if(packages.contains(oldPackage)){
            packages.remove(oldPackage);
        }
        else{
            System.out.println("There is no named "+oldPackage+" Package");
        }
    }
    public void printAllPackages(){
        for(Package p:packages){
            p.printInfo();
        }
    }
}
