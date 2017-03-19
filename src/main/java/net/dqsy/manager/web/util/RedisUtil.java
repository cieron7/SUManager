package net.dqsy.manager.web.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisPubSub;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Service
public class RedisUtil {

    public static Logger logger = LoggerFactory.getLogger(RedisUtil.class);
    public static InputStream in = null;
    public static Properties config = new Properties();

    /**
     * 用户订阅频道的Jedis对象
     */

    public static String REDIS_HOST = "";
    public static int REDIS_PORT = 0;
    public static String REDIS_PASSWORD = "";
    public static int REDIS_DATABASE = 0;

    static {
        try {
            File file = new File(System.getProperty("catalina.home") + "/conf/redis.properties");
            if (file.exists()) {
                in = new FileInputStream(file);
            } else {

                in = CommonConfig.class.getClassLoader().getResourceAsStream("redis.properties");
            }
            config.load(in);

            REDIS_HOST = config.getProperty("REDIS_HOST").trim();
            REDIS_PORT = Integer.parseInt(config.getProperty("REDIS_PORT").trim());
            REDIS_PASSWORD = config.getProperty("REDIS_PASSWORD").trim();
            REDIS_DATABASE = Integer.parseInt(config.getProperty("REDIS_DATABASE").trim());

            poolConfig = initPoolConfig();
            pool = getJedisPool();
            logger.info("redis 初始化完成");

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

    public static Jedis subscribeClient = null;

    private static JedisPool pool = null;

    private static JedisPoolConfig poolConfig = null;

    public static JedisPoolConfig initPoolConfig() {
        if (poolConfig == null) {
            try {
                poolConfig = new JedisPoolConfig();
                poolConfig.setMaxTotal(-1);
                poolConfig.setMaxWaitMillis(1000 * 100);
                poolConfig.setTestOnBorrow(true);
                logger.info("jedisPoolConfig配置成功");
            } catch (Exception e) {
                e.printStackTrace();
                logger.error("jedisPoolConfig配置失败");
                // mailService.sendBug("jedisPoolConfig配置失败");
            }
        }
        return poolConfig;
    }

    public static JedisPool getJedisPool() {
        if (pool == null) {
            try {
                pool = new JedisPool(initPoolConfig(), REDIS_HOST, REDIS_PORT, 2000, REDIS_PASSWORD, REDIS_DATABASE);
                logger.info("jedisPool初始化成功");
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                logger.error("jedisPool初始化失败");
                // mailService.sendBug("jedisPool初始化失败");
            }
        }
        return pool;
    }

    public static Jedis getJedisModel() {
        if (pool == null)
            pool = getJedisPool();
        Jedis jedis = pool.getResource();
        if (null == jedis) {
            logger.error("jedis获取实例失败");
            // mailService.sendBug("jedis获取实例失败");
            return null;
        }
        return jedis;
    }


    /**
     * @param message: 消息体
     * @param channel  订阅的频道
     * @author: YangNan(杨楠)
     * @date: 2014-7-29 上午10:45:44
     * @Title: publish
     * @Description: 向redis频道发布消息
     * @return: void    返回类型
     * @throws:
     */
    public static void publish(String channel, String message) {
        Jedis w = null;
        try {
            w = getJedisModel();
            w.publish(channel, message);
        } catch (Exception e) {
            logger.error("", e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }

    }

    /**
     * 缓存字符串，
     *
     * @param key
     * @param value
     * @param expireInSecond <=0 表示不过期
     */
    public static void set(String key, String value, int expireInSecond) {

        Jedis w = null;
        try {
            w = getJedisModel();
            if (expireInSecond > 0) {
                w.setex(key, expireInSecond, value);
            } else {
                w.set(key, value);
            }
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
    }

    /**
     * 获取缓存,返回类型为字符串
     *
     * @param key
     * @return
     */
    public static String get(String key) {
        Jedis r = null;
        String ret = null;

        try {
            r = getJedisModel();
            ret = r.get(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
        } finally {
            pool.returnResource(r);
        }
        return ret;
    }


    public static List<String> mget(String... keys) {
        Jedis r = null;
        List<String> ret = null;

        try {
            r = getJedisModel();
            ret = r.mget(keys);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
            ret = new ArrayList<String>();
        } finally {
            pool.returnResource(r);
        }
        return ret;
    }

    /**
     * 缓存字节数组
     *
     * @param key
     * @param value
     * @param expireInSecond
     */
    public static void set(byte[] key, byte[] value, int expireInSecond) {
        Jedis w = null;
        try {
            w = getJedisModel();
            if (expireInSecond > 0) {
                w.setex(key, expireInSecond, value);
            } else {
                w.set(key, value);
            }
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }

    }


    /**
     * 获取缓存，返回类型为byte[]
     *
     * @param key
     * @return
     */
    public static byte[] get(byte[] key) {
        Jedis r = null;
        byte[] ret = null;
        JedisPool rPool = null;

        try {
            r = getJedisModel();
            ret = r.get(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
        } finally {
            pool.returnResource(r);
        }
        return ret;
    }

    /**
     * 自增
     *
     * @param key
     * @return
     */
    public  static Long incr(String key) {
        Jedis w = null;
        Long ret = null;
        try {
            w = getJedisModel();
            ret = w.incr(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
        return ret;
    }

    /**
     * 自增
     *
     * @param key
     * @return
     */
    public static Long incr(byte[] key) {
        Jedis w = null;
        Long ret = null;
        try {
            w = getJedisModel();
            ret = w.incr(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
        return ret;
    }

    public static void del(byte[] key) {
        Jedis j = null;
        try {
            j = getJedisModel();
            j.del(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(j);
        } finally {
            pool.returnResource(j);
        }
    }

    public static void del(String... key) {
        Jedis j = null;
        try {
            j = getJedisModel();
            j.del(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(j);
        } finally {
            pool.returnResource(j);
        }
    }

    /**
     * 存hashmap
     *
     * @param key
     * @param value
     */
    public static void hmset(byte[] key, Map<byte[], byte[]> value) {
        Jedis w = null;
        try {
            w = getJedisModel();
            w.hmset(key, value);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
    }

    /**
     * @param key
     * @param field
     * @param value
     * @return If the field already exists, and the HSET just produced an update
     * of the value, 0 is returned, otherwise if a new field is created
     * 1 is returned.
     */
    public static Long hset(final String key, final String field, final String value) {
        Jedis w = null;
        try {
            w = getJedisModel();
            return w.hset(key, field, value);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
            return 0L;
        } finally {
            pool.returnResource(w);
        }
    }

    /**
     * 取hashmap
     *
     * @param key
     * @return
     */
    public static Map<byte[], byte[]> hmget(byte[] key) {
        Jedis r = null;
        Map<byte[], byte[]> ret = null;
        JedisPool rPool = null;

        try {
            r = getJedisModel();
            r.hgetAll(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
        } finally {
            pool.returnResource(r);
        }

        return ret;
    }


    /**
     * 向集合中添加成员
     *
     * @param key
     * @param members
     * @return
     */
    public static Long sadd(String key, String... members) {
        Jedis w = null;
        try {
            w = getJedisModel();
            return w.sadd(key, members);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
            return null;
        } finally {
            pool.returnResource(w);
        }
    }




    /**
     * 删除集合中的成员
     *
     * @param key
     * @param members
     * @return
     */
    public static Long srem(String key, String... members) {
        Jedis w = null;
        try {
            w = getJedisModel();
            return w.srem(key, members);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
            return null;
        } finally {
            pool.returnResource(w);
        }
    }

    /**
     * 获取集合元素数量
     *
     * @param key
     * @return
     */
    public static Long scard(String key) {
        Jedis r = null;
        try {
            r = getJedisModel();
            return r.scard(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
            return null;
        } finally {
            pool.returnResource(r);
        }
    }

    public static void subscribe(JedisPubSub jedisPubSub, String channel) throws Exception {
        subscribeClient = null;
        try {
            Jedis jedis = getJedisModel();
            Client c = jedis.getClient();
            subscribeClient = new Jedis(c.getHost(), c.getPort());
            pool.returnResource(jedis);
            subscribeClient.auth(REDIS_PASSWORD);
            subscribeClient.subscribe(jedisPubSub, channel);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                subscribeClient.quit();
                subscribeClient.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放订阅对象
     */
    public static void unsubscribe() {
        try {
            subscribeClient.quit();
            subscribeClient.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置过期时间
     *
     * @param key
     * @param seconds
     * @return
     */
    public static Long expire(String key, int seconds) {
        Jedis w = null;
        Long ret = null;
        try {
            w = getJedisModel();
            ret = w.expire(key, seconds);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
        return ret;
    }

    /**
     * 链表方式存储  尾插入
     *
     * @param key
     * @param strings
     * @return
     */
    public static Long rpush(final String key, final String... strings) {
        Jedis w = null;
        Long ret = null;
        try {
            w = getJedisModel();
            ret = w.rpush(key, strings);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
        return ret;
    }

    /**
     * 链表方式存储  头删除
     *
     * @param key
     * @return
     */
    public static String lpop(final String key) {
        Jedis w = null;
        String ret = null;
        try {
            w = getJedisModel();
            ret = w.lpop(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
        return ret;
    }

    /**
     * 在某一个时间过期
     *
     * @param key
     * @param unixTime
     * @return
     */
    public static Long expireAt(String key, long unixTime) {
        Jedis w = null;
        Long ret = null;
        try {
            w = getJedisModel();
            ret = w.expireAt(key, unixTime);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(w);
        } finally {
            pool.returnResource(w);
        }
        return ret;
    }

    /**
     * 返回hash表中key的所有key,value
     *
     * @param key
     * @return
     */
    public static Map<String, String> hgetAll(String key) {

        Jedis r = null;
        Map<String, String> ret = null;
        try {
            r = getJedisModel();
            ret = r.hgetAll(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
        } finally {
            pool.returnResource(r);
        }
        return ret;
    }


    /**
     * 返回所有的key
     *
     * @param key
     * @return
     */
    public static Set<String> keys(String key) {
        Jedis r = null;
        Set<String> ret = null;
        try {
            r = getJedisModel();
            ret = r.keys(key);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
        } finally {
            pool.returnResource(r);
        }
        return ret;
    }

    /**
     * @param key
     * @Title: list
     * @Description: 获取redis中list链表的所有值
     * @return: (参数说明)
     * @return: List<JSONObject>    返回类型
     * @throws:
     */
    public static List<String> list(String key) {
        Jedis r = null;
        List<String> ret = null;
        try {
            r = getJedisModel();
            ret = r.lrange(key, 0, -1);
        } catch (Exception e) {
            logger.error(null, e);
            pool.returnBrokenResource(r);
        } finally {
            pool.returnResource(r);
        }
        return ret;
    }
}
