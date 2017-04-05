package net.dqsy.manager.service;


import net.dqsy.manager.pojo.Organization;

public interface IOrganizationService {

    Organization findOrganizationByAccountId(long accountId);

    Organization findById(long orgId);

    void updateOrganization(Organization organization);
}
