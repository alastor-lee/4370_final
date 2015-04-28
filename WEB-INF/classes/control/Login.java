/*
	Login.java
*/
package control;
public class Login{
	private String logReturn = "";
	private int foo = 9001;
	
	public void setLogReturn(String t) {
		this.logReturn = t;
	}
	public void addToLogReturn(String a) {
		this.logReturn += a;
	}
	public String getLogReturn() {
		return logReturn;
	}
	public void setFoo(int n) {
		foo = n;
	}
	public int getFoo() {
		return foo;
	}
}
