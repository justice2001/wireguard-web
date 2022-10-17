package top.mczhengyi.wg_web_backend.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import top.mczhengyi.wg_web_backend.pojo.InterfaceInfo;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * WireGuard Util
 * Provide Function To Operate WireGuard
 * Use Console
 * @author 正义OvO
 * @version 1.0.0
 */
@Slf4j
public class WireGuardUtil {
    /**
     * Get All Interfaces Name
     * @return All Interfaces Name
     */
    public static String[] getInterfaces() throws IOException {
        Process p = new ProcessBuilder("wg", "show", "interfaces").start();
        String res = IOUtils.toString(p.getInputStream(), StandardCharsets.UTF_8);
        String[] interfaces = res.split(" ");
        for (int i = 0;i < interfaces.length;i ++) {
            interfaces[i] = interfaces[i].trim();
        }
        return interfaces;
    }

    /**
     * Get Interface Info By InterfaceName
     * Command: wg show [interface]
     * @param interfaceName WireGuard Interface Name
     * @return Pipe Return
     */
    public static String getInterfaceInfoSource(String interfaceName) throws IOException {
        Process p = new ProcessBuilder("wg", "show", interfaceName).start();
        String info = IOUtils.toString(p.getInputStream(), StandardCharsets.UTF_8);
        if ("".equals(info) || info == null) {
            log.error("Cannot Get Interface {}", interfaceName);
            return null;
        }
        log.debug("Get Interface {} info: {}", interfaceName, info);
        return info;
    }

    /**
     * Get Interface Info Object
     * Return A InterfaceInfo
     */
    public static InterfaceInfo getInterfaceInfo (String interfaceName) throws IOException {
        String interfaceInfoSource = getInterfaceInfoSource(interfaceName);
        // 拆为多个peer，0元素为Interface本身
        assert interfaceInfoSource != null;
        String[] interfaceInfo = interfaceInfoSource.split("peer:");
        // 获取Interface信息
        InterfaceInfo info = InterfaceInfo.parse(interfaceInfo[0]);
        return info;
    }

    /**
     * Get Interface Config
     * Return Interface Config
     */
    public static void getInterfaceConfig (String interfaceName) {

    }

    /**
     * Save Interface Config
     */
    public static void saveInterfaceConfig () {

    }

    /**
     * Restart Interface
     */
    public static void restartInterface (String interfaceName) {

    }
}
