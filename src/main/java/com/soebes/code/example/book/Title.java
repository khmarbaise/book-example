package com.soebes.code.example.book;

public record Title(String title) {
  public Title {
    title = NonBlankString.of(title, "title").value();
  }
}
