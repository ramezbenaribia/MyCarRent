# MyCar project

This project is a small applictaion that represent an online booking system for car renting, named MyCar.

To run this project there is two options

1. We can compile it and run it with javac \*.java and java Main
2. Or we can use maven by runing mvn package and then run the Main file

## For the first Option we can run those commands in the terminal

### To compile the project or our classes we can use this command

```typescript
javac ./src/main/java/com/myCar/*.java
```

### To run the project we can use this command

```typescript
java -cp ./src/main/java com.myCar.Main
```

## For the second Option we can run those commands in the terminal

### To compile the project and build it we can use this command

```typescript
mvn package
```

### To run the project we can use this command

```typescript
java -cp target/myCar-1.0-SNAPSHOT.jar com.myCar.Main
```

## Finally to run the tests for this project we will have to run this command

```typescript
mvn test
```

### To run a single test class like "ValidatorsTest" we can use this command

```typescript
mvn -Dtest=ValidatorsTest  test
```

### To run a single test method test_validateDate_incorrectDate() from the test class ValidatorsTest we can use this command

```typescript
mvn -Dtest=ValidatorsTest#test_validateDate_incorrectDate test
```
