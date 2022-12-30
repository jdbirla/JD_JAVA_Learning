package designpattern.jd;

interface WebDriver {
	public void getElement();

	public void selectElement();
}

class ChromeDriver implements WebDriver {

	@Override
	public void getElement() {
		System.out.println("Get element from ChromeDriver");

	}

	@Override
	public void selectElement() {
		System.out.println("Select element from ChromeDriver");

	}

}

class IEDriver {

	public void findElement() {
		System.out.println("Find element from IEDriver");
	}

	public void clickElement() {
		System.out.println("Click element from IEDriver");
	}
}

class WebDriverAdapter implements WebDriver {
	IEDriver iedriver;

	public WebDriverAdapter(IEDriver iedriver) {
		this.iedriver = iedriver;
	}

	@Override
	public void getElement() {
		iedriver.findElement();
	}

	@Override
	public void selectElement() {
		iedriver.clickElement();
	}

}

public class AdapterDesignPattern {
	public static void main(String[] args) {

		ChromeDriver chrome = new ChromeDriver();
		chrome.getElement();
		chrome.selectElement();

		IEDriver e = new IEDriver();

		WebDriver wID = new WebDriverAdapter(e);
		wID.getElement();
		wID.selectElement();

	}
}
