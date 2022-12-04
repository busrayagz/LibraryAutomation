package com.library.step_defs;

import com.library.pages.BasePage;
import com.library.pages.BookPage;
import com.library.pages.LoginPage;
import com.library.pages.US06_Page;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class US06_StepDefs extends BasePage {

    LoginPage loginPage= new LoginPage();
    US06_Page us06_page=new US06_Page();

    BookPage bookPage=new BookPage();


    @Given("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.login("librarian");

    }
    @Given("I navigate to Books page")
    public void i_navigate_to_page() {
        books.click();

    }
    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        us06_page.addBook.click();

    }
    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {
        BrowserUtil.waitFor(3);
       bookPage.bookName.sendKeys(bookName);
    }
    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String ISBN) {
        bookPage.isbn.sendKeys(ISBN);

    }
    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {
        bookPage.year.sendKeys(year);

    }
    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {
        bookPage.author.sendKeys(author);

    }
    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String category) {

            Select select=new Select(us06_page.categoriesDropdown);
            select.selectByVisibleText(category);
        }

    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {
    us06_page.saveChangesBtn.click();

    }
    @Then("the librarian verify new book by {string}")
    public void the_librarian_verify_new_book_by(String bookName) {

      //  DB_Util.runQuery("select distinct name from books where name ='" + bookName+"';");
     //  String expectedResult= DB_Util.getFirstRowFirstColumn();
        BrowserUtil.waitFor(3);
        bookPage.search.sendKeys(bookName);

        String actualResult=us06_page.firstNameFirstRow.getText();
        Assert.assertEquals(us06_page.expectedResultAfterSearchByName(bookName).getText(), bookName);

    }
    @Then("the librarian verify new book from database by {string}")
    public void the_librarian_verify_new_book_from_database_by(String bookName) {
        DB_Util.runQuery("select distinct name from books where name ='" + bookName+"';");
        String expectedResult= DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedResult,bookName);

    }

}
