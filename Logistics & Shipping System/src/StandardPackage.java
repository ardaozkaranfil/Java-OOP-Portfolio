public class StandardPackage extends Package implements Trackable{
    private String shippingType;
    private String currentLocation;
    private String estimatedDeliveryTime;

    public StandardPackage(String senderName,String recipientName,double weight,String destinationCity,String destinationCountry,String currentLocation,String estimatedDeliveryTime){
        super(senderName,recipientName,weight,destinationCity,destinationCountry);
        shippingType="Ground";
        this.currentLocation=currentLocation;
        this.estimatedDeliveryTime=estimatedDeliveryTime;
    }
    public StandardPackage(){
        super();
        shippingType="Ground";
        currentLocation="";
        estimatedDeliveryTime="";
    }

    @Override
    public void updateLocation(String newLocation){
        currentLocation=newLocation;
    }
    @Override
    public String getTrackingInfo(){
        return currentLocation;
    }
    @Override
    public void setEstimatedDeliveryTime(String dateTime){
        estimatedDeliveryTime=dateTime;
    }
    @Override
    public String getEstimatedDeliveryTime(){
        return estimatedDeliveryTime;
    }
    @Override
    public double calculateShippingCost(){
        return getWeight()*2.0;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Shipping Type: "+shippingType+"\nCurrent Location: "+currentLocation+"\nEstimated Delivery Time: "+estimatedDeliveryTime);
    }
}
