package ebook.repository;

import java.util.List;

import ebook.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ImageRepository extends MongoRepository<Image, String> {
    @Query("{ 'firstName' : ?0 }")
    public Image findByFirstName(String firstName);

    @Query("{ 'lastName' : ?0 }")
    public List<Image> findByLastName(String lastName);

    @Query("{ 'lastName' : ?0 }")
    public List<Image> findImageById(String lastName);


}