package top.mczhengyi.wg_web_backend.process;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class RunProcessTest {

    @Test
    public void runProcess() throws IOException {
        Process process = new ProcessBuilder("ls", "-l").start();
        String s = IOUtils.toString(process.getInputStream(), StandardCharsets.UTF_8);
        System.out.println(s);
    }
}
