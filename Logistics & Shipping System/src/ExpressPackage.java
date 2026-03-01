public class ExpressPackage extends Package implements Trackable,Insurable{
    private int priorityLevel;
    private double insuredValue;
    private String currentLocation;
    private String estimatedDeliveryTime;

    public ExpressPackage(String senderName,String recipientName,double weight,String destinationCity,String destinationCountry,String currentLocation,String estimatedDeliveryTime,int priorityLevel){
        super(senderName,recipientName,weight,destinationCity,destinationCountry);
        this.currentLocation=currentLocation;
        this.estimatedDeliveryTime=estimatedDeliveryTime;
        this.priorityLevel=priorityLevel;
        insuredValue=0;
    }
    public ExpressPackage(){
        super();
        currentLocation="";
        estimatedDeliveryTime="";
        insuredValue=0;
        priorityLevel=0;
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
    public double getInsuredValue(){
        return insuredValue;
    }
    @Override
    public double calculateShippingCost(){
        return (getWeight()*5.0)+10.0;
    }
    @Override
    public void insurePackage(double insuredValue){
        this.insuredValue=insuredValue;
    }
    @Override
    public boolean claimInsurance(String claimReason){
        if(claimReason.equalsIgnoreCase("lost")){
            insurePackage(calculateShippingCost());
            return true;
        }
        else if(claimReason.equalsIgnoreCase("damaged")){
            insuredValue=calculateShippingCost()*((double)3/4);
            insurePackage(insuredValue);
            return true;
        } else{
            return false;
        }
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Current Location: "+currentLocation+"\nEstimated Delivery Time: "+estimatedDeliveryTime+"\nPriority Level: "+priorityLevel+"\nInsured Value: "+insuredValue);
    }
}
