package Travel;
import java.util.*;
import hotel.*;


public class TravelPackage {
    public String destination;
    public String state;
    public String price;
    public String duration;
    public String description;
    public List<Hotel> hotels;

    public TravelPackage(String destination, String state, String price, String duration, String description,
            List<Hotel> list) {
        this.destination = destination;
        this.state = state;
        this.price = price;
        this.duration = duration;
        this.description = description;
        this.hotels = list;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public String getDestination() {
        return destination;
    }
    public String getPrice(){
        return price;
    }
    @Override
    public String toString() {
        return "Destination: " + destination + "\n" +
                "State: " + state + "\n" +
                "Price: " + price + "\n" +
                "Duration: " + duration + "\n" +
                "Description: " + description + "\n";
       
    }
}

