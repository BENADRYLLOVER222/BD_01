package service;

import bean.Comment;

import java.util.List;

public interface CommentService {
    /**
     * Добавить новый комментарий.
     *
     * @param comment Новый комментарий для добавления.
     */
    void addComment(Comment comment);

    /**
     * Удалить комментарий по его идентификатору.
     *
     * @param commentId Идентификатор комментария, который нужно удалить.
     * @param userId Идентификатор пользователя, который пытается удалить комментарий (для проверки прав).
     */
    void deleteComment(int commentId, int userId);

    /**
     * Отредактировать существующий комментарий.
     *
     * @param commentId Идентификатор комментария, который нужно отредактировать.
     * @param userId Идентификатор пользователя, который пытается отредактировать комментарий (для проверки прав).
     * @param newText Новый текст комментария.
     */
    void editComment(int commentId, int userId, String newText);

    /**
     * Получить список комментариев для определенной новости.
     *
     * @param newsId Идентификатор новости, для которой нужно получить комментарии.
     * @return Список комментариев.
     */
    List<Comment> getCommentsForNews(int newsId);

    /**
     * Получить комментарий по его идентификатору.
     *
     * @param commentId Идентификатор комментария, который нужно получить.
     * @return Комментарий с указанным идентификатором или `null`, если не найден.
     */
    Comment getCommentById(int commentId);
}