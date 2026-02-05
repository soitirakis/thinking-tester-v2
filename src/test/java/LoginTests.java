import org.testng.Assert;
import org.testng.annotations.Test;
import testData.pages.LoginTestData;
import utils.Reader;

import static testData.pages.ContactListTestData.CONTACT_LIST_HEADER;

public class LoginTests extends BaseTests{
    @Test
    public void validLoginTest() {
        //loginPage.authenticate("gr8test@test.com", "gr8test!");

        //loginPage.authenticate(Reader.json("user").get("username").toString(),
        //        Reader.json("user").get("password").toString());

        //loginPage.authenticate(mainUser.getUsername(),  mainUser.getPassword());

        loginPage.authenticate(mainUser);
        //loginPage.authenticate(adminUser);

        Assert.assertTrue(contactListPage.isLogoutDisplayed());
        Assert.assertEquals(contactListPage.getHeaderText(), CONTACT_LIST_HEADER);
    }

    @Test
    public void invalidLoginTest() throws InterruptedException {
        loginPage.authenticate("gr8test", "gr8test!");

        Assert.assertEquals(loginPage.getError(), LoginTestData.INVALID_USERNAME_PASSWORD);
    }

    @Test
    public void loginWithMissingCredentials()  throws InterruptedException {
        loginPage.authenticate("", "");

        Assert.assertEquals(loginPage.getError(), LoginTestData.INVALID_USERNAME_PASSWORD);
    }
}
