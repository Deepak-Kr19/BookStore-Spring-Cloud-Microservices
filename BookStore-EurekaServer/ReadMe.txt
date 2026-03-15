Test 1 — Create Book

Open Postman

Method: POST

URL  http://localhost:8090/api/books

Body → raw JSON

{
"title":"Clean Code",
"author":"Robert C Martin",
"isbn":"9780132350884",
"price":500,
"quantity":20,
"category":"Programming"
}

Click Send

Test 2 — Get All Books

Method: GET

URL  http://localhost:8090/api/books

Response:

[
 {
  "id":1,
  "title":"Clean Code",
  "author":"Robert C Martin",
  "price":500
 }
]

Test 3 — Get Book By ID

Method: GET

URL    http://localhost:8090/api/books/1


Test 4 — Update Book

Method: PUT

URL    http://localhost:8090/api/books/1

Body

{
"title":"Clean Code Updated",
"author":"Robert C Martin",
"isbn":"9780132350884",
"price":550,
"quantity":18,
"category":"Programming"
}


Test 5 — Place Order (Most Important)

Method: POST

URL   http://localhost:8090/api/orders

Body

{
"bookId":1,
"customerName":"Alice",
"quantity":2
}


Test 6 — Get All Orders

Method: GET

URL   http://localhost:8090/api/orders


Test 7 — Update Order Status

Method: PUT

URL   http://localhost:8090/api/orders/1

Body

{
"status":"SHIPPED"
}


Test 8 — Delete Order

Method: DELETE

URL   http://localhost:8090/api/orders/1


