package net.dqsy.manager.test.base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@Rollback
//@Transactional
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/applicationContext.xml"})
public class BaseTest {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void InitTest() {
        System.out.println("init done...");
    }
}
