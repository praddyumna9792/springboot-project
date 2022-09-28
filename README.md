# springboot-project
# springboot-demo-code
# This project is based on Rest-API and Database developed using springBoot framework.

# Requirements
# For building and running the application you need:
#    1) JDK 8.0
#    2) Maven 3

# How it works:
# The application uses Spring Boot(Web).
# And the code is organised as:
#    1) core is the business model including entities
#    2) application is services for querying the data transfer objects
#    3) infrastructure contains all the implements classes as the technique details

# Darabase
# It uses a H2 in memory database(for easy local test), can be changed easily in the application.properties for any other database.

# Getting Started
# You'll need Java 8 installed
# To test that it works, open a postman at link address: http://localhost:8080/api/departments .

# About the code:
# This project having different layers like:
# 1) project:
#	 This is entry point of project.
 
# 2) application.properties:
#	 This class contains database connectivity code, where it uses H2 database.
#	  (url, driverClassName, username, password, 
#	   hibernate jpa's: sql, ddl.auto, console and path)

# 3) controller:
#	 In this layer we can perform CRUD(create, read, update, delete) operations
#	  as the requirement of the project. It having methods, mapping using annotations
#	  for several operations.
#  It includes:
#	  1)EmployeeController:
#		Using postman we can throw queries as per the request:
#                 { "firstName": "Praddyumna", "lastName": "Baghe", "dob": "1999-10-10", "address": "kothrud", "city": "pune", 
#  		     "department": {"departmentName": "IT", "description": "Information Technology"}, 
#  		     "skills": [{"skillName": "java",  "description": "Java 8"}]
#		  }
	
#	 If we need to perform task on sepecific requirements we created another classes like:
#	  2)DepartmentController:
#		  { "department":{"departmentName": "IT", 
# 	    "description": "Information Technology"}
#		  }
#	  3)SkillController:
#		  { "skills": [{"skillName": "java",  
#		    "description": "Java 8"}
#		  }
#	(We can perform queries by all and specific id )

# 4) model:
#	 Using model class we connecting modules to the database with Employee, Department, Skill classes.
#	 It's using Annotations, and overriden methodes like hashCode, equals.

# 5) repository:
#	 Using repository interface we encapsulating storage, retrival, update, delete operations. 
#	 It uses annotation(@Repository)

# 6) exception:
#	 We Created class Exception, If program throws application it will handle exception.
#	 It will get handled through the code.

# How to run the project:
#  1) download project using link goven below:
#    https://github.com/praddyumna9792/springboot-project.
#  2) import the downloaded project in Eclipse, VS Code(it will automaticallly download dependencies as it needs).
#  3) open the class EmployeeDataApplication and run the project as java application.
#  4) you need a postman application to perform queries, 
#   use the link: http://localhost:8080/api/employee .
 
