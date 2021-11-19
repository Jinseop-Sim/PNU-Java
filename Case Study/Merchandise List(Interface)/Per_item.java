public class Peri_item extends Merchandise implements Perishable{
	String name;
	String pitch;
	String expDate;
	
	public Peri_item(double price, String brand, String name, String pitch, String expDate) {
		super(price, brand); // Constructor to construct perishable merchandise.
		this.name = name;
		this.pitch = pitch;  // Merchandise's sales pitch.
		this.expDate = expDate;  // Merchandise's expiry date.
	}
	public String getName() { // Method to print out merchandise's name.
		return this.name;
	}
	@Override
	public String getExpiryDate() { // Overrided method in Perishable interface
		return this.expDate;
	}
	@Override
	public String getSalesPitch() { // Overrided method in Merchandise(Super Class).
		return this.pitch;
	}
}
