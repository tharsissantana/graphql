# graphql
Demo project for Spring Boot with GraphQL


## Examples

### Query

- Find All Books

```
query {
 findAllBooks {
   id
   title
 }
}
```

```
query {
  findAllBooks {
    id
    isbn
    title
    pageCount
    author {
      firstName
      lastName
    }
  }
}
```

### Mutation

-  Create a new book

```
mutation {
  newBook(
    title: "Java: The Complete Reference, Tenth Edition",
    isbn: "1259589331",
    author: 1) {
      id title
  }
}
```

- Update the page count of a book

```
mutation {
  updateBookPageCount(pageCount: 1344, id: 2) {
    id pageCount
  }
}
```

- Delete a book

```
mutation {
  deleteBook(id:2)
}
```
