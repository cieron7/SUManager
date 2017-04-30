package net.dqsy.manager.web.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class RedisUtil {
	public static final Log log = LogFactory.getLog(RedisUtil.class.getName());

//	public static Jedis getResource() throws JedisException {
//		Jedis jedis = null;
//		try {
//			jedis = jedisPool.getResource();
//			jedis.select(Integer.parseInt(DB_INDEX));
////            logger.debug("getResource.", jedis);
//		} catch (JedisException e) {
//			logger.warn("getResource.", e);
//			returnBrokenResource(jedis);
//			throw e;
//		}
//		return jedis;
//	}
}
