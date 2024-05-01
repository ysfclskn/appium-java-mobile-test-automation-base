package configs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ApkInstaller {


    public static void downloadAndInstallApkIfNeeded(String apkPath) throws IOException, InterruptedException {
        if (!isApkInstalled()) {
            installApk(apkPath);
        }
    }

    public static boolean isApkInstalled() throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(new String[]{"adb", "shell", "pm", "list", "packages", "-f"});
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("com.example.pocandroidapp")) {
                return true;
            }
        }
        return false;
    }

    public static void installApk(String apkPath) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(new String[]{"adb", "install", "-r", apkPath});
        process.waitFor();
    }

}
