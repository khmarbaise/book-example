package com.soebes.code.example.book;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class BookTest {

  @Test
  void createABook() {
    var book = new Book(
        new Title("The first Book"),
        new ISBN("99921-58-10-7"),
        Set.of(new Author("Stephen King"))
    );
    System.out.println("book = " + book);
  }

  @Test
  void createABookExpectingToFailBecauseTitleNull() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Book(
        new Title(null),
        new ISBN("99921-58-10-7"),
        Set.of(new Author("Stephen King"))
    )).withMessage("title cannot be null");
  }

  @Test
  void createABookExpectingToFailBecauseTitleEmpty() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Book(
        new Title(""),
        new ISBN("99921-58-10-7"),
        Set.of(new Author("Stephen King"))
    )).withMessage("title cannot be blank");
  }

  @Test
  void createABookExpectingToFailBecauseISBNNull() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Book(
        new Title("The first Book"),
        new ISBN(null),
        Set.of(new Author("Stephen King"))
    )).withMessage("ISBN cannot be null");
  }

  @Test
  void createABookExpectingToFailBecauseISBNIsNotLongEnough() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Book(
        new Title("The first Book"),
        new ISBN("12345"),
        Set.of(new Author("name"))
    )).withMessage("ISBN length must be 13 characters long.");
  }

  @Test
  void createABookExpectingToFailBecauseAuthorIsNull() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Book(
        new Title("The first Book"),
        new ISBN("99921-58-10-7"),
        Set.of(new Author(null))
    )).withMessage("author cannot be null");
  }

  @Test
  void createABookExpectingToFailBecauseAuthorsIsEmpty() {
    assertThatIllegalArgumentException().isThrownBy(() -> new Book(
        new Title("The first Book"),
        new ISBN("99921-58-10-7"),
        Set.of()
    )).withMessage("Authors cannot be empty");
  }

  @Test
  void createABookExpectingToFailBecauseAuthorsIsNull() {
    assertThatNullPointerException().isThrownBy(() -> new Book(
        new Title("The first Book"),
        new ISBN("99921-58-10-7"),
        null
    )).withMessage("authors is not allowed to be null.");
  }
}
