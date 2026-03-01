public interface Trackable{
    void updateLocation(String newLocation);
    String getTrackingInfo();
    void setEstimatedDeliveryTime(String dateTime);
    String getEstimatedDeliveryTime();
}
