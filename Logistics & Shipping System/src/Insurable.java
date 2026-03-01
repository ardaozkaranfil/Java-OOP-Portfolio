public interface Insurable{
    void insurePackage(double insuredValue);
    double getInsuredValue();
    boolean claimInsurance(String claimReason);
    default void logInsuranceClaim(String packageIdentifier,String reason){
        System.out.println("LOG: "+packageIdentifier+"\nReason: "+reason);
    }
}
