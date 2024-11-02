package com.soebes.code.example.book;

public record Author(String name){
  public Author {
    name = NonBlankString.of(name, "author").value();
  }
}
