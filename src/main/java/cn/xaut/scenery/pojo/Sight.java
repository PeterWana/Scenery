package cn.xaut.scenery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author wyx
 * @Date 2023/3/17 22:02
 * @Description:
 */
public class Sight {

    private Integer sightId;

    private Integer sightApone;

    private Integer sightAptwo;

    private Integer sightApthr;

    private Integer sightApfou;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sightTime;

    private Integer sightTour;

    private Integer sightSceneId;

    public Sight() {
    }

    public Sight(Integer sightId, Integer sightApone, Integer sightAptwo, Integer sightApthr, Integer sightApfou, Date sightTime, Integer sightTour, Integer sightSceneId) {
        this.sightId = sightId;
        this.sightApone = sightApone;
        this.sightAptwo = sightAptwo;
        this.sightApthr = sightApthr;
        this.sightApfou = sightApfou;
        this.sightTime = sightTime;
        this.sightTour = sightTour;
        this.sightSceneId = sightSceneId;
    }

    public Integer getSightId() {
        return sightId;
    }

    public void setSightId(Integer sightId) {
        this.sightId = sightId;
    }

    public Integer getSightApone() {
        return sightApone;
    }

    public void setSightApone(Integer sightApone) {
        this.sightApone = sightApone;
    }

    public Integer getSightAptwo() {
        return sightAptwo;
    }

    public void setSightAptwo(Integer sightAptwo) {
        this.sightAptwo = sightAptwo;
    }

    public Integer getSightApthr() {
        return sightApthr;
    }

    public void setSightApthr(Integer sightApthr) {
        this.sightApthr = sightApthr;
    }

    public Integer getSightApfou() {
        return sightApfou;
    }

    public void setSightApfou(Integer sightApfou) {
        this.sightApfou = sightApfou;
    }

    public Date getSightTime() {
        return sightTime;
    }

    public void setSightTime(Date sightTime) {
        this.sightTime = sightTime;
    }

    public Integer getSightTour() {
        return sightTour;
    }

    public void setSightTour(Integer sightTour) {
        this.sightTour = sightTour;
    }

    public Integer getSightSceneId() {
        return sightSceneId;
    }

    public void setSightSceneId(Integer sightSceneId) {
        this.sightSceneId = sightSceneId;
    }

    @Override
    public String toString() {
        return "Sight{" +
                "sightId=" + sightId +
                ", sightApone=" + sightApone +
                ", sightAptwo=" + sightAptwo +
                ", sightApthr=" + sightApthr +
                ", sightApfou=" + sightApfou +
                ", sightTime=" + sightTime +
                ", sightTour=" + sightTour +
                ", sightSceneId=" + sightSceneId +
                '}';
    }
}
