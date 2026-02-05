import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactDetailsPage;
import pages.EditContactPage;

public class EditContactTests extends BaseTests{
    static ContactDetailsPage contactDetailsPage;

    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();

        loginPage.authenticate("gr8test@test.com", "gr8test!");
        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List");

        contactListPage.clickToEditContact();
        contactDetailsPage = new ContactDetailsPage(driver);
    }
    @Test
    public void editContactTest(){
        contactDetailsPage.editContactDetails();
        EditContactPage editContactPage = new EditContactPage(driver);

        Assert.assertEquals(editContactPage.getHeaderText(), "Edit Contact");

        editContactPage.editFirstName("New First Name");
        editContactPage.clickSubmitButton();

        Assert.assertEquals(contactDetailsPage.getHeaderText(), "Contact Details");
        Assert.assertEquals(contactDetailsPage.getFirstNameValue(), "New First Name");

        contactDetailsPage.clickReturnToContactListButton();
        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List");
        Assert.assertTrue(contactListPage.isContactDisplayed());
    }
    @Test
    public void editFirstNameTooLong() throws InterruptedException{
        contactDetailsPage.editContactDetails();
        EditContactPage editContactPage = new EditContactPage(driver);

        Assert.assertEquals(editContactPage.getHeaderText(), "Edit Contact");

        editContactPage.editFirstName("New First Name");
        editContactPage.clickSubmitButton();

        Assert.assertEquals(editContactPage.getErrorMessage(), "Validation failed: firstName: Path `firstName` (`firstNameNew First Name`) is longer than the maximum allowed length (20).");
    }
    @Test
    public void deleteContactTest(){
        contactDetailsPage.deleteContactDetails();

        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List");
        Assert.assertTrue(contactListPage.isContactDeleted());
    }

    @Test
    public void returnToContactListTest() {
        contactDetailsPage.clickReturnToContactListButton();

        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List");
    }
}
