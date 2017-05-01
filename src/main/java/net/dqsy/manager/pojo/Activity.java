package net.dqsy.manager.pojo;

import java.util.Date;

/**
 * 活动
 */
public class Activity {

    public static int ACTIVITY = 1;
    public static int MOMENT = 2;

    private long id;    //id

    private String title;   //活动名称

    private String subTitle;    //小标题

    private String content;     //活动内容

    private int limitNum;       //分类名称

    private Date startTime;     //开始时间

    private Date endTime;       //结束时间

    private long departmentId;   //活动id

    private long departmentMemberId;    //部门成员id

    private int type;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getDepartmentMemberId() {
        return departmentMemberId;
    }

    public void setDepartmentMemberId(long departmentMemberId) {
        this.departmentMemberId = departmentMemberId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
