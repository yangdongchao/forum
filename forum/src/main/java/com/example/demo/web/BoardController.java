package com.example.demo.web;

import com.example.demo.domain.Board;
import com.example.demo.service.imp.BoardServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @ClassName BoardController
 * @Description TODO
 * @Auther ydc
 * @Date 2019/1/12 18:51
 * @Version 1.0
 **/
@RestController
public class BoardController extends BaseController {
    private BoardServiceImp boardServiceImp;

    @Autowired
    public void setBoardServiceImp(BoardServiceImp boardServiceImp) {
        this.boardServiceImp = boardServiceImp;
    }

    public ModelAndView index(){
            ModelAndView mv  = new ModelAndView();
            mv.setViewName("index");
            Page<Board> boards = boardServiceImp.getBoardPage(1,10);
            mv.addObject("boards",boards);
            return  mv;
        }
}
