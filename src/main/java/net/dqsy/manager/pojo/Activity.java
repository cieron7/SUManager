package net.dqsy.manager.pojo;

import java.util.Date;

/**
 * 活动
 */
public class Activity {

    private long id;

    private String title;

    private String subTitle;

    private String context;

    private int limitNum;

    private Date startTime;

    private Date endTime;

    private long apartmentId;

    private long departmentMemberId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public long getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(long apartmentId) {
        this.apartmentId = apartmentId;
    }

    public long getDepartmentMemberId() {
        return departmentMemberId;
    }

    public void setDepartmentMemberId(long departmentMemberId) {
        this.departmentMemberId = departmentMemberId;
    }
}
