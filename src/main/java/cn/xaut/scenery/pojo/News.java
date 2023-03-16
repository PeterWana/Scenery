package cn.xaut.scenery.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author wyx
 * @Date 2023/3/16 10:52
 * @Description:
 */

public class News {

    private Integer newId;

    private String newText;

    private Integer newLikes;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date newDate;

    public News() {
    }

    public News(Integer newId, String newText, Integer newLikes, Date newDate) {
        this.newId = newId;
        this.newText = newText;
        this.newLikes = newLikes;
        this.newDate = newDate;
    }

    public Integer getNewId() {
        return newId;
    }

    public void setNewId(Integer newId) {
        this.newId = newId;
    }

    public String getNewText() {
        return newText;
    }

    public void setNewText(String newText) {
        this.newText = newText;
    }

    public Integer getNewLikes() {
        return newLikes;
    }

    public void setNewLikes(Integer newLikes) {
        this.newLikes = newLikes;
    }

    public Date getNewDate() {
        return newDate;
    }

    public void setNewDate(Date newDate) {
        this.newDate = newDate;
    }

    @Override
    public String toString() {
        return "New{" +
                "newId=" + newId +
                ", newText='" + newText + '\'' +
                ", newLikes=" + newLikes +
                ", newDate=" + newDate +
                '}';
    }
}
