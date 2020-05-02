package com.techprimers.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.graphql.model.Book;

public interface BookRepository extends JpaRepository<Book,String>{

	

	
   
}
