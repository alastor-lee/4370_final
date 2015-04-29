/*
	Cart.java
	Bean class for AddToCart.java
*/
package control;
public class Cart{
	private String[] inven;
	private String feed = "";
	private int strLength;
	
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

	public void setFeed(String str) {
		feed = str;
	}

	public void addToFeed(String str) {
		feed += str;
	}

	public String getFeed(String str) {
		return feed;
	}
}