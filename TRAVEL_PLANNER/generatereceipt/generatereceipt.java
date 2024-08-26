package generatereceipt;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import Travel.TravelPackage;
import hotel.*;

public class generatereceipt {

    public void genreceipt(String customerName, int numberOfPeople, TravelPackage travelPackage, String paymentMethod, int totalAmount) {
        
        String filePath11 = "Receipt_" + customerName + ".txt";

        try (FileWriter wr = new FileWriter(filePath11, true)) { 
            wr.write("Receipt\n");
            wr.write("-------------------------------------------------\n");
            wr.write("Customer Name: " + customerName + "\n");
            wr.write("Number of People: " + numberOfPeople + "\n");
            wr.write("Travel Package: " + travelPackage.getDestination() + "\n");
            wr.write("Total Amount: ₹" + totalAmount + "\n");
            wr.write("Payment Method: " + paymentMethod + "\n");
            wr.write("-------------------------------------------------\n");
            wr.write("\n");

            System.out.println("Receipt generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error generating receipt.");
        }
    }
}
