//How to running this project.
1. You can install IDE like eclipse, intellij dll
2. import this project to IDE
3. in folder src/main/resources , in file application.properties you can set properties spring boot in here, in file i just set port
4. in package com.example.demo.controller i give example rest-api method get & post + how get data from mysql then you can mapping data to return in front
5. you can run main class
5. for check return rest you can use app like postman 
	example : 1. choose method get , then set host in postman "localhost:12345/simpleRest/simpleReturnRestGETnotParams"
			  2. choose method post , then set host in postman "localhost:12345/simpleRest/simpleReturnRestPOST" , set body in postman like this {"params":"tampilkan data return rest"}
			  	params is parameter will get of the rest-api.
