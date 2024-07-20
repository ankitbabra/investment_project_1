package com.policybazaar.components.businesslogic;

import com.policybazaar.components.pageobjects.PO_QuotePage;
import com.policybazaar.components.reporting.Extent_Reporting;
import com.policybazaar.components.utilities.ElementAction;
import com.policybazaar.components.utilities.Excel_Handling;
import org.openqa.selenium.WebDriver;

public class BL_ViewPlans extends PO_QuotePage {

    public WebDriver driver;
    public String TC_ID;
    ElementAction action = new ElementAction();

    public BL_ViewPlans(WebDriver d, String tcId) {
        this.driver = d;
        this.TC_ID = tcId;
    }

    public void viewPlans() throws Exception {
        try {
            driver.manage().window().maximize();
            Extent_Reporting.Log_Pass_Screenshot("Pre-Quote page", "Pre-Quote page", driver);
            action.explicitWait(driver, btnViewPlans, 120L,"ElementToBeClickable");
            action.click(driver,"xpath",btnViewPlans, "View Plans Button");
            action.switchToWindowUsingTitle(driver,"quote");
            action.inputText(driver,"xpath",txtYourName, Excel_Handling.Get_Data(TC_ID, "YourName"),"YourName");
            action.inputText(driver,"xpath",txtMobileNumber,Excel_Handling.Get_Data(TC_ID,"MobileNumber"),"MobileNumber");
            action.inputText(driver,"xpath",txtYourEmail,Excel_Handling.Get_Data(TC_ID,"Email"),"Email");


        } catch (Exception t){
            t.printStackTrace();
            Extent_Reporting.Log_Fail(TC_ID,"Function viewPlans is FAILED due to error" +t.getMessage());
            throw new Exception(t.getMessage());
        }
    }

}
