import java.util.*;

public class Source {

  public static void findItinerary(Map<String, String> tickets) {
    // Write code here
    Map<String, String> reverse = new HashMap<String, String>(); //Creating another hashmap.
    for (Map.Entry<String, String> entry : tickets.entrySet()) { //Iterating through tickets hashmap,
      reverse.put(entry.getValue(), entry.getKey()); //and storing reverse order by putting value as key and key as value.
    }
    String origin = ""; //Creating string to store origin.
    for (Map.Entry<String, String> entry : tickets.entrySet()) { //Iterating through tickets hashmap again.
      if (!reverse.containsKey(entry.getKey())) { //If origin is not any other destination,
        origin = entry.getKey(); //we set origin as the starting point.
        break;
      }
    }
    if (origin == null) { //If there is no origin,
      System.out.println("Invalid Input"); //list is cyclic and origin can not be found.
      return;
    }
    String destination = tickets.get(origin); //Get destination for origin and store it in variable.
    while (destination != null) { //While loop to loop until there are no more destinations.
      System.out.println(origin + "->" + destination); //Printing this line of the Itinerary
      origin = destination; //Setting origin to destination, to find next ticket.
      destination = tickets.get(destination); //Updating destination from original tickets Hashmap.
    }
  }

  public static void main(String[] args) {
    Map<String, String> tickets = new HashMap<String, String>();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      tickets.put(sc.next(), sc.next());
    }
    findItinerary(tickets);
  }
}
