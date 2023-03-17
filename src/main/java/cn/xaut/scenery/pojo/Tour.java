package cn.xaut.scenery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author wyx
 * @Date 2023/3/17 21:33
 * @Description:
 */
public class Tour {

    private Integer tourId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tourTime;

    private Integer tourUserId;

    public Tour() {
    }

    public Tour(Integer tourId, Date tourTime, Integer tourUserId) {
        this.tourId = tourId;
        this.tourTime = tourTime;
        this.tourUserId = tourUserId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Date getTourTime() {
        return tourTime;
    }

    public void setTourTime(Date tourTime) {
        this.tourTime = tourTime;
    }

    public Integer getTourUserId() {
        return tourUserId;
    }

    public void setTourUserId(Integer tourUserId) {
        this.tourUserId = tourUserId;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", tourTime=" + tourTime +
                ", tourUserId=" + tourUserId +
                '}';
    }
}
