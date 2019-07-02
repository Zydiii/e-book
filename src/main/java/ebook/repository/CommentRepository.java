package ebook.repository;

import java.util.List;

import ebook.entity.Comment;
import ebook.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;


public interface CommentRepository extends MongoRepository<Comment, String> {

    @Query("{'book_id': ?0}")
    public List<Comment> findByBookId(int book_id);

}