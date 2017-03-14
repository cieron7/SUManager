package net.dqsy.manager.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CommonConfig {
    private static InputStream in = null;
    public static Properties config = new Properties();

    public static String PULIC_TEST = "";

    static {
        try {
            File file = new File(System.getProperty("catalina.home") + "/conf/commonConfig.properties");
            if (file.exists()) {
                in = new FileInputStream(file);
            } else {

                in = CommonConfig.class.getClassLoader().getResourceAsStream("commonConfig.properties");
            }
            config.load(in);

            PULIC_TEST = config.getProperty("PULIC_TEST").trim();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
