package com.soebes.code.example.book;

public record ISBN(String isbn) {
  public ISBN {
    isbn = NonBlankString.of(isbn, "ISBN").value();
    if (isbn.length() != 13) {
      throw new IllegalArgumentException("ISBN length must be 13 characters long.");
    }
  }
}
