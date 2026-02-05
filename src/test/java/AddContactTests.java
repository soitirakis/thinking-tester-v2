import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddContactPage;

import java.util.List;

public class AddContactTests extends BaseTests{
    static AddContactPage addContactPage;

    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();
        addContactPage = new AddContactPage(driver);
        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List App");

        loginPage.authenticate("gr8test@test.com", "gr8test!");
        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List");

        contactListPage.clickAddNewContactButton();
        Assert.assertEquals(addContactPage.getHeaderText(), "Add Contact");

    }
    @Test
    public void testAddContactWithMandatoryData() {
        addContactPage.addContactWithMandatoryData("testtest", "test1");

        List<String> names = contactListPage.getNameColumnValues();
        Assert.assertTrue(names.contains("testtest"+" test1"));
    }
    @Test
    public void testValidContactCreation(){

        addContactPage.addNewContact("first", "last", "1999-10-12", "test@test.com", "07123123123",
                "street1", "street2", "BestCity", "Provence", "102102", "Best Country");

        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        contactListPage.getHeaderText();
        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List");

        List<String> names = contactListPage.getNameColumnValues();
        Assert.assertTrue(names.contains("first"+" last"));

        Assert.assertEquals(contactListPage.getEmailValue("first"), "test@test.com");
    }
    @Test
    public void testMissingFirstNameLastName() throws InterruptedException {
        addContactPage.addNewContact("", "", "", "", "", "", "", "", "", "","");

        Assert.assertEquals(addContactPage.getHeaderText(), "Add Contact");
        Assert.assertEquals(addContactPage.getErrorMessage(), "Contact validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required.");
    }
}
