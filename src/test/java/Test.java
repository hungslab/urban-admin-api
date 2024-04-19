import cn.hutool.crypto.SecureUtil;


/**
 * @author hungs
 * @date 2024-04-08
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(SecureUtil.md5("admin" + "admin123" + "111111"));
    }

}
