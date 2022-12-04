package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class US06_Page {

    public US06_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//span[@style='float:right']")
    public WebElement addBook;

    @FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
    public WebElement saveChangesBtn;

    @FindBy(xpath = "//tbody/tr/td[3]")
    public WebElement firstNameFirstRow;

    @FindBy(id ="book_group_id")
    public WebElement categoriesDropdown;

    public WebElement expectedResultAfterSearchByName(String string) {

        return Driver.getDriver().findElement(By.xpath("//td[normalize-space()='" + string + "']"));
    }




}


