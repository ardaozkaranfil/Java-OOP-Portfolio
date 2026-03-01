import java.util.HashMap;
import java.util.Map;

public class Sale<T extends Product>{
    private HashMap<T, Integer> items;

    public Sale(){
        items=new HashMap<>();
    }

    public HashMap<T, Integer> getItems(){return items;}
    public void setItems(HashMap<T, Integer> items){this.items=items;}

    public void addItem(T product, int quantity) throws IllegalArgumentException{
        if(product.getStock()<quantity){
            throw new IllegalArgumentException();
        }
        else{
            items.put(product,quantity);
            product.setStock(product.getStock()-quantity);
            System.out.println("Successfully added to cart.");
        }
    }

    public double getTotalAmount(){
        double totalAmount=0;
        for (Map.Entry<T, Integer> entry:items.entrySet()){
            totalAmount=totalAmount+(entry.getKey().getPrice()*entry.getValue());
        }
        return totalAmount;
    }
}
