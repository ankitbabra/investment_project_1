package com.policybazaar.components.tests;

import com.policybazaar.components.businesslogic.BL_ViewPlans;
import com.policybazaar.components.setup.DriverSetup;
import com.policybazaar.components.utilities.Log;
import org.testng.annotations.Test;


public class TC001_QuotePage extends DriverSetup {

    Log log = new Log(this.getClass().getName());
    @Test
    public void TC001_quotePage() throws Throwable {
        log.startTestCase(TC_ID);
        BL_ViewPlans plans = new BL_ViewPlans(driver, TC_ID);
        plans.viewPlans();
        log.endTestCase(TC_ID);

    }

}
