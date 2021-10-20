# graphql
Demo project for Spring Boot with GraphQL


## Examples

### Query

- Find All Books

```graphql
query {
 findAllBooks {
   id
   title
 }
}
```

```graphql
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

```graphql
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

```graphql
mutation {
  updateBookPageCount(pageCount: 1344, id: 2) {
    id pageCount
  }
}
```

- Delete a book

```graphql
mutation {
  deleteBook(id:2)
}
```
