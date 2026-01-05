# SPRINGBOOT MONGODB PROJECT

## 🌐 What Are HTTP Status Codes?

HTTP status codes are 3‑digit numbers returned by a server to tell the client what happened with the request.

They are grouped into categories:

Category	Meaning
1xx	Informational
2xx	Success
3xx	Redirection
4xx	Client error
5xx	Server error

✅ Most Common HTTP Status Codes (You’ll Use These Daily)

## 2xx – Success

200 OK  
Request succeeded. Used for GET, PUT, DELETE.

201 Created  
A new resource was created. Used for POST.

204 No Content  
Request succeeded but no response body. Often used for DELETE.

## 4xx – Client Errors

400 Bad Request  
Client sent invalid data (wrong JSON, missing fields, validation errors).

401 Unauthorized  
Authentication required (user not logged in).

403 Forbidden  
User is logged in but not allowed to access the resource.

404 Not Found  
Resource does not exist (wrong ID).

409 Conflict  
Duplicate data or conflicting request.

## 5xx – Server Errors

500 Internal Server Error  
Something went wrong on the server.

503 Service Unavailable  
Server is down or overloaded.

