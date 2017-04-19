package net.dqsy.manager.server;


import net.dqsy.manager.pojo.Activity;
import net.dqsy.manager.service.IActivityService;
import net.dqsy.manager.test.base.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class ActivityServcieTest extends BaseTest {
    @Autowired
    private IActivityService activityService;

    @Test
    public void findListTest() {
        List<Activity> list = activityService.findList(Arrays.asList(1), 0, 0);
        for (Activity activity : list) {
            System.out.println(activity.getTitle());
        }
    }
    @Test
    public void findById(){
        Activity activity = activityService.findById(1L);
        System.out.println(activity.getId());
    }
}
