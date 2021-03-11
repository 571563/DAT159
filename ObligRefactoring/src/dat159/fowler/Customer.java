package dat159.fowler;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;


public class Customer {
    private String _name;
    private List<Rental> myRentals = new ArrayList<Rental>();

    public Customer(String name) {
        _name = name;
    }
    
    public void addRental(Rental rental) {
    	myRentals.add(rental);
    }

    public String getName() {
        return _name;
    }

    public String statement() {
        
        String name = getName();
		String result = header(name);
		
//        Enumeration rentals = _rentals.elements();
//
//        while (rentals.hasMoreElements()) {
//            Rental each = (Rental) rentals.nextElement();
            
		for(Rental each : myRentals){
            double thisAmount = each.amount();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" +
                    String.valueOf(thisAmount) + "\n";
        }
		
		double totalAmount = totalAmount(myRentals);
		

		int frequentRenterPoints = frequentRenterPoints(myRentals);
		
		
        //add footer lines
        result += footer(totalAmount, frequentRenterPoints);
		
        return result;
    }

	private double totalAmount(List<Rental> rentals) {
		double totalAmount = 0;
		for(Rental each : rentals){
            double thisAmount = each.amount();
            totalAmount += thisAmount;
        }
		return totalAmount;
	}

	private int frequentRenterPoints(List<Rental> rentals) {
		int frequentRenterPoints = 0;
		for(Rental each : rentals){
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
                    each.getDaysRented() > 1) frequentRenterPoints ++;
        }
		return frequentRenterPoints;
	}
    
	private String header(String name) {
		return "Rental Record for " + name + "\n";
	}

	private String footer(double totalAmount, int frequentRenterPoints) {
		String footer1 = "Amount owed is " + String.valueOf(totalAmount) + "\n";
        String footer2 = "You earned " + String.valueOf(frequentRenterPoints) +" frequent renter points";
        return footer1 + footer2;
	}

}
