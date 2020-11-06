# JDBC Demo

## Setup

In order to run this project you need to create your own `Config.java` class inside of the `src/main/java` folder.

Template:

```java
class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/database_name?serverTimezone=UTC&useSSL=false";
    }
    public String getUser() {
        return "someuser";
    }
    public String getPassword() {
        return "strongpassword";
    }
}
```
