package com.oneaston.tap.automation.ui.features.products.bond;

import com.oneaston.tap.automation.ui.features.BasePage;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.GetInteraction;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.SelectInteraction;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.TypeInteraction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BondsOrderPage extends BasePage {

    public final GetInteraction getInteraction;
    public final TypeInteraction typeInteraction;
    public final ClickInteraction clickInteraction;
    public final SelectInteraction selectInteraction;

    public BondsOrderPage(WebDriver driver) {
        super(driver);
        getInteraction = new GetInteraction(driver);
        typeInteraction = new TypeInteraction(driver);
        clickInteraction = new ClickInteraction(driver);
        selectInteraction = new SelectInteraction(driver);
    }

    public BondsOrderPage createBondOrder(String portfolio, String instrument, String nominalPrice, String clientPrice, String spread, String phone, String instructedBy, String contact, String overrideReason) {
        typeInteraction.type("text.formSearch.portfolio.code", portfolio + Keys.RETURN);
        typeInteraction.type("text.formSearch.instr.code", instrument + Keys.RETURN);
        typeInteraction.type("form.quantityN", nominalPrice + Keys.RETURN);
        typeInteraction.type("form.quoteN", clientPrice + Keys.RETURN);
        typeInteraction.type("form.udSpreadP", spread + Keys.RETURN);
        typeInteraction.type("form.udPhoneC", phone + Keys.RETURN);
        typeInteraction.type("form.udReasonForOverrideC", overrideReason + Keys.RETURN);
        insertInstructedBy(instructedBy);
        insertContact(contact);
        submitOrder();
        clarifyCases(webElementLocator.findElements("//input[@form='ReactToMainCheckBox']"));
        saveOrder();
        return this;
    }

    private void clarifyCases(List<WebElement> elements) {
        clickAllCheckbox(elements);
        clickInteraction.clickElement("btn_X_x_1");
        switchToFrame("xguiframe");
        typeInteraction.type("form.reasonC", "Automated Testing");
        clickInteraction.clickElement("btn_U__14");
        switchToParentFrame();
    }

    private void clickAllCheckbox(List<WebElement> elements) {
        for (WebElement element : elements) {
            element.click();
        }
    }

    private void submitOrder() {
        clickInteraction.clickElement("btn_x71o_");
        clickInteraction.clickElement("btn_x71o_");
    }

    private void saveOrder() {
        clickInteraction.clickElement("btn_y___s");
        acceptAlert();
    }

    private void insertInstructedBy(String instructedBy) {
        clickInteraction.clickElement("//i[@title='Search Spoken To Person']");
        clickInteraction.clickElement("//label[text()='" + instructedBy + "']");
    }

    private void insertContact(String contact) {
        clickInteraction.clickElement("//label[text()='Contact Number']/parent::td/following-sibling::td/i");
        clickInteraction.clickElement("//label[text()='" + contact + "']");
    }

}
