package net.dqsy.manager.listener;

import net.dqsy.manager.controller.LoginController;
import net.dqsy.manager.web.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;
import redis.clients.jedis.ShardedJedis;

@Service
public class MessageHandler implements ApplicationListener<ContextRefreshedEvent>{
    public static Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        logger.info("---------------init-------------------");
        ShardedJedis jredis = RedisUtil.getShardedJedis();


    }
}
