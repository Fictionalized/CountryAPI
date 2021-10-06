# Java Country API

## Usage
Get a specific country
```java
final Request request = new Request("country");
final Country country = request.getCountry();
```

Get all countries
```java
final Request request = new Request();
final Country[] countries = request.getCountries();
```

Example of country usage, get the capital of a country
```java
final Request request = new Request();
final Country country = request.getCountry();
final String capital = country.getCapital();
```