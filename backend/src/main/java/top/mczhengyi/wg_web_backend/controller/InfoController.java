package top.mczhengyi.wg_web_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mczhengyi.wg_web_backend.pojo.InterfaceInfo;
import top.mczhengyi.wg_web_backend.utils.WireGuardUtil;

import java.io.IOException;

@RestController
@RequestMapping("info")
public class InfoController {
    @GetMapping("{name}")
    public InterfaceInfo getInterfaceInfo(@PathVariable String name) throws IOException {
        return WireGuardUtil.getInterfaceInfo(name);
    }

    @GetMapping("all")
    public String[] getInterfaces() throws IOException {
        return WireGuardUtil.getInterfaces();
    }
}
