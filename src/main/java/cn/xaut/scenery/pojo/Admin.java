package cn.xaut.scenery.pojo;

/**
 * @Author wyx
 * @Date 2023/3/14 14:46
 * @Description:
 */
public class Admin {

    private Integer adminId;

    private String adminName;

    private String adminPassword;

    private String adminNum;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminPassword, String adminNum) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
        this.adminNum = adminNum;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminNum='" + adminNum + '\'' +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminUsername) {
        this.adminName = adminUsername;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminNum() {
        return adminNum;
    }

    public void setAdminNum(String adminNum) {
        this.adminNum = adminNum;
    }


}
