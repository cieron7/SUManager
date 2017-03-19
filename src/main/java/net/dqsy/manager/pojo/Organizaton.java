package net.dqsy.manager.pojo;

import java.util.Date;

/**
 * 机构(院系)
 * Created by Nathan on 2017/3/14.
 */
public class Organizaton {

    private long id;    //id

    private long accountId;     //用户id

    private String logo;        //logo地址

    private String name;        //机构(院系)名称

    private Date createTime;        //创建时间


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
