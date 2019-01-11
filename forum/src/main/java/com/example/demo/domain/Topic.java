package com.example.demo.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Topic
 * @Description TODO
 * @Auther ydc
 * @Date 2019/1/7 20:12
 * @Version 1.0
 **/
@Entity
@Table(name = "topic")
public class Topic extends BaseDomain implements Serializable {
    public static final int hot_TOPIC = 1; //热门主题

    public static final int NOT_hot_TOPIC = 0; //普通主题

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private int topicId; //帖子id

    @Column(name = "board_id")
    private  int BoardId; //所属版块id

    @Column(name = "user_id")
    private int userId;

    @Column(name = "topic_title")
    private String topicTitle; //帖子标题

    @Column(name = "create_time")
    private Date createTime;  //创建时间

    @Column(name = "last_post")
    private Date lastPost; //最后回复时间

    @Column(name = "topic_views")
    private  int topicViews; //浏览次数

    @Column(name = "topic_replies")
    private  int topicReplies; // 回复数量

    @Column(name = "hot")
    private  int hot; //是否是热门帖子

    @Column(name = "background_id")
    private  int backGroundId;  //背景图片id


    public int getTopicId() {
        return topicId;
    }

    public int getBoardId() {
        return BoardId;
    }



    public String getTopicTitle() {
        return topicTitle;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastPost() {
        return lastPost;
    }

    public int getTopicViews() {
        return topicViews;
    }

    public int getTopicReplies() {
        return topicReplies;
    }

    public int getHot() {
        return hot;
    }

    public int getBackGroundId() {
        return backGroundId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    public void setBoardId(int boardId) {
        BoardId = boardId;
    }


    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setLastPost(Date lastPost) {
        this.lastPost = lastPost;
    }

    public void setTopicViews(int topicViews) {
        this.topicViews = topicViews;
    }

    public void setTopicReplies(int topicReplies) {
        this.topicReplies = topicReplies;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public void setBackGroundId(int backGroundId) {
        this.backGroundId = backGroundId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Topic(int boardId, int userId, String topicTitle, Date createTime, Date lastPost, int topicViews, int topicReplies, int hot, int backGroundId) {
        BoardId = boardId;
        this.userId = userId;
        this.topicTitle = topicTitle;
        this.createTime = createTime;
        this.lastPost = lastPost;
        this.topicViews = topicViews;
        this.topicReplies = topicReplies;
        this.hot = hot;
        this.backGroundId = backGroundId;
    }

    public Topic() {
    }
}
