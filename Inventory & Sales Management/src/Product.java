public class Product{
    private String name;
    private double price;
    private int stock;

    public Product(String name,double price,int stock){
        this.name=name;
        this.price=price;
        this.stock=stock;
    }

    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public double getPrice(){return price;}
    public void setPrice(double price){this.price=price;}
    public int getStock(){return stock;}
    public void setStock(int stock){this.stock=stock;}

    public void reduceStock(int quantity){
        if(stock>=quantity) {
            stock-=quantity;
            System.out.println("Stock reduced by "+quantity+". New Stock: "+stock);
        }
        else{
            System.out.println("Warning: Not enough stock.");
        }
    }

    public void increaseStock(int quantity){
        if(quantity<1){
            System.out.println("Warning: Stock can't increase if quantity lower than 1.");
        }
        else{
            stock+=quantity;
            System.out.println("Stock increased by "+quantity+". New Stock: "+stock);
        }
    }

    @Override
    public String toString(){
        return "\n-Product Info- \nName: "+name+"\nStock: "+stock+"\nPrice: $"+price;
    }
}
