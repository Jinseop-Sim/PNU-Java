public class Mer_item extends Merchandise{
	String name;
	String pitch;
	
	public Mer_item(double price, String brand, String name, String pitch) {
		super(price, brand); // Constructor to construct merchandise which is not perishable.
		this.name = name;
		this.pitch = pitch;  // Merchandise's sales pitch.
	}
	
	public String getName() { // Method to print out merchandise's name.
		return this.name;
	}
	@Override
	public String getSalesPitch() { // Overrided method in Merchandise (Super Class).
		return this.pitch;
	}
}
