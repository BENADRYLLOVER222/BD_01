package service.impl;

import bean.Comment;
import bean.News;
import service.CommentService;
import service.InfoService;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void deleteComment(int commentId, int userId) {

    }

    @Override
    public void editComment(int commentId, int userId, String newText) {

    }

    @Override
    public List<Comment> getCommentsForNews(int newsId) {
        return List.of();
    }

    @Override
    public Comment getCommentById(int commentId) {
        return null;
    }
}
