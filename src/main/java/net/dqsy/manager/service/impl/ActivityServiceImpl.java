package net.dqsy.manager.service.impl;

import net.dqsy.manager.mapper.ActivityMapper;
import net.dqsy.manager.pojo.Activity;
import net.dqsy.manager.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements IActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public List<Activity> findList(List<Integer> types, int start, int limit) {

        return activityMapper.findList(types, (start - 1) * limit, limit);
    }

    @Override
    public Activity findById(long id) {
        return activityMapper.findById(id);
    }

    @Override
    public void save(Activity activity) {

        activityMapper.save(activity);

    }

    @Override
    public int getTotalCount(List<Integer> types) {

        return activityMapper.getTotalCount(types);
    }
}
