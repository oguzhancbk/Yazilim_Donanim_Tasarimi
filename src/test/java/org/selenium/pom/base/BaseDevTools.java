package org.selenium.pom.base;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v106.emulation.Emulation;

import java.io.IOException;
import java.util.Optional;

public class BaseDevTools {
    public DevTools BaseDevTools(DevTools devTools) throws IOException {
        devTools.createSession();
        devTools.send(Emulation.setDeviceMetricsOverride(
                390,
                844,
                100,
                true,
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        devTools.send(Emulation.setUserAgentOverride("Mozilla/5.0 (Linux; Android 8.0; Pixel 2 Build/OPD3.170816.012) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) " +
                        "Chrome/107.0.5304.88 Mobile Safari/537.36",
                Optional.empty(),
                Optional.empty(),
                Optional.empty()));
        return devTools;
    }
}
