/*
	Logout.java
*/
package control;
public class Logout{

	private String logReturn = "";
	
	public void setLogReturn(String t) {
		this.logReturn = t;
	}
	public void addToLogReturn(String a) {
		this.logReturn += a;
	}
	public String getLogReturn() {
		return logReturn;
	}
}