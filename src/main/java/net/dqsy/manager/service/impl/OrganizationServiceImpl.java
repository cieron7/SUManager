package net.dqsy.manager.service.impl;


import net.dqsy.manager.mapper.OrganizationMapper;
import net.dqsy.manager.pojo.Organization;
import net.dqsy.manager.service.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationServiceImpl implements IOrganizationService {
    @Autowired
    private OrganizationMapper organizationMapper;


    @Override
    public Organization findOrganizationByAccountId(long accountId) {
        try {
            return organizationMapper.findOrganizationByAccountId(accountId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Organization findById(long orgId) {
        try {
            return organizationMapper.findById(orgId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateOrganization(Organization organization) {
        try {
            organizationMapper.updateOrganization(organization);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
