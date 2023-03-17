package cn.xaut.scenery.pojo;

/**
 * @Author wyx
 * @Date 2023/3/17 13:21
 * @Description:
 */
public class Scene {

    private Integer sceneId;

    private String sceneName;

    private String sceneType;

    private String sceneCoordinate;
    private String sceneImg;

    public Scene() {
    }

    public Scene(Integer sceneId, String sceneName, String sceneType, String sceneCoordinate, String sceneImg) {
        this.sceneId = sceneId;
        this.sceneName = sceneName;
        this.sceneType = sceneType;
        this.sceneCoordinate = sceneCoordinate;
        this.sceneImg = sceneImg;
    }

    public Integer getSceneId() {
        return sceneId;
    }

    public void setSceneId(Integer sceneId) {
        this.sceneId = sceneId;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    public String getSceneType() {
        return sceneType;
    }

    public void setSceneType(String sceneType) {
        this.sceneType = sceneType;
    }

    public String getSceneImg() {
        return sceneImg;
    }

    public void setSceneImg(String sceneImg) {
        this.sceneImg = sceneImg;
    }

    public String getSceneCoordinate() {
        return sceneCoordinate;
    }

    public void setSceneCoordinate(String sceneCoordinate) {
        this.sceneCoordinate = sceneCoordinate;
    }

    @Override
    public String toString() {
        return "Scene{" +
                "sceneId=" + sceneId +
                ", sceneName='" + sceneName + '\'' +
                ", sceneType='" + sceneType + '\'' +
                ", sceneCoordinate='" + sceneCoordinate + '\'' +
                ", sceneImg='" + sceneImg + '\'' +
                '}';
    }
}
