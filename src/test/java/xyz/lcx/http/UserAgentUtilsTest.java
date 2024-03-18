package xyz.lcx.http;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import org.junit.jupiter.api.Test;

/**
 * @author chaoxin.lu
 * @version V 1.0
 * @since 2024-03-18
 */
class UserAgentUtilsTest {

    @Test
    void parseUATest() {
        String uaStr = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1";
        UserAgent ua1 = UserAgentUtil.parse(uaStr);
        eu.bitwalker.useragentutils.UserAgent ua2 = eu.bitwalker.useragentutils.UserAgent.parseUserAgentString(uaStr);

        System.out.println("browser1->" + ua1.getBrowser().toString() + " browser2->" + ua2.getBrowser().toString());//Chrome
        System.out.println("version1->" + ua1.getVersion() + " version2->" + ua2.getBrowserVersion().getMinorVersion());//Chrome
        System.out.println("engine1->" + ua1.getEngine().getName() + " engine2->" + ua2.getBrowser().getRenderingEngine().getName());//Chrome
        System.out.println("os1->" + ua1.getOs().getName() + " os2->" + ua2.getOperatingSystem().getName());//Chrome
        System.out.println(ua1.getOs().toString());//Windows 7
        System.out.println(ua1.getPlatform().toString());//Windows


    }
}
