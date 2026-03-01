public class FragilePackage extends Package implements Trackable,Insurable,Refundable{
    private boolean requiresReinforcedBox;
    private boolean requiresTemperatureControl;
    private double refundAmount;
    private double insuredValue;
    private String currentLocation;
    private String estimatedDeliveryTime;

    public FragilePackage(String senderName,String recipientName,double weight,String destinationCity,String destinationCountry,String currentLocation,String estimatedDeliveryTime,boolean requiresTemperatureControl,boolean requiresReinforcedBox){
        super(senderName,recipientName,weight,destinationCity,destinationCountry);
        this.currentLocation=currentLocation;
        this.estimatedDeliveryTime=estimatedDeliveryTime;
        this.requiresTemperatureControl=requiresTemperatureControl;
        this.requiresReinforcedBox=requiresReinforcedBox;
        insuredValue=0;
    }
    public FragilePackage(){
        super();
        currentLocation="";
        estimatedDeliveryTime="";
        insuredValue=0;
        requiresTemperatureControl=false;
        requiresReinforcedBox=false;
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
        return (getWeight()*2.0)+8.0;
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
    public boolean requestRefund(String reason) {
        if(reason.equalsIgnoreCase("damaged")){
            refundAmount=calculateShippingCost();
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public double getRefundAmount() {
        return refundAmount;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Current Location: "+currentLocation
                +"\nEstimated Delivery Time: "+estimatedDeliveryTime
                +"\nInsured Value: "+insuredValue
                +"\nRequires Reinforced Box: " +requiresReinforcedBox
                +"\nRequires Temperature Control: " +requiresTemperatureControl
                +"\nRefund Amount: "+refundAmount);
    }
}
