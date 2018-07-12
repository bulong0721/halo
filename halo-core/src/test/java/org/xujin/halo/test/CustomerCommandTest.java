package org.xujin.halo.test;

import org.xujin.halo.TestConfig;
import org.xujin.halo.context.HaloContext;
import org.xujin.halo.dto.Response;
import org.xujin.halo.exception.BasicErrorCode;
import org.xujin.halo.test.customer.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * CustomerCommandTest
 *
 * @author xujin 2018-01-06 7:55 PM
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
public class CustomerCommandTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Autowired
    private CustomerServiceI customerService;

    @Value("${bizCode}")
    private String bizCode;

    @Before
    public void setUp() {
        HaloContext.set(bizCode,Constants.TENANT_ID);
    }

    @Test
    public void testBizOneAddCustomerSuccess(){
        //1. Prepare
        HaloContext.set( Constants.BIZ_1,Constants.TENANT_ID);
        AddCustomerCmd addCustomerCmd = new AddCustomerCmd();
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCompanyName("xxxx");
        customerCO.setSource(Constants.SOURCE_RFQ);
        customerCO.setCustomerType(CustomerType.IMPORTANT);
        addCustomerCmd.setCustomerCO(customerCO);

        //2. Execute
        Response response = customerService.addCustomer(addCustomerCmd);

        //3. Expect Success
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void testBizOneAddCustomerFailure(){
        //1. Prepare
        HaloContext.set(Constants.BIZ_1,Constants.TENANT_ID);
        AddCustomerCmd addCustomerCmd = new AddCustomerCmd();
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCompanyName("xxxx");
        customerCO.setSource(Constants.SOURCE_AD);
        customerCO.setCustomerType(CustomerType.IMPORTANT);
        addCustomerCmd.setCustomerCO(customerCO);

        //2. Execute
        Response response = customerService.addCustomer(addCustomerCmd);

        //3. Expect exception
        Assert.assertFalse(response.isSuccess());
        Assert.assertEquals(response.getErrCode(), BasicErrorCode.BIZ_ERROR.getErrCode());
    }

    @Test
    public void testBizTwoAddCustomer(){
        //1. Prepare
        HaloContext.set(Constants.BIZ_2,Constants.TENANT_ID);
        AddCustomerCmd addCustomerCmd = new AddCustomerCmd();
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCompanyName("xxxx");
        customerCO.setSource(Constants.SOURCE_AD);
        customerCO.setCustomerType(CustomerType.IMPORTANT);
        addCustomerCmd.setCustomerCO(customerCO);

        //2. Execute
        Response response = customerService.addCustomer(addCustomerCmd);

        //3. Expect Success
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void testCompanyTypeViolation(){
        AddCustomerCmd addCustomerCmd = new AddCustomerCmd();
        CustomerCO customerCO = new CustomerCO();
        customerCO.setCompanyName("xxxx");
        customerCO.setSource("p4p");
        customerCO.setCustomerType(CustomerType.VIP);
        addCustomerCmd.setCustomerCO(customerCO);
        Response response = customerService.addCustomer(addCustomerCmd);

        //Expect biz exception
        Assert.assertFalse(response.isSuccess());
        Assert.assertEquals(response.getErrCode(), BasicErrorCode.BIZ_ERROR.getErrCode());
    }

    @Test
    public void testParamValidationFail(){
        AddCustomerCmd addCustomerCmd = new AddCustomerCmd();
        Response response = customerService.addCustomer(addCustomerCmd);

        //Expect parameter validation error
        Assert.assertFalse(response.isSuccess());
        Assert.assertEquals(response.getErrCode(), BasicErrorCode.PARAM_ERROR.getErrCode());
    }
}
