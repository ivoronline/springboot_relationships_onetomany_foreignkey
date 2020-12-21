package com.ivoronline.springboot_relationships_onetomany_foreignkey.repositories;

import com.ivoronline.springboot_relationships_onetomany_foreignkey.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> { }
