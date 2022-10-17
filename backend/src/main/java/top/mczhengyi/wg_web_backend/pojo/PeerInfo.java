package top.mczhengyi.wg_web_backend.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * WireGuard Peer Info
 * @author 正义OvO
 * @version 1.0.0
 */
@Data
@Slf4j
public class PeerInfo {
    private String publicKey;
    private String endPoint;
    private String allowedIps;
    private String latestHandShake;
    private String transferReceived;
    private String transferSent;

    public static PeerInfo parse(String peerInfo) {
        String[] peerInfoList = peerInfo.split("\n");
        PeerInfo info = new PeerInfo();
        // Peer[0]为公钥
        info.setPublicKey(peerInfoList[0].trim());
        // 处理信息
        Map<String, String> map = new HashMap<>();
        for (String peerInfoKv: peerInfoList) {
            String[] kv = peerInfoKv.split(":");
            log.debug("Peers Info Parse Key/Value: {}", Arrays.toString(kv));
            if (kv.length > 1) {
                map.put(kv[0].trim(), kv[1].trim());
            }
        }
        // Put Info
        info.setEndPoint(map.get("endpoint"));
        info.setAllowedIps(map.get("allowed ips"));
        info.setLatestHandShake(map.get("latest handshake"));
        // Process Transfer Info
        String transferSrc = map.get("transfer");
        if (transferSrc != null && !"".equals(transferSrc)) {
            String[] transfer = transferSrc.split(", ");
            info.setTransferReceived(transfer[0].trim());
            info.setTransferSent(transfer[1].trim());
        }
        return info;
    }
}
