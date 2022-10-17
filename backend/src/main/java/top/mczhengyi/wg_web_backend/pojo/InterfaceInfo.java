package top.mczhengyi.wg_web_backend.pojo;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * WireGuard Interface Info
 * @author 正义OvO
 * @version 1.0.0
 */
@Data
public class InterfaceInfo {
    private String name;
    private String publicKey;
    private String privateKey;
    private Integer listenPort;

    private List<PeerInfo> peers = new ArrayList<>();

    public static InterfaceInfo parse(String src) {
        InterfaceInfo info = new InterfaceInfo();
        String[] s = src.split("\n");
        Map<String, String> map = new HashMap<>();
        for (String value : s) {
            String[] kv = value.split(":");
            map.put(kv[0].trim(), kv[1].trim());
        }
        // Set Data
        info.setName(map.get("interface"));
        info.setPublicKey(map.get("public key"));
        info.setListenPort(Integer.parseInt(map.get("listening port")));
        info.setPrivateKey(map.get("private key"));
        // Success Set
        return info;
    }
}
