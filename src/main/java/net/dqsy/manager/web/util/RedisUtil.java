package net.dqsy.manager.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * RedisUtil 
 * 
 * @author yjY
 * @version 1.0.0 RedisUtil.java 2017-3-2 下午1:43:08
 */
public class RedisUtil {
	public static final Log log = LogFactory.getLog(RedisUtil.class.getName());
	
	/** Singleton */
	private static RedisUtil instance = null;
	private static ShardedJedisPool shardedJedisPool;// sharded connection pool

	/**
	 * init sharded pool
	 */
	static{
		// config
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxIdle(5);
		config.setTestOnBorrow(true);
		// slave
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		JedisShardInfo jedisInfo = new JedisShardInfo(RedisConfig.REDIS_MASTER_IP, RedisConfig.REDIS_MASTER_PORT, "master");
		jedisInfo.setPassword(RedisConfig.REDIS_COMMON_PASSWORD);
		shards.add(jedisInfo);
		if(RedisConfig.REDIS_SHARDED){
			shards.add(new JedisShardInfo(RedisConfig.REDIS_SLAVE0_IP, RedisConfig.REDIS_SLAVE0_PORT,"slave0"));
			shards.add(new JedisShardInfo(RedisConfig.REDIS_SLAVE1_IP, RedisConfig.REDIS_SLAVE1_PORT,"slave1"));
			shards.add(new JedisShardInfo(RedisConfig.REDIS_SLAVE2_IP, RedisConfig.REDIS_SLAVE2_PORT,"slave2"));
		}
		// construct
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}
	
	/** Singleton */
	public static RedisUtil getInstance() {
		if (instance == null) {
			synchronized (RedisUtil.class) {
				if (instance == null) {
					instance = new RedisUtil();
				}
			}
		}
		return instance;
	}
	
	public static synchronized ShardedJedis getShardedJedis() {
		try {
			if (shardedJedisPool != null) {
				return shardedJedisPool.getResource();
			} else {
				return null;
			}
		} catch (Exception e) {
			log.info("Connection Exceptions !");
			return null;
		}
	}
}
