package org.step;

import org.base.PomBase;
import org.manager.pageManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdactpomStep extends PomBase {
	pageManager pm;

	@Given("user in adactin home page")
	public void user_in_adactin_home_page() {

	}

	@When("user enter {string} and {string}")
	public void user_enter_and(String s1, String s2) {
		pm = new pageManager();
		fill(pm.getLoginPom().getName(), s1);
		fill(pm.getLoginPom().getPwd(), s2);
		click(pm.getLoginPom().getBtn());

	}

	@When("user fill  the {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_fill_the(String r1, String r2, String r3, String r4, String r5, String r6, String r7, String r8) {
		fill(pm.getSearchPom().getLocation(), r1);
		fill(pm.getSearchPom().getHotel(), r2);
		fill(pm.getSearchPom().getRoomtype(), r3);
		fill(pm.getSearchPom().getNumberofroom(), r4);
		fill(pm.getSearchPom().getCheckin(), r5);
		fill(pm.getSearchPom().getCheckout(), r6);
		fill(pm.getSearchPom().getAdult(), r7);
		fill(pm.getSearchPom().getChild(), r8);
		click(pm.getSearchPom().getSubmit());
		click(pm.getSearchPom().getRadio());
		click(pm.getSearchPom().getCnte());

	}

	@When("user enter the {string},{string},{string},{string},{string},{string},{string},{string}")
	public void user_enter_the(String S1, String S2, String S3, String S4, String S5, String S6, String S7, String S8)
			throws InterruptedException {
		fill(pm.getDetailspom().getFname(), S1);
		fill(pm.getDetailspom().getLname(), S2);
		fill(pm.getDetailspom().getAdd(), S3);
		fill(pm.getDetailspom().getCrdnum(), S4);
		fill(pm.getDetailspom().getCrdtype(), S5);
		fill(pm.getDetailspom().getMon(), S6);
		fill(pm.getDetailspom().getYear(), S7);
		fill(pm.getDetailspom().getCvv(), S8);
		click(pm.getDetailspom().getBooknow());

		Thread.sleep(5000);
		Att(pm.getDetailspom().getOrderno());
		String orderid = Att(pm.getDetailspom().getOrderno());

		click(pm.getDetailspom().getBookitin());

		String xpath = "//input[@value='" + orderid + "']/parent::td/preceding-sibling::td";
		WebElement data = driver.findElement(By.xpath(xpath));
		click(data);

		click(pm.getCancelPom().getCancel());
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	@Then("user get the order number")
	public void user_get_the_order_number() throws InterruptedException {

	}

}
