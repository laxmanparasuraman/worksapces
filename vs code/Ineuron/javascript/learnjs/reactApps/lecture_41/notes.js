/* 
create a database for e commerce

1 admin 
2 user
3 seller
4 products
5 categories
6 inventory
7 orders
8 transaction
9 review

 / user ={
  _id: ObjectId,
  username: String,
  password: String,
  email: String,
  phone: String,
  pincode : String,
  address: String,
  role: String, // admin, user, seller  "my own opional not in lect thi type"
  
  }

/seller ={

 _id: ObjectId,
  sellerName: String,
  email: String,
  phone: String,
  products: [ObjectId], // array of product ids
  password: String,
  gst: String   
}

/category={

 _id: ObjectId,
  name: String,
  products: [ObjectId] // array of product ids
  }

  /product={
  _id: ObjectId,
  name: String,
  price: Number,
  description: String,
  category: ObjectId,
}
*/