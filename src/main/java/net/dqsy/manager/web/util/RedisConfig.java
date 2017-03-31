package net.dqsy.manager.web.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 * redis param config
 * 
 * @author yjY
 * @version 1.0.0 RedisConfig.java 2017-3-2 下午2:45:29
 */
public class RedisConfig {
	private static InputStream in = null;
	public static Properties config = new Properties();
	public final static long KB = 1024;
	public final static long MB = 1024 * KB;
	public static long MAX_UPLOADSIZE = 100*MB;
	public static long MAX_PHOTOSIZE = 5*MB;
	/** redis master param */
	public static String REDIS_COMMON_PASSWORD ="public";
	public static String REDIS_MASTER_IP = "";
	public static int REDIS_MASTER_PORT = 6379;
	
	/** redis slave param */
	public static String REDIS_SLAVE0_IP = "";
	public static int REDIS_SLAVE0_PORT = 0;
	public static String REDIS_SLAVE1_IP = "";
	public static int REDIS_SLAVE1_PORT = 0;
	public static String REDIS_SLAVE2_IP = "";
	public static int REDIS_SLAVE2_PORT = 0;
	
	/** redis pool param */
	public static String REDIS_POOL_MAXACTIVE = "";
	public static String REDIS_POOL_MAXIDLE = "";
	public static String REDIS_POOL_MAXWAIT = "";
	public static String REDIS_POOL_TESTONBORROW = "";
	public static String REDIS_POOL_TESTONRETURN = "";
	
	/** redis sharded param */
	public static Boolean REDIS_SHARDED = Boolean.FALSE;

	static {
		try {
			File file = new File(System.getProperty("catalina.home") + "/conf/redis.properties");
			if (file.exists()) {
				in = new FileInputStream(file);
			} else {/** use default config */
				in = RedisConfig.class.getClassLoader().getResourceAsStream("commonConfig.properties");
			}
			config.load(in);

			REDIS_COMMON_PASSWORD = config.getProperty("REDIS.COMMON.PASSWORD");

			REDIS_MASTER_IP = config.getProperty("REDIS.MASTER.IP");
			REDIS_MASTER_PORT = Integer.parseInt(config.getProperty("REDIS.MASTER.PORT"));
			REDIS_SHARDED = Boolean.parseBoolean(config.getProperty("JEDIS.SHARDED"));
			
			if(REDIS_SHARDED){
				REDIS_SLAVE0_IP = config.getProperty("REDIS.SLAVE0.IP");
				REDIS_SLAVE0_PORT = Integer.parseInt(config.getProperty("REDIS.SLAVE0.PORT"));
				REDIS_SLAVE1_IP = config.getProperty("REDIS.SLAVE1.IP");
				REDIS_SLAVE1_PORT = Integer.parseInt(config.getProperty("REDIS.SLAVE1.PORT"));
				REDIS_SLAVE2_IP = config.getProperty("REDIS.SLAVE2.IP");
				REDIS_SLAVE2_PORT = Integer.parseInt(config.getProperty("REDIS.SLAVE2.PORT"));
			}
			
			REDIS_POOL_MAXACTIVE = config.getProperty("REDIS_POOL_MAXACTIVE");
			REDIS_POOL_MAXIDLE = config.getProperty("REDIS_POOL_MAXIDLE");
			REDIS_POOL_MAXWAIT = config.getProperty("REDIS_POOL_MAXWAIT");
			REDIS_POOL_TESTONBORROW = config.getProperty("REDIS_POOL_TESTONBORROW");
			REDIS_POOL_TESTONRETURN = config.getProperty("REDIS_POOL_TESTONRETURN");
			
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
