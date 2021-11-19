public abstract class Merchandise {
	private double price;
	private String brand;
	
	public Merchandise(double price, String brand) {
		this.price = price;
		this.brand = brand;
	}
	public double getPrice() {
		return price;
	}
	public String getBrand() {
		return brand;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public abstract String getSalesPitch();
}
