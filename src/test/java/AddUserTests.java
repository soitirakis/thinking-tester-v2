import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AddUserPage;
import utils.RandomGenerator;

public class AddUserTests extends BaseTests{
    AddUserPage addUser;
    @BeforeMethod
    public void beforeMethod(){
        super.beforeMethod();
        loginPage.clickSignUp();
        addUser = new AddUserPage(driver);
    }
    @Test
    public void testValidUser() {
        Assert.assertEquals("Add User", addUser.getHeaderText());

        addUser.createNewUser(":User", "UserLastName", RandomGenerator.stringValue(3)+"test@test.com", "userPassword");
        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), "Contact List");
    }
    @Test
    public void testMissingDataUser() throws InterruptedException {
        Assert.assertEquals(addUser.getHeaderText(), "Add User");

        addUser.createNewUser("", "", "", "");
        Assert.assertEquals(addUser.getErrorMessage(), "User validation failed: firstName: Path `firstName` is required., lastName: Path `lastName` is required., email: Email is invalid, password: Path `password` is required.");
    }
    @Test
    public void testMissingDataEmail() throws InterruptedException {
        Assert.assertEquals("Add User", addUser.getHeaderText());

        addUser.createNewUser(":User", "UserLastName", "", "");
        Assert.assertEquals(addUser.getErrorMessage(), "User validation failed: email: Email is invalid, password: Path `password` is required.");
    }
    @Test
    public void testInvalidEmail() throws InterruptedException {
        Assert.assertEquals("Add User", addUser.getHeaderText());

        addUser.createNewUser("User", "LastName", "abc", "abc1234");
        Assert.assertEquals(addUser.getErrorMessage(), "User validation failed: email: Email is invalid");
    }
    @Test
    public void testInvalidPassword() throws InterruptedException {
        Assert.assertEquals("Add User", addUser.getHeaderText());

        addUser.createNewUser("User", "LastName", "abc@test.com", "abc");
        Assert.assertEquals(addUser.getErrorMessage(), "User validation failed: password: Path `password` (`abc`) is shorter than the minimum allowed length (7).");
    }
}
