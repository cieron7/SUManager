package net.dqsy.manager.mapper;


import net.dqsy.manager.pojo.Organization;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {

    Organization findOrganizationByAccountId(@Param("accountId") long accountId);

    Organization findById(@Param("orgId") long orgId);

    void updateOrganization(@Param("organization") Organization organization);
}
