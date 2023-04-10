package junit.steps;

import io.cucumber.java8.En;
import junit.driver.DriverManager;
import junit.pages.EpamContactsPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GetAddressSteps implements En {
    private EpamContactsPage contactsPage = new EpamContactsPage();
    private String contactsString;
    private String addressString;
    public GetAddressSteps() {
        Given("^The epam contacts page is open$", () -> {
            contactsPage.openContactsPage();
        });
        When("^getting text from \"([^\"]*)\" section$", (String arg0) -> {
            contactsString = contactsPage.contactsSection.getText();
        });
        And("^get the address from the string$", () -> {
            addressString = contactsPage.getAddress(contactsString);
        });
        Then("^the address is successfully extracted$", () -> {
            Assert.assertTrue(addressString.equals("41 University Drive • Suite 202,\n" +
                    "Newtown, PA 18940 • USA"));
            DriverManager.quitDriver();
        });


    }

}
