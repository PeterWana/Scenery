package cn.xaut.scenery.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/17 22:02
 * @Description:
 */
public class Sight {

    private Integer sightId;

    private String sightAp;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date sightTime;

    private Integer sightTourId;

    private Integer sightSceneId;

    private List<Scene> scene;

    public Sight() {
    }

    public Sight(Integer sightId, String sightAp, Date sightTime, Integer sightTourId, Integer sightSceneId, List<Scene> scene) {
        this.sightId = sightId;
        this.sightAp = sightAp;
        this.sightTime = sightTime;
        this.sightTourId = sightTourId;
        this.sightSceneId = sightSceneId;
        this.scene = scene;
    }

    public Integer getSightId() {
        return sightId;
    }

    public void setSightId(Integer sightId) {
        this.sightId = sightId;
    }

    public String getSightAp() {
        return sightAp;
    }

    public void setSightAp(String sightAp) {
        this.sightAp = sightAp;
    }

    public Date getSightTime() {
        return sightTime;
    }

    public void setSightTime(Date sightTime) {
        this.sightTime = sightTime;
    }

    public Integer getSightTourId() {
        return sightTourId;
    }

    public void setSightTourId(Integer sightTourId) {
        this.sightTourId = sightTourId;
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
                ", sightAp=" + sightAp +
                ", sightTime=" + sightTime +
                ", sightTourId=" + sightTourId +
                ", sightSceneId=" + sightSceneId +
                '}';
    }

    public List<Scene> getScene() {
        return scene;
    }

    public void setScene(List<Scene> scene) {
        this.scene = scene;
    }
}
