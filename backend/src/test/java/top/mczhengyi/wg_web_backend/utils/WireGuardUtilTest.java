package top.mczhengyi.wg_web_backend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class WireGuardUtilTest {
    @Test
    public void getInterfaces() throws IOException {
        // Check GetInterfaces Function
        System.out.println(Arrays.toString(WireGuardUtil.getInterfaces()));
    }

    @Test
    public void getInterfaceInfoSource() throws IOException {
        String[] interfaces = WireGuardUtil.getInterfaces();
        // Check Get Wg0 Interface Must Have Data
        String wg0 = WireGuardUtil.getInterfaceInfoSource(interfaces[0]);
        Assert.assertNotEquals(wg0, "");
        // Check Get None Interface, Must Is Null!
        String none = WireGuardUtil.getInterfaceInfoSource("none");
        Assert.assertNull(none);
    }

    @Test
    public void getInterfaceInfo() throws IOException {
        System.out.println(WireGuardUtil.getInterfaceInfo("wg0"));;
    }

    @Test
    public void getInterfaceConfig() {
    }

    @Test
    public void saveInterfaceConfig() {
    }

    @Test
    public void restartInterface() {
    }
}
