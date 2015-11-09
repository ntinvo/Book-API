package Book;

import org.springframework.data.mongodb.repository.MongoRepository; 
import Book.Book;

public interface BookRepo extends MongoRepository<Book, String> {}