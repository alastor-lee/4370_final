/*
	Inventory.java
	Bean class for InventoryServlet.java
*/
package control;
public class Inventory{
	private String[] inven;
	
	public void setInven(int length) {
		inven = new String[length];
	}

	public void addToInven(String str, int index) {
		inven[index] = str;
	}

	public String getInven(int index) {
		return inven[index];
	}

	public int getInvenLength() {
		return inven.length;
	}
}