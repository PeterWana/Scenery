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

    public Group() {
    }

    public Group(Integer groupId, String groupUsers, String groupRecos) {
        this.groupId = groupId;
        this.groupUsers = groupUsers;
        this.groupRecos = groupRecos;
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

    @Override
    public String toString() {
        return "group{" +
                "groupId=" + groupId +
                ", groupUsers='" + groupUsers + '\'' +
                ", groupRecos='" + groupRecos + '\'' +
                '}';
    }
}
