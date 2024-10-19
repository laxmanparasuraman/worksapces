/* 
   oauth

   Register a user 
   login a user
   allow him to acces the dashboard.

   information at register - firstname, lastname , email , password
   information at login  email, password 

    
   model   - user:{firstname,lastname,emailo,passwor,token}

   controller- 
   
   /register
   
   {
   thing to be be done 
   1 collect all info from frontend -req.body
   2 validate - if all data exist if not send a note
   3 check  if user already exist if yes sont processd
     encrpt the password
   4  save to db and send a key(token)}


   /login
   1 collect all info from frontend -req.body
   2 validate if no info send a note
   3 check if user exists in db
   4 match the passwod - password is already encrpt
   5 create akey for user and send it direct cookie

   /dashboard
   1 check if key exists -valid
   2 allow him to access

   config - database connection
 
   node js process modules

   */