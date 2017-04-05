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
    @Test
    public void findByIdTest(){
        Organization organization = organizationService.findById(1L);
        logger.info(organization.getName());
    }

    @Test
    public  void updateOrganizationTest(){
        Organization organization = new Organization();
        organization.setId(1L);
        organization.setName("计算机");
        organization.setLogo("没有啊");
        organizationService.updateOrganization(organization);
    }

}
