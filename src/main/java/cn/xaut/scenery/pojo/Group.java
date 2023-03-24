package cn.xaut.scenery.pojo;

/**
 * @Author wyx
 * @Date 2023/3/20 19:20
 * @Description:
 */
public class Group {

    private Integer groupId;

    private String groupUsers;

    private String groupRecos;

    private String groupImg;

    private String groupName;

    private String groupPassword;

    public Group() {
    }

    public Group(Integer groupId, String groupUsers, String groupRecos, String groupImg, String groupName, String groupPassword) {
        this.groupId = groupId;
        this.groupUsers = groupUsers;
        this.groupRecos = groupRecos;
        this.groupImg = groupImg;
        this.groupName = groupName;
        this.groupPassword = groupPassword;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupUsers() {
        return groupUsers;
    }

    public void setGroupUsers(String groupUsers) {
        this.groupUsers = groupUsers;
    }

    public String getGroupRecos() {
        return groupRecos;
    }

    public void setGroupRecos(String groupRecos) {
        this.groupRecos = groupRecos;
    }

    public String getGroupImg() {
        return groupImg;
    }

    public void setGroupImg(String groupImg) {
        this.groupImg = groupImg;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupUser(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupPassword() {
        return groupPassword;
    }

    public void setGroupPassword(String groupPassword) {
        this.groupPassword = groupPassword;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupUsers='" + groupUsers + '\'' +
                ", groupRecos='" + groupRecos + '\'' +
                ", groupImg='" + groupImg + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupPassword='" + groupPassword + '\'' +
                '}';
    }
}
