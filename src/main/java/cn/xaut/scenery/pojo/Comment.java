package cn.xaut.scenery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/16 21:40
 * @Description:
 */
public class Comment {

    private Integer comId;

    private String comText;

    private Integer comLikes;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date comDate;

    private Integer comSceneId;

    private Integer comUserId;

    private List<Reply> reply;

    public Comment() {
    }

    public Comment(Integer comId, String comText, Integer comLikes, Date comDate, Integer comSceneId, Integer comUserId, List<Reply> reply) {
        this.comId = comId;
        this.comText = comText;
        this.comLikes = comLikes;
        this.comDate = comDate;
        this.comSceneId = comSceneId;
        this.comUserId = comUserId;
        this.reply = reply;
    }

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComText() {
        return comText;
    }

    public void setComText(String comText) {
        this.comText = comText;
    }

    public Integer getComLikes() {
        return comLikes;
    }

    public void setComLikes(Integer comLikes) {
        this.comLikes = comLikes;
    }

    public Date getComDate() {
        return comDate;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public Integer getComSceneId() {
        return comSceneId;
    }

    public void setComSceneId(Integer comSceneId) {
        this.comSceneId = comSceneId;
    }

    public Integer getComUserId() {
        return comUserId;
    }

    public void setComUserId(Integer comUserId) {
        this.comUserId = comUserId;
    }

    public List<Reply> getReply() {
        return reply;
    }

    public void setReply(List<Reply> reply) {
        this.reply = reply;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comId=" + comId +
                ", comText='" + comText + '\'' +
                ", comLikes=" + comLikes +
                ", comDate=" + comDate +
                ", comSceneId=" + comSceneId +
                ", comUserId=" + comUserId +
                ", reply=" + reply +
                '}';
    }
}
