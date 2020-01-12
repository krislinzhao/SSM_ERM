package club.krislin.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Package club.krislin.utils
 * @ClassName BCryptPasswordEncoderUtiles
 * @Description TODO
 * @Date 20/1/10 17:38
 * @Author LIM
 * @Version V1.0
 */
public class BCryptPasswordEncoderUtiles {
    private static BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public static String encoding(String str) {
        String pwd = passwordEncoder.encode(str);
        return pwd;
    }

    public static void main(String[] args) {
        String str = "123";
        String s = encoding(str);
        System.out.println(s);
    }
}
