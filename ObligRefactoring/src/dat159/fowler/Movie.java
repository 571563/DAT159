package dat159.fowler;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String _title;
    private int _priceCode;

    public Movie(String title, int priceCode) {
        _title = title;
        _priceCode = priceCode;
    }

    public int getPriceCode() {
        return _priceCode;
    }

    public void setPriceCode(int _priceCode) {
        this._priceCode = _priceCode;
    }

    public String getTitle() {
        return _title;
    }

	double amount(int daysRented) {
		double thisAmount = 0;
		switch (getPriceCode()) {
		    case REGULAR:
		        thisAmount += 2;
		        if (daysRented > 2)
		            thisAmount += (daysRented - 2) * 1.5;
		        break;
		    case NEW_RELEASE:
		        thisAmount += daysRented * 3;
		        break;
		    case CHILDRENS:
		        thisAmount += 1.5;
		        if (daysRented > 3)
		            thisAmount += (daysRented - 3) * 1.5;
		        break;
		}
		return thisAmount;
	}
}
