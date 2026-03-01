import java.util.HashMap;

public class InventoryManager{
    private HashMap<String, Product> inventory;

    public InventoryManager(){
        inventory=new HashMap<>();
    }

    public HashMap<String, Product> getInventory(){return inventory;}
    public void setInventory(HashMap<String, Product>inventory){this.inventory=inventory;}

    public void addProduct(Product product){
        inventory.put(product.getName(),product);
        System.out.println(product.getName()+" is successfully added.");
    }

    public Product getProduct(String name){
        return inventory.get(name);
    }

    public void printStock(){
        System.out.println("--Current Inventory Report--");
        for (Product product:inventory.values()){
            System.out.println(product);
        }
    }
}
