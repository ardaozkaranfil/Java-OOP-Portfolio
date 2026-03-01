public abstract class Package{
    private String senderName;
    private String recipientName;
    private double weight;
    private boolean isDelivered;
    private String destinationCity;
    private String destinationCountry;

    public Package(){
        senderName="";
        recipientName="";
        weight=0;
        isDelivered=false;
        destinationCity="";
        destinationCountry="";
    }
    public Package(String senderName,String recipientName,double weight,String destinationCity,String destinationCountry){
        this.senderName=senderName;
        this.recipientName=recipientName;
        this.weight=weight;
        isDelivered=false;
        this.destinationCity=destinationCity;
        this.destinationCountry=destinationCountry;
    }

    public String getSenderName(){return senderName;}
    public void setSenderName(String senderName){this.senderName=senderName;}
    public String getRecipientName(){return recipientName;}
    public void setRecipientName(String recipientName){this.recipientName=recipientName;}
    public double getWeight(){return weight;}
    public void setWeight(double weight){this.weight=weight;}
    public boolean isDelivered(){return isDelivered;}
    public void setDelivered(boolean delivered){isDelivered=delivered;}
    public String getDestinationCity(){return destinationCity;}
    public void setDestinationCity(String destinationCity){this.destinationCity=destinationCity;}
    public String getDestinationCountry(){return destinationCountry;}
    public void setDestinationCountry(String destinationCountry){this.destinationCountry=destinationCountry;}

    public abstract double calculateShippingCost();
    public void markDelivered(){
        isDelivered=true;
    }
    public void printInfo(){
        System.out.println("---Package Info---");
        System.out.println("Sender: "+senderName+"\nRecipient Name: "+recipientName+"\nWeight: "+weight+"\nDelivery Status: "+isDelivered);
    }
}
