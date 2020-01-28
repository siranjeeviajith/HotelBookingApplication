
public class Hotel {
	final String hotelName;
	final int rating;
	final int daysForOffer;
	final float offerPercent;
	final double costPerDay;
//	public Hotel() {
//		
//	}
	public Hotel(String hotelName,int rating,double costPerDay, int daysForOffer,float offerPercent) {
		this.hotelName=hotelName;
		this.rating=rating;
		this.daysForOffer=daysForOffer;
		this.offerPercent=offerPercent;
		this.costPerDay=costPerDay;
	}
	public double calculateCost(int days) {
		double cost;
		cost=costPerDay*days;
		if(days>daysForOffer) {
			cost=cost- cost*(offerPercent/100);
		}
		
		return cost;
	}
	

}
