import java.util.ArrayList;

public class Store{
	private String name;
	private ArrayList<Merchandise> inventory;
	private ArrayList<Perishable> peri_inventory;
	
	public Store(String name) { // Store's Constructor to construct New store.
		this.name = name;
		this.inventory = new ArrayList<>();
		this.peri_inventory = new ArrayList<>();
	}
	public void addMerchandiseItem(Merchandise m) { // Method to add Item in Store.
		inventory.add(m);
		if(m instanceof Perishable) { // If it's instance of Perishable, it must have expiry dates.
			Perishable p = (Perishable) m;
			peri_inventory.add(p);
		}
	}
	public void showInventory() { // Method to show list of all merchandise.
		System.out.printf("%43s%n", "* " + this.name + "'s all Merchandise *");
		System.out.println("=================================================================");
		for(int i = 0; i<inventory.size(); i++) {
			if(inventory.get(i) instanceof Peri_item) { // Use instanceof operator because
				System.out.printf("%18s",((Peri_item)inventory.get(i)).getName()); // if item is instance of Mer_item,
																				   // it cannot cast to Peri_item and cannot reference to getName().
				System.out.println(" : " + inventory.get(i).getSalesPitch() + " made by " + inventory.get(i).getBrand());
			}
			else {
				System.out.printf("%18s",((Mer_item)inventory.get(i)).getName()); // So I distinguish it when item is Peri or Mer.
				System.out.println(" : " + inventory.get(i).getSalesPitch() + " made by " + inventory.get(i).getBrand());
				// getSalesPitch() method is overrided method in Peri_item and Mer_item.
			}
		}
	}
	public void showExpiryDates() { // Method to show list of perishable merchandise with expiry dates.
		System.out.printf("%48s%n", "* " + this.name + "'s Perishable Merchandise *");
		System.out.println("=================================================================");
		for(int i = 0; i<peri_inventory.size(); i++) {
			System.out.printf("%27s",((Peri_item)inventory.get(i)).getName());
			System.out.println(" : Until " + peri_inventory.get(i).getExpiryDate());
			// getExpiryDate() method is overrided method in Peri_item and Mer_item.
		}
	}
}
