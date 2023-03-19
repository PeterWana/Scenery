package cn.xaut.scenery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

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

    private List<Sight> sight;

    public Tour() {
    }

    public Tour(Integer tourId, Date tourTime, Integer tourUserId, List<Sight> sight) {
        this.tourId = tourId;
        this.tourTime = tourTime;
        this.tourUserId = tourUserId;
        this.sight = sight;
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

    public List<Sight> getSight() {
        return sight;
    }

    public void setSight(List<Sight> sight) {
        this.sight = sight;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourId=" + tourId +
                ", tourTime=" + tourTime +
                ", tourUserId=" + tourUserId +
                ", sight=" + sight +
                '}';
    }
}
