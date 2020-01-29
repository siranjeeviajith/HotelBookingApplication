import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Testcases:
No of TestCases
Enter hotel 1 or 3 or 5 rating you want to book
Enter Days you want to stay:
Enter the money you can spent:
6
1
6
220
1
4
120
3
2
150
3
5
250
5
18
600
1
23
700

output:
Hotel Booked for 6 days in 1 star hotel Fortune for the cost of 219.82
Sorry! you dont have sufficient amount to book any hotel
Hotel Booked for 2 days in 3 star hotel RainTree for the cost of 116.00
Hotel Booked for 5 days in 3 star hotel Raddisson for the cost of 246.00
Sorry! you dont have sufficient amount to book any hotel
Sorry! you dont have sufficient amount to book any hotel
*/
public class HotelBookApplication {
	public static String bookHotel(Map<Integer,List<Hotel>> hotelDetails,int rating,int days,double money) {
		double cost;
		Hotel hoteltoBook;
		List<Hotel>listOfHotels=hotelDetails.getOrDefault(rating,new ArrayList<>());
		Map<Double,Hotel> costPerHotel=new TreeMap<>();//to get minimum cost of hotel
		if(listOfHotels.isEmpty()) {
			return "Sorry! there is no hotel for your rating";
		}
		for(Hotel hotel: listOfHotels) {
			cost=hotel.calculateCost(days);
			costPerHotel.put(cost, hotel);
		}
		List<Double> listOfCost=new ArrayList<>(costPerHotel.keySet());
		cost=listOfCost.get(0);
		//System.out.println(listOfCost); //to print list of cost of hotel as requested
		if(cost<= money) {
			hoteltoBook = costPerHotel.get(cost);
			return String.format("Hotel Booked for %d days in %d star hotel %s for the cost of %.2f",days,rating,hoteltoBook.hotelName,cost);
		}
		return "Sorry! you dont have sufficient amount to book any hotel";
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		Map<Integer,List<Hotel>> hotelDetails=new HashMap<>();
		
		/* Hard coding the hotel details */ /*a method can be added*/
		String hotelName1="The Park";int hotelRating1=5;double costPerDay1=90d;int daysForOffer1=2;float offerPercent1=20f;
		Hotel hotel1=new Hotel(hotelName1, hotelRating1,costPerDay1,daysForOffer1,offerPercent1);  // for hotel1
		List<Hotel> listOfHotels=new ArrayList<>();
		listOfHotels.add(hotel1);
		hotelDetails.put(hotelRating1,listOfHotels);
		
		String hotelName2="Hotel Hyaat";int hotelRating2=5;double costPerDay2=82d;int daysForOffer2=3;float offerPercent2=12f;
		Hotel hotel2=new Hotel(hotelName2,hotelRating2,costPerDay2,daysForOffer2,offerPercent2); // for hotel2
		listOfHotels=hotelDetails.getOrDefault(hotelRating2,new ArrayList<>());
		listOfHotels.add(hotel2);
		hotelDetails.put(hotelRating2,listOfHotels);
		
		
		String hotelName3="Raddisson";int hotelRating3=3;double costPerDay3=60d;int daysForOffer3=3;float offerPercent3=18f;
		Hotel hotel3=new Hotel(hotelName3,hotelRating3,costPerDay3,daysForOffer3,offerPercent3); // hotel3
		listOfHotels=hotelDetails.getOrDefault(hotelRating3,new ArrayList<>());
		listOfHotels.add(hotel3);
		hotelDetails.put(hotelRating3,listOfHotels);
		
		String hotelName4="RainTree";int hotelRating4=3;double costPerDay4=58d;int daysForOffer4=2;float offerPercent4=15f;
		Hotel hotel4=new Hotel(hotelName4, hotelRating4,costPerDay4,daysForOffer4,offerPercent4); //hotel4
		listOfHotels=hotelDetails.getOrDefault(hotelRating4,new ArrayList<>());
		listOfHotels.add(hotel4);
		hotelDetails.put(hotelRating4,listOfHotels);
		
		String hotelName5="Accord";int hotelRating5= 1;double costPerDay5=41.55d;int daysForOffer5=3;float offerPercent5=11.8f;
		Hotel hotel5=new Hotel(hotelName5,hotelRating5,costPerDay5,daysForOffer5 ,offerPercent5);// hotel5
		listOfHotels=hotelDetails.getOrDefault(hotelRating5,new ArrayList<>());
		listOfHotels.add(hotel5);
		hotelDetails.put(hotelRating5,listOfHotels);
		
		String hotelName6="Fortune";int hotelRating6=1;double costPerDay6=43d;int daysForOffer6=4;float offerPercent6=14.8f;
		Hotel hotel6=new Hotel(hotelName6, hotelRating6,costPerDay6,daysForOffer6,offerPercent6);// hotel6
		listOfHotels=hotelDetails.getOrDefault(hotelRating6,new ArrayList<>());
		listOfHotels.add(hotel6);
		hotelDetails.put(hotelRating6,listOfHotels);
		
		/* Getting Input from User */
		System.out.println("Enter no of testcases you want to check:");
		Pattern pattern=Pattern.compile("[135]");
		int numberOfTestCases=Integer.parseInt(scan.nextLine());
		for(int count=0;count<numberOfTestCases;count++) {
			try {
			System.out.println("Enter hotel 1 or 3 or 5 rating you want to book");
			String star=scan.nextLine();
			Matcher match=pattern.matcher(star);
			if(!match.matches()) { throw new Exception("invalid rating hotel not available");}
			int rating=Integer.parseInt(star);
			System.out.println("Enter Days 1 to 31 you want to stay:");
			int days=Integer.parseInt(scan.nextLine());
			if(!(days >=1 && days<=31)) {throw new Exception("invalid days choose 1 to 31");}
			System.out.println("Enter the money you can spent:");
			double money=Double.parseDouble(scan.nextLine());
			System.out.println(bookHotel(hotelDetails,rating,days,money));
			}
			catch(Exception e) {
				System.out.println(e +" try again\n");
				count--;
				
				
			}
		}
		
		
		
	}

}
