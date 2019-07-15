package com.tws.refactoring.extract_variable;

public class BannerRender {
    String renderBanner(String platform, String browser) {
        boolean isIEorMac = (platform.toUpperCase().contains("MAC")) && (browser.toUpperCase().contains("IE"));
        if (isIEorMac) {
            return "IE on Mac?";
        }
        return "banner";
    }
}
