package net.dqsy.manager.pojo;

import java.util.Date;

/**
 * Created by Nathan on 2017/3/14.
 *
 *  评论
 */
public class Comment {
    private long id;    //id

    private long activityId;    //活动id

    private long accountId;     //用户id

    private String content;     //评论内容

    private int status;     //状态

    private long parentId;      //评论id

    private Date createTime;    //创建时间

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getActivityId() {
        return activityId;
    }

    public void setActivityId(long activityId) {
        this.activityId = activityId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
