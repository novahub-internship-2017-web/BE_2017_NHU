# PROJECT BOOK MANAGEMENT
This project is a small web application using Spring Boot Framework. The application allows to handle books in a library. It should contain five pages, namely Login, Register, Books List (search, order, pagination), Book Details, Book Creation and Book Edition.

* Guest
No need login
View enabled books
* User 
(username: superadmin@gmail.com, password: 123456) 
Required: login
View enabled books & disabled books (created from that user)
Create new book
Edit book
Remove book (created from that user)
Add comments into Book Details

* Admin 
(username: admin@gmail.com, password: 123456 )
Required: login
Can access all pages

*Super Admin 
(username: superadmin@gmail.com, password:123456 )
Required: login
Can access all pages




	
	
## Guide Start Project

* Clone this repository

* Import assignment4.sql (in resources of project )to Database 

* Run project by command : 
1.mvn install clean
2.mvn spring-boot:run
