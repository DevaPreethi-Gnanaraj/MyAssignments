package week1.day2;

public class Browser {
	 public void launchBrowser()
	{
		System.out.println("Browser launched successfully");
	}
	public void loadUrl()
	{
		System.out.println("Application URL loaded successfully");
	}
	public static void main(String[] args) {
		Browser obj1=new Browser();
		obj1.launchBrowser();
		obj1.loadUrl();
	}

}
