package cn.xaut.scenery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author wyx
 * @Date 2023/3/16 21:40
 * @Description:
 */
public class Comment {

    private Integer comId;

    private String comText;

    private Integer comLikes;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date comDate;

    private Integer sceneId;

    private Integer userId;

    public Comment() {
    }

    public Comment(Integer comId, String comText, Integer comLikes, Date comDate, Integer sceneId, Integer userId) {
        this.comId = comId;
        this.comText = comText;
        this.comLikes = comLikes;
        this.comDate = comDate;
        this.sceneId = sceneId;
        this.userId = userId;
    }

    public Integer getComId() {
        return comId;
    }

    public String getComText() {
        return comText;
    }

    public Integer getComLikes() {
        return comLikes;
    }

    public Date getComDate() {
        return comDate;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public void setComText(String comText) {
        this.comText = comText;
    }

    public void setComLikes(Integer comLikes) {
        this.comLikes = comLikes;
    }

    public void setComDate(Date comDate) {
        this.comDate = comDate;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comId=" + comId +
                ", comText='" + comText + '\'' +
                ", comLikes=" + comLikes +
                ", comDate=" + comDate +
                ", sceneId=" + sceneId +
                ", userId=" + userId +
                '}';
    }
}
