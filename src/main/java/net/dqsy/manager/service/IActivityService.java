package net.dqsy.manager.service;


import net.dqsy.manager.pojo.Activity;

import java.util.List;

public interface IActivityService {

    List<Activity> findList(List<Integer> types, int start, int limit);

    Activity findById(long id);

    void save(Activity activity);

    int getTotalCount(List<Integer> types);

    void add(Activity activity);

    void deleteById(long activityId);
}
