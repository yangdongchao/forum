package com.example.demo.dao;

import com.example.demo.domain.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface TopicDao extends JpaRepository<Topic,Integer> {
    /**
     * 更新话题标题
     * @param title
     * @param id
     */
    @Modifying
    @Query(value = "update Topic as T set T.topicTitle=:title where T.topicId=:id")
    void updateTitleById(@Param("title") String title,@Param("id") int id);

    /**
     * 更新是否是热门话题
     * @param hot
     * @param id
     */
    @Modifying
    @Query(value = "update Topic as T set T.hot=:hot where T.topicId=:id")
    void updateHotById(@Param("hot") int hot,@Param("id") int id);


    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value = "update Topic as T set T.backGroundId=:pictureId where T.topicId=:id")
    void updateBackGroundById(@Param("pictureId") int pictureId,@Param("id") int id);


    Topic findByTopicId(int id);



}
