import java.util.*;

public class SalesManager <T extends Product>{
    private List<Sale<T>> sales;

    public SalesManager(){
        sales=new ArrayList<>();
    }

    public List<Sale<T>> getSales(){return sales;}
    public void setSales(List<Sale<T>> sales){this.sales=sales;}

    public void recordSale(Sale<T> sale){
        if(!sales.contains(sale)) {
            sales.add(sale);
            System.out.println("Sale added successfully.");
        }
        else{
            System.out.println("This sale already exist.");
        }
    }

    public double getDailyTotal(){
        double totalAmount=0;
        for(Sale<T> sale:sales){
           totalAmount+=sale.getTotalAmount();
        }
        return totalAmount;
    }

    public void printSummary(){
        System.out.println("---Sale Summary---\n Number of Sales: "+sales.size()+"\n Total Amount: $"+getDailyTotal());
    }
}
