package cn.xaut.scenery.pojo;

import java.util.List;

/**
 * @Author wyx
 * @Date 2023/3/13 21:30
 * @Description:
 */
public class User {

    private Integer userId;

    private String userName;

    private String userPassword;

    private Integer userSex;

    private Integer userAge;

    private String userNum;

    private List<?> tours;

    public User() {
    }

    public User(Integer userId, String userName, String userPassword, Integer userSex, Integer userAge, String userNum) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userNum = userNum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userSex=" + userSex +
                ", userAge=" + userAge +
                ", userNum='" + userNum + '\'' +
                '}';
    }
}
