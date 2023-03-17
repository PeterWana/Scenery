package cn.xaut.scenery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author wyx
 * @Date 2023/3/17 13:21
 * @Description:
 */

public class Reply {

    private Integer replyId;

    private String replyText;

    private Integer replyLikes;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date replyDate;

    private Integer replyComId;

    private Integer replyUserId;

    public Reply() {
    }

    public Reply(Integer replyId, String replyText, Integer replyLikes, Date replyDate, Integer replyComId, Integer replyUserId) {
        this.replyId = replyId;
        this.replyText = replyText;
        this.replyLikes = replyLikes;
        this.replyDate = replyDate;
        this.replyComId = replyComId;
        this.replyUserId = replyUserId;
    }

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public String getReplyText() {
        return replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    public Integer getReplyLikes() {
        return replyLikes;
    }

    public void setReplyLikes(Integer replyLikes) {
        this.replyLikes = replyLikes;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public Integer getReplyComId() {
        return replyComId;
    }

    public void setReplyComId(Integer replyComId) {
        this.replyComId = replyComId;
    }

    public Integer getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyText='" + replyText + '\'' +
                ", replyLikes=" + replyLikes +
                ", replyDate=" + replyDate +
                ", replyComId=" + replyComId +
                ", replyUserId=" + replyUserId +
                '}';
    }
}
