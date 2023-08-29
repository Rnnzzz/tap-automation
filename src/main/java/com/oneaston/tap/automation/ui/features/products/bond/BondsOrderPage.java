package com.oneaston.tap.automation.ui.features.products.bond;

import com.oneaston.tap.automation.ui.features.BasePage;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.ClickInteraction;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.GetInteraction;
import com.oneaston.tap.automation.ui.seleniumutils.webinteractions.TypeInteraction;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class BondsOrderPage extends BasePage {

    public final GetInteraction getInteraction;
    public final TypeInteraction typeInteraction;
    public final ClickInteraction clickInteraction;

    public BondsOrderPage(WebDriver driver) {
        super(driver);
        getInteraction = new GetInteraction(driver);
        typeInteraction = new TypeInteraction(driver);
        clickInteraction = new ClickInteraction(driver);
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
        clickInteraction.clickElement("btn_x71o_");
        clickInteraction.clickElement("btn_x71o_");
        return this;
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
