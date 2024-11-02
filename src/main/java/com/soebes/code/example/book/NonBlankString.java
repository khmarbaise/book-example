package com.soebes.code.example.book;

record NonBlankString(String value, String name) {
  NonBlankString {
    if (name == null) {
      throw new IllegalStateException("name is null");
    }
    if (value == null) {
      throw new IllegalArgumentException("%s cannot be null".formatted(name));
    }
    if (value.trim().isBlank() || value.isBlank()) {
      throw new IllegalArgumentException("%s cannot be blank".formatted(name));
    }
  }

  static NonBlankString of(String value, String name) {
    return new NonBlankString(value, name);
  }
}
