public class Tester {

	public static void main(String[] args) {
		System.out.println("Name : Jinseop Sim");
		System.out.println("School Number : 201724500");
		System.out.println();
		
		Store daiso = new Store("DAISO"); // Make a new store.
		Merchandise snack1 = new Peri_item(1350, "Nong-Sim", "Shirimp-Gang", "It's delicious shrimp snack!", "02/13/2023"); // Make Perishable item.
		Merchandise ice1 = new Peri_item(600, "Lotte", "Ok Dong Ja", "It's freakin sweet Icecream!", "08/23/2024");
		Merchandise top1 = new Mer_item(2000, "O-kong", "Top Blade Draiger", "It's AWSOME Top for kids!"); // Make not perishable item.
		
		daiso.addMerchandiseItem(snack1); // Add to store's item list.
		daiso.addMerchandiseItem(ice1);
		daiso.addMerchandiseItem(top1);
		
		daiso.showInventory();
		System.out.println();
		daiso.showExpiryDates();
	}
}
