package cn.xaut.scenery.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wyx
 * @Date 2023/3/14 10:56
 * @Description:
 */
public class ReturnObject {
    private String code;
    private String message;
    private Map<?, ?> information;

    public ReturnObject() {
    }

    public ReturnObject(String code, String message, HashMap<?, ?> information) {
        this.code = code;
        this.message = message;
        this.information = information;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HashMap<?, ?> getInformation() {
        return (HashMap<?, ?>) information;
    }

    public void setInformation(HashMap<?, ?> information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "ReturnObject{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
