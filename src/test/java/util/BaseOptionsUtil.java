package util;

import io.appium.java_client.remote.options.BaseOptions;

import java.io.IOException;
import java.nio.file.Paths;

import configs.ApkInstaller;

public class BaseOptionsUtil {
    public BaseOptions getBaseOptions() {
        BaseOptions baseOptions = new BaseOptions();
        baseOptions.setPlatformName(ConfigReader.get("platformName"));
        baseOptions.setCapability("udid", ConfigReader.get("udid"));
        baseOptions.setCapability("appPackage", ConfigReader.get("appPackage"));
        baseOptions.setCapability("appActivity", ConfigReader.get("appActivity"));
        try {
            String apkFileName = "com.example.pocandroidapp_.MainActivity_ver_16.apk";
            String apkPath = Paths.get("src/test/java/apps", apkFileName).toString();
            ApkInstaller.downloadAndInstallApkIfNeeded(apkPath);
        } catch (IOException | InterruptedException e) {
            System.err.println("An error occurred while installing the APK: " + e.getMessage());
            e.printStackTrace();
        }
        return baseOptions;
    }
}
