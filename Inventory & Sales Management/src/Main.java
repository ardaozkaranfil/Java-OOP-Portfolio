public class Main{
    public static void main(String[] args){
        InventoryManager inventoryManager=new InventoryManager();

        Product apple=new Product("Apple",1.5,50);
        Product banana=new Product("Banana",0.75,100);
        Product orange=new Product("Orange",1.25,30);

        inventoryManager.addProduct(apple);
        inventoryManager.addProduct(banana);
        inventoryManager.addProduct(orange);

        System.out.println("---INITIAL INVENTORY REPORT---");
        inventoryManager.printStock();
        System.out.println("-------------------------------------\n");

        SalesManager<Product> salesManager=new SalesManager<>();

        System.out.println("---INITIATING SALE 1---");
        Sale<Product> sale1=new Sale<>();
        try{
            Product appleToSell=inventoryManager.getProduct("Apple");
            Product bananaToSell=inventoryManager.getProduct("Banana");

            sale1.addItem(appleToSell,5);
            sale1.addItem(bananaToSell,10);

            System.out.println("Sale 1 Total Amount: $"+sale1.getTotalAmount());

            salesManager.recordSale(sale1);

        }
        catch(IllegalArgumentException e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("-------------------------------------\n");

        System.out.println("---INITIATING SALE 2 (STOCK ERROR ATTEMPT)---");
        Sale<Product> sale2=new Sale<>();
        try{
            Product orangeToSell=inventoryManager.getProduct("Orange");
            Product appleToSellAgain=inventoryManager.getProduct("Apple");

            sale2.addItem(orangeToSell,20);
            sale2.addItem(appleToSellAgain,50);

        }
        catch(IllegalArgumentException e){
            System.out.println("Sale Error: Not enough stock for the requested item!");
        }
        System.out.println("Sale 2 Total Amount: $" + sale2.getTotalAmount());

        salesManager.recordSale(sale2);
        System.out.println("-------------------------------------\n");


        System.out.println("---CURRENT INVENTORY REPORT (POST-SALES)---");
        inventoryManager.printStock();
        System.out.println("-------------------------------------\n");

        System.out.println("---DAILY SALES SUMMARY---");
        salesManager.printSummary();
        System.out.println("-------------------------------------\n");
    }
}