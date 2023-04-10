package junit.pages;

import junit.driver.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamContactsPage extends BasePage{
    private static final String CONTACTS_URL = "https://www.epam.com/about/who-we-are/contact";
    private static final String CONTACT_US_SECTION = "div.colctrl__col.colctrl__col--width-53.colctrl__col--top-0.colctrl__col--right-0.colctrl__col--bottom-0.colctrl__col--left-0";
    @FindBy(css = CONTACT_US_SECTION)
    public WebElement contactsSection;


    public void openContactsPage() {
        DriverManager.driver.get(CONTACTS_URL);
    }

    public static String getAddress(String text){
        Pattern searchPattern = Pattern.compile("(?<=S\\n)[\\w\\W]+(?=\nP)");
        Matcher matcher = searchPattern.matcher(text);
        if (matcher.find()) {
            return matcher.group();
        }
        return "no matches";
    }

}
