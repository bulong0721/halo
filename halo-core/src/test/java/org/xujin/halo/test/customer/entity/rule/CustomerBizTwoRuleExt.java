package org.xujin.halo.test.customer.entity.rule;

import org.xujin.halo.test.customer.entity.CustomerEntity;

/**
 * CustomerBizTwoRuleExt
 *
 * @author xujin
 * @date 2018-01-07 12:10 PM
 */
public class CustomerBizTwoRuleExt implements CustomerRuleExtPt{

    @Override
    public boolean addCustomerCheck(CustomerEntity customerEntity) {
        //Any Customer can be added
        return true;
    }
}
