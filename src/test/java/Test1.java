import cn.xaut.scenery.pojo.User;
import cn.xaut.scenery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author wyx
 * @Date 2023/3/13 22:30
 * @Description:
 */

public class Test1 {

    public static void main(String[] args) {
        String sceneRoute = "001-002-003";
        String a[] = sceneRoute.split("-");

        for(int i=0; i< a.length; i++){
            System.out.println(Integer.parseInt(a[i]));
        }


    }

}
