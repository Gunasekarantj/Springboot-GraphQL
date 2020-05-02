package com.techprimers.graphql.service.datafetcher;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techprimers.graphql.model.Book;
import com.techprimers.graphql.repository.BookRepository;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import javassist.NotFoundException;
@Component
public class BookDataFetcher implements DataFetcher<Book>{
	@Autowired
	BookRepository bookRepository;
	 @Override
	    public Book get(DataFetchingEnvironment dataFetchingEnvironment){

	        String isn = dataFetchingEnvironment.getArgument("id");

	        Optional<Book> book=bookRepository.findById(isn);
	        try {
				return book.orElseThrow(
				        () ->  new NotFoundException("Unable to get Account with Code = " + isn)
					    );
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null ;
	 }
}
