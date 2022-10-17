package top.mczhengyi.wg_web_backend.pojo;

import lombok.Data;

/**
 * WireGuard Peer Info
 * @author 正义OvO
 * @version 1.0.0
 */
@Data
public class PeerInfo {
    private String endPoint;
    private String allowedIps;
    private String latestHandShake;
    private String transferReceived;
    private String transferSent;
}
