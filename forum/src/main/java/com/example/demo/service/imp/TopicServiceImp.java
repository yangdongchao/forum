package com.example.demo.service.imp;

import com.example.demo.dao.PostDao;
import com.example.demo.dao.TopicDao;
import com.example.demo.domain.Post;
import com.example.demo.domain.Topic;
import com.example.demo.service.TopicService;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @ClassName TopicServiceImp
 * @Description TODO
 * @Auther ydc
 * @Date 2019/1/8 9:48
 * @Version 1.0
 **/
@Transactional
@Service
public class TopicServiceImp implements TopicService {

    private TopicDao topicDao;

    private PostDao postDao;

    /**
     *  删除话题，先删除话题下面的所有帖子，再删除话题
     * @param id
     */
    @Override
    public void deleteTopic(int id){
        List<Post> posts = postDao.findByTopicId(id);
        for(Post post: posts){
            postDao.deleteById(post.getPostId());
        }
        postDao.flush();
        topicDao.deleteById(id);
        topicDao.flush();
    }

    /**
     * 设置热门话题
     * @param hot
     * @param id
     */

    @Override
    public void resetTopicHot(int hot,int id) {
           topicDao.updateHotById(hot,id);
    }

    /**
     * 更换话题背景
     * @param pictureId
     * @param id
     */
    @Override
    public void resetTopicBackGroud(int pictureId, int id) {
        topicDao.updateBackGroundById(pictureId,id);
    }

    /**
     * 修改话题标题
     * @param string
     * @param id
     */
    @Override
    public void resetTopicTitle(String string, int id) {
        topicDao.updateTitleById(string,id);
    }

    @Autowired
    public void setTopicDao(TopicDao topicDao) {
        this.topicDao = topicDao;
    }

    @Autowired
    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
