package Book;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/* @RequestMapping spring annotation to map URLs onto an entire
class or a particular handler method */

/* @PathVariable spring annotation on a method argument to bind
it to the value of a URI template variable */

/* @RequestBody which can be used to convert your incoming Json
request to Model object. You just need to add @RequestBody
annotation with your controller method and Spring will automatically
convert all incoming Json request (application/json) into Model
object defined in controller method. */

/* @RestController annotation marks this class as a controller
where every method returns a domain object/pojo instead of a view. */

@RestController
@RequestMapping("/books")
public class Controller {
	
	/* Let Spring auto-wire other beans into classes */
	@Autowired
	private BookRepo repo;

	@RequestMapping(method = RequestMethod.GET)
	public List<Book> getAll() {
		return repo.findAll();
	}

	@RequestMapping(method=RequestMethod.POST)
	public Book create(@RequestBody Book book) {
    	return repo.save(book);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public void delete(@PathVariable String id) {
    	repo.delete(id);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public Book update(@PathVariable String id, @RequestBody Book book) {
		Book tempBook = repo.findOne(id);
		tempBook.setAuthor(book.getAuthor());
		tempBook.setISBN(book.getISBN());
		return repo.save(tempBook);
	}

}