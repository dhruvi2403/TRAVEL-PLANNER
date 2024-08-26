/*import java.util.*;

public class temp1 {
    private static List<TravelPackage> travelPackages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializePackages();

        while (true) {
            System.out.println("Welcome to Travel Management System");
            System.out.println("1. View Packages");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewPackages();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializePackages() {
        // Add the initialized parisPackage to travelPackages list
        TravelPackage parisPackage = createParisPackage();
        travelPackages.add(parisPackage);

        // Add more packages similarly...
    }

    private static TravelPackage createParisPackage() {
        TravelPackage parisPackage = new TravelPackage("Paris", "France", "2000 USD", "5 Days, 4 Nights", "Explore the beauty of Paris");

        Hotel parisHotel1 = new Hotel("Hotel A", "Address A");
        Hotel parisHotel2 = new Hotel("Hotel B", "Address B");
        parisPackage.setAvailableHotels(List.of(parisHotel1, parisHotel2));

        Itinerary parisDay1 = new Itinerary("Day 1", "Visit the Eiffel Tower");
        Itinerary parisDay2 = new Itinerary("Day 2", "Louvre Museum Tour");
        parisPackage.setItineraries(List.of(parisDay1, parisDay2));

        Photo parisPhoto1 = new Photo("path/to/paris1.jpg");
        Photo parisPhoto2 = new Photo("path/to/paris2.jpg");
        parisPackage.setPhotos(List.of(parisPhoto1, parisPhoto2));

        return parisPackage;
    }

    private static void viewPackages() {
        System.out.println("Available Travel Packages:");
        for (int i = 0; i < travelPackages.size(); i++) {
            TravelPackage travelPackage = travelPackages.get(i);
            System.out.println((i + 1) + ". " + travelPackage.getPlace() + " - " + travelPackage.getCityState());
        }

        System.out.print("Select a package to view details or 0 to go back: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= travelPackages.size()) {
            TravelPackage selectedPackage = travelPackages.get(choice - 1);
            viewPackageDetails(selectedPackage);
        }
    }

    private static void viewPackageDetails(TravelPackage travelPackage) {
        System.out.println("Package Details:");
        System.out.println("Place: " + travelPackage.getPlace());
        System.out.println("City/State: " + travelPackage.getCityState());
        System.out.println("Price: " + travelPackage.getPrice());
        System.out.println("Duration: " + travelPackage.getDaysNights());
        System.out.println("Description: " + travelPackage.getDescription());

        System.out.println("\nAvailable Hotels:");
        List<Hotel> hotels = travelPackage.getAvailableHotels();
        for (int i = 0; i < hotels.size(); i++) {
            Hotel hotel = hotels.get(i);
            System.out.println((i + 1) + ". " + hotel.getName() + " - " + hotel.getAddress());
        }

        System.out.print("Select a hotel for your stay or 0 to go back: ");
        int hotelChoice = Integer.parseInt(scanner.nextLine());

        if (hotelChoice > 0 && hotelChoice <= hotels.size()) {
            Hotel selectedHotel = hotels.get(hotelChoice - 1);
            bookPackage(travelPackage, selectedHotel);
        }
    }

    private static void bookPackage(TravelPackage travelPackage, Hotel selectedHotel) {
        System.out.println("\nBooking Confirmation:");
        System.out.println("Package: " + travelPackage.getPlace() + " - " + travelPackage.getCityState());
        System.out.println("Hotel: " + selectedHotel.getName() + " - " + selectedHotel.getAddress());
        System.out.println("Price: " + travelPackage.getPrice());
        System.out.println("Duration: " + travelPackage.getDaysNights());
        System.out.println("Description: " + travelPackage.getDescription());

        System.out.println("\nItinerary:");
        for (Itinerary itinerary : travelPackage.getItineraries()) {
            System.out.println(itinerary.getDay() + ": " + itinerary.getActivity());
        }

        System.out.println("\nPhotos:");
        for (Photo photo : travelPackage.getPhotos()) {
            System.out.println("Photo: " + photo.getPath());
        }

        System.out.println("\nYour package has been successfully booked! Enjoy your stay at " + selectedHotel.getName() + ".");
    }
}

// TravelPackage class
class TravelPackage {
    private String place;
    private String cityState;
    private String price;
    private String daysNights;
    private String description;
    private List<Itinerary> itineraries;
    private List<Photo> photos;
    private List<Hotel> availableHotels; // List of hotels for the destination

    public TravelPackage(String place, String cityState, String price, String daysNights, String description) {
        this.place = place;
        this.cityState = cityState;
        this.price = price;
        this.daysNights = daysNights;
        this.description = description;
    }

    // Getters and setters
    public String getPlace() { return place; }
    public String getCityState() { return cityState; }
    public String getPrice() { return price; }
    public String getDaysNights() { return daysNights; }
    public String getDescription() { return description; }
    public List<Itinerary> getItineraries() { return itineraries; }
    public List<Photo> getPhotos() { return photos; }
    public List<Hotel> getAvailableHotels() { return availableHotels; }
    public void setItineraries(List<Itinerary> itineraries) { this.itineraries = itineraries; }
    public void setPhotos(List<Photo> photos) { this.photos = photos; }
    public void setAvailableHotels(List<Hotel> availableHotels) { this.availableHotels = availableHotels; }
}

// Hotel class
class Hotel {
    private String name;
    private String address;

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and setters
    public String getName() { return name; }
    public String getAddress() { return address; }
}

// Itinerary class
class Itinerary {
    private String day;
    private String activity;

    public Itinerary(String day, String activity) {
        this.day = day;
        this.activity = activity;
    }

    // Getters and setters
    public String getDay() { return day; }
    public String getActivity() { return activity; }
}

// Photo class
class Photo {
    private String path;

    public Photo(String path) {
        this.path = path;
    }

    // Getters and setters
    public String getPath() { return path; }
}
*/

//package travel.management.system;

import java.util.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class temp1 {
    private static List<TravelPackage> travelPackages = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializePackages();

        while (true) {
            System.out.println("Welcome to Travel Management System");
            System.out.println("1. View Packages");
            System.out.println("2. Exit");

            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    viewPackages();
                    break;
                case 2:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializePackages() {
        // Add the initialized parisPackage to travelPackages list
        TravelPackage parisPackage = createParisPackage();
        travelPackages.add(parisPackage);

        // Add more packages similarly...
    }

    private static TravelPackage createParisPackage() {
        TravelPackage parisPackage = new TravelPackage("Paris", "France", "2000 USD", "5 Days, 4 Nights", "Explore the beauty of Paris");

        Hotel parisHotel1 = new Hotel("Hotel A", "Address A");
        Hotel parisHotel2 = new Hotel("Hotel B", "Address B");
        parisPackage.setAvailableHotels(List.of(parisHotel1, parisHotel2));

        Itinerary parisDay1 = new Itinerary("Day 1", "Visit the Eiffel Tower");
        Itinerary parisDay2 = new Itinerary("Day 2", "Louvre Museum Tour");
        parisPackage.setItineraries(List.of(parisDay1, parisDay2));

        // Photo parisPhoto1 = new Photo("E:\\COLLEGE\\SEMESTER-1\\SUBMISSIONS\\Java Projects\\ppts\\java_individual_ppt.pptx");
        // Photo parisPhoto2 = new Photo("E:\\COLLEGE\\SEMESTER-2\\signinlogo2-removebg-preview.png");
        Photo parisPhoto1 = new Photo("E:\\COLLEGE\\SEMESTER-2\\paris1.jpeg");
        Photo parisPhoto2 = new Photo("Downloads:\\paris2.jpeg");
        parisPackage.setPhotos(List.of(parisPhoto1, parisPhoto2));

        return parisPackage;
    }

    private static void viewPackages() {
        System.out.println("Available Travel Packages:");
        for (int i = 0; i < travelPackages.size(); i++) {
            TravelPackage travelPackage = travelPackages.get(i);
            System.out.println((i + 1) + ". " + travelPackage.getPlace() + " - " + travelPackage.getCityState());
        }

        System.out.print("Select a package to view details or 0 to go back: ");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice > 0 && choice <= travelPackages.size()) {
            TravelPackage selectedPackage = travelPackages.get(choice - 1);
            viewPackageDetails(selectedPackage);
        }
    }

    private static void viewPackageDetails(TravelPackage travelPackage) {
        System.out.println("Package Details:");
        System.out.println("Place: " + travelPackage.getPlace());
        System.out.println("City/State: " + travelPackage.getCityState());
        System.out.println("Price: " + travelPackage.getPrice());
        System.out.println("Duration: " + travelPackage.getDaysNights());
        System.out.println("Description: " + travelPackage.getDescription());

        System.out.println("\nAvailable Hotels:");
        List<Hotel> hotels = travelPackage.getAvailableHotels();
        for (int i = 0; i < hotels.size(); i++) {
            Hotel hotel = hotels.get(i);
            System.out.println((i + 1) + ". " + hotel.getName() + " - " + hotel.getAddress());
        }

        System.out.print("Select a hotel for your stay or 0 to go back: ");
        int hotelChoice = Integer.parseInt(scanner.nextLine());

        if (hotelChoice > 0 && hotelChoice <= hotels.size()) {
            Hotel selectedHotel = hotels.get(hotelChoice - 1);
            System.out.println("1. View Itinerary");
            System.out.println("2. View Photos");
            System.out.println("3. Book Package");
            System.out.print("Enter your choice: ");
            int detailChoice = Integer.parseInt(scanner.nextLine());

            switch (detailChoice) {
                case 1:
                    viewItinerary(travelPackage);
                    break;
                case 2:
                    viewPhotos(travelPackage);
                    break;
                case 3:
                    bookPackage(travelPackage, selectedHotel);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void viewItinerary(TravelPackage travelPackage) {
        System.out.println("\nItinerary:");
        for (Itinerary itinerary : travelPackage.getItineraries()) {
            System.out.println(itinerary.getDay() + ": " + itinerary.getActivity());
        }
    }

    private static void viewPhotos(TravelPackage travelPackage) {
        System.out.println("\nPhotos:");
        for (int i = 0; i < travelPackage.getPhotos().size(); i++) {
            Photo photo = travelPackage.getPhotos().get(i);
            System.out.println((i + 1) + ". Photo: " + photo.getPath());
        }

        System.out.print("Enter the number of the photo you want to view or 0 to go back: ");
        int photoChoice = Integer.parseInt(scanner.nextLine());

        if (photoChoice > 0 && photoChoice <= travelPackage.getPhotos().size()) {
            Photo selectedPhoto = travelPackage.getPhotos().get(photoChoice - 1);
            openPhoto(selectedPhoto.getPath());
        }
    }

    private static void openPhoto(String path) {
        try {
            File photoFile = new File(path);
            if (photoFile.exists()) {
                Desktop.getDesktop().open(photoFile);
            } else {
                System.out.println("Photo file does not exist.");
            }
        } catch (IOException e) {
            System.out.println("Error opening photo: " + e.getMessage());
        }
    }

    private static void bookPackage(TravelPackage travelPackage, Hotel selectedHotel) {
        System.out.println("\nBooking Confirmation:");
        System.out.println("Package: " + travelPackage.getPlace() + " - " + travelPackage.getCityState());
        System.out.println("Hotel: " + selectedHotel.getName() + " - " + selectedHotel.getAddress());
        System.out.println("Price: " + travelPackage.getPrice());
        System.out.println("Duration: " + travelPackage.getDaysNights());
        System.out.println("Description: " + travelPackage.getDescription());

        System.out.println("\nItinerary:");
        for (Itinerary itinerary : travelPackage.getItineraries()) {
            System.out.println(itinerary.getDay() + ": " + itinerary.getActivity());
        }

        System.out.println("\nPhotos:");
        for (Photo photo : travelPackage.getPhotos()) {
            System.out.println("Photo: " + photo.getPath());
        }

        System.out.println("\nYour package has been successfully booked! Enjoy your stay at " + selectedHotel.getName() + ".");
    }
}

// TravelPackage class
class TravelPackage {
    private String place;
    private String cityState;
    private String price;
    private String daysNights;
    private String description;
    private List<Itinerary> itineraries;
    private List<Photo> photos;
    private List<Hotel> availableHotels; // List of hotels for the destination

    public TravelPackage(String place, String cityState, String price, String daysNights, String description) {
        this.place = place;
        this.cityState = cityState;
        this.price = price;
        this.daysNights = daysNights;
        this.description = description;
    }

    // Getters and setters
    public String getPlace() { return place; }
    public String getCityState() { return cityState; }
    public String getPrice() { return price; }
    public String getDaysNights() { return daysNights; }
    public String getDescription() { return description; }
    public List<Itinerary> getItineraries() { return itineraries; }
    public List<Photo> getPhotos() { return photos; }
    public List<Hotel> getAvailableHotels() { return availableHotels; }
    public void setItineraries(List<Itinerary> itineraries) { this.itineraries = itineraries; }
    public void setPhotos(List<Photo> photos) { this.photos = photos; }
    public void setAvailableHotels(List<Hotel> availableHotels) { this.availableHotels = availableHotels; }
}

// Hotel class
class Hotel {
    private String name;
    private String address;

    public Hotel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and setters
    public String getName() { return name; }
    public String getAddress() { return address; }
}

// Itinerary class
class Itinerary {
    private String day;
    private String activity;

    public Itinerary(String day, String activity) {
        this.day = day;
        this.activity = activity;
    }

    // Getters and setters
    public String getDay() { return day; }
    public String getActivity() { return activity; }
}

// Photo class
class Photo {
    private String path;

    public Photo(String path) {
        this.path = path;
    }

    // Getters and setters
    public String getPath() { return path; }
}
//======================================================================================================
// class Solution {
//     public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//         List<TreeNode> result = new ArrayList<>();
//         if (root == null) return result;

//         Set<Integer> toDeleteSet = new HashSet<>();
//         for (int val : to_delete) {
//             toDeleteSet.add(val);
//         }

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.offer(root);

//         while (!queue.isEmpty()) {
//             TreeNode curNode = queue.poll();

//             if (curNode.left != null) {
//                 queue.offer(curNode.left);
//                 if (toDeleteSet.contains(curNode.left.val)) {
//                     curNode.left = null;
//                 }
//             }

//             if (curNode.right != null) {
//                 queue.offer(curNode.right);
//                 if (toDeleteSet.contains(curNode.right.val)) {
//                     curNode.right = null;
//                 }
//             }

//             if (toDeleteSet.contains(curNode.val)) {
//                 if (curNode.left != null) {
//                     result.add(curNode.left);
//                 }
//                 if (curNode.right != null) {
//                     result.add(curNode.right);
//                 }
//             } else if (result.isEmpty()) {
//                 result.add(curNode);
//             }
//         }
//         return result;
//     }
// }