package net.dqsy.manager.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

@Service
public class MessageHandler implements ApplicationListener<ContextRefreshedEvent>{
    public static Logger logger = LoggerFactory.getLogger(MessageHandler.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //logger.info("---------------init-------------------");
        //ShardedJedis jredis = RedisUtil.getShardedJedis();


    }
}
