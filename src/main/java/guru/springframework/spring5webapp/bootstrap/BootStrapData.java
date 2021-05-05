package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in Bootstrap");

        Publisher publisher1 = new Publisher("ABC Publisher","ABC Street","HK", "HK","00000");
        publisherRepository.save(publisher1);
        System.out.println("Number of Publisher :"+publisherRepository.count());

        Author kenny = new Author("Kenny","Chan");
        Book book = new Book("Harry Potter","ABC123");
        kenny.getBooks().add(book);
        book.getAuthors().add(kenny);

        authorRepository.save(kenny);
        bookRepository.save(book);

        Author jkRowling = new Author("JK","Rowling");
        Book hogwarts = new Book("Hogwarts","721831101");
        jkRowling.getBooks().add(hogwarts);
        hogwarts.getAuthors().add(jkRowling);

        authorRepository.save(jkRowling);
        bookRepository.save(hogwarts);


        System.out.println("Number of books :"+bookRepository.count());
    }
}
