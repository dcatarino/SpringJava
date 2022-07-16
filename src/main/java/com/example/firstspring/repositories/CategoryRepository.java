package com.example.firstspring.repositories;
import com.example.firstspring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//tipo da entidade e tipo da key no JpaRepoitory<>

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
