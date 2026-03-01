import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ShippingSystem shippingSystem = new ShippingSystem();

        StandardPackage std1 = new StandardPackage("Alice Smith", "Bob Johnson", 3.5, "New York", "USA", "Warehouse A", "2025-10-10");
        StandardPackage std2 = new StandardPackage("Charlie Brown", "Diana Prince", 1.2, "London", "UK", "Customs Check", "2025-10-15");

        ExpressPackage exp1 = new ExpressPackage("Elon Musk", "Jeff Bezos", 20.0, "Los Angeles", "USA", "Airborne", "2025-10-08", 1);
        ExpressPackage exp2 = new ExpressPackage("Marie Curie", "Nikola Tesla", 0.5, "Paris", "France", "Local Sorting", "2025-10-12", 2);

        FragilePackage frg1 = new FragilePackage("Lisa Ray", "Tom Hanks", 5.8, "Berlin", "Germany", "In Truck", "2025-10-11", true, true);

        shippingSystem.addPackage(std1);
        shippingSystem.addPackage(std2);
        shippingSystem.addPackage(exp1);
        shippingSystem.addPackage(exp2);
        shippingSystem.addPackage(frg1);

        std1.setEstimatedDeliveryTime("2025-10-10 14:00");
        std1.updateLocation("Departed from Warehouse A");
        System.out.println("STD1 Tracking Info: " + std1.getTrackingInfo());
        System.out.println("STD1 Estimated Delivery: " + std1.getEstimatedDeliveryTime());

        exp1.insurePackage(1500.0);
        System.out.print("EXP1 Initial Insured Value: $"+exp1.getInsuredValue());

        String claimReason = "Damaged during handling";
        if (exp1.claimInsurance(claimReason)) {
            System.out.println("EXP1 Insurance Claim successful for reason: " + claimReason);
            System.out.print("EXP1 Final Insured Payout: $"+exp1.getInsuredValue());
        }
        else {
            System.out.println("EXP1 Insurance Claim denied.");
        }

        Insurable insurableExp1 = exp1;
        System.out.print("EXP1 ");
        insurableExp1.logInsuranceClaim("EXP1-900", claimReason);

        String refundReason = "Damaged";
        if (frg1.requestRefund(refundReason)) {
            System.out.println("FRG1 Refund Approved for reason: " + refundReason);
            System.out.print("FRG1 Refund Amount: $"+frg1.getRefundAmount());
        }
        else {
            System.out.println("FRG1 Refund Denied.");
        }

        if (!frg1.requestRefund("Changed my mind")) {
            System.out.println("FRG1 Refund Denied for reason: Changed my mind");
        }

        frg1.logRefundRequest("FRG1-456");

        std1.markDelivered();
        exp2.markDelivered();
        System.out.println("\n* Marked Standard Package 1 and Express Package 2 as Delivered *");

        shippingSystem.printAllPackages();
    }
}
