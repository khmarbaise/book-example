package com.soebes.code.example.book;

import java.util.Set;

import static java.util.Objects.requireNonNull;

public record Book(Title title, ISBN isbn, Set<Author> authors) {
  public Book {
    requireNonNull(title, "title is not allowed to be null.");
    requireNonNull(isbn, "isbn is not allowed to be null.");
    requireNonNull(authors, "authors is not allowed to be null.");
    if (authors.isEmpty()) {
      throw new IllegalArgumentException("Authors cannot be empty");
    }
    authors = Set.copyOf(authors);
  }
}
