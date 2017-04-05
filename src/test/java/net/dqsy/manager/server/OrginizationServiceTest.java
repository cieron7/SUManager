package net.dqsy.manager.server;


import net.dqsy.manager.pojo.Organization;
import net.dqsy.manager.service.IOrganizationService;
import net.dqsy.manager.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OrginizationServiceTest extends BaseTest{

    @Autowired
    private IOrganizationService organizationService;

    @Test
    public void findOrganizationByAccountIdTest(){
        Organization organization = organizationService.findOrganizationByAccountId(201204160110L);
        logger.info(organization.getName());
    }

}
