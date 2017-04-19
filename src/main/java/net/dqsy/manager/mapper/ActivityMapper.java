package net.dqsy.manager.mapper;


import net.dqsy.manager.pojo.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityMapper {

    List<Activity> findList(@Param("types") List<Integer> types, @Param("start") int start, @Param("limit") int limit);

    Activity findById(@Param("id") long id);

    void save(@Param("activity") Activity activity);
}
