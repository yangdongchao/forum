package com.example.demo.service;

import com.example.demo.domain.Topic;

public interface TopicService {
    void deleteTopic(int id);//删除话题
    void resetTopicHot(int hot,int id);//修改话题


    void resetTopicTitle(String string,int id);

    void resetTopicBackGroud(int pictureId,int id);

}
