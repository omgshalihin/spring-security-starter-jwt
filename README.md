# Spring Authentication & Authorization With JWT

## Background
- ................
- Under Construction
- ................
![JWT explanation.png](src%2Fmain%2Fresources%2Fpictures%2FJWT%20explanation.png)

## Spring Security Basic Authentication
#### visit [Spring Authentication & Authorization Without JWT](https://github.com/omgshalihin/spring-security-starter)


## Update JWT Token Expiration
inside `JWTService.java` class, modify `MINUTES`

## Retrieve 256_BIT_SECRET
[Encryption Key Generator](https://www.allkeysgenerator.com/random/security-encryption-key-generator.aspx)
- options:
  - 256-bit
  - Hex? Yes
  - How many? 1

## Environment Variables
Create a file named `env.properties` in `src/main/resources `folder
Include and change the following environment variables:
```
DB_USER=<db_user_name>
DB_PWD=<db_user_password>
DB_ENDPOINT=<db_endpoint/cluster>
DB_NAME=<db_name>
JWT_256_BIT_SECRET=<256_BIT_SECRET>
```