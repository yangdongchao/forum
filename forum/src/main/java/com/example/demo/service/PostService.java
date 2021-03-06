package com.example.demo.service;

import com.example.demo.domain.Post;
import org.springframework.data.domain.Page;

/**
 * @ClassName PostServiceImp
 * @Description TODO
 * @Auther ydc
 * @Date 2019/1/10 14:03
 * @Version 1.0
 **/
public interface PostService {
    void resetPostTitle(String newTitle,int id);
    void resetPostText(String newText,int id);
    void deletePostById(int id);
    Page<Post> getPostPage(int pageNum,int pageSize,int topicId);
}
