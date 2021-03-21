# TQS Lab 1 - Unit Testing with JUnit 5

## 1.1
Project imported based on the maven starter project.

### Some important annotations:
* @Test -> Marks the method as a test;
* @DisplayName -> Sets the name of the test;
* @BeforeEach -> Method is executed before each test;
* @AfterEach -> Method is executed after each test;
* @Disabled -> Disable a test.

### Tests implemented:
1. isEmptyOnInit -> Verify that a stack is empty after initialization;
2. sizeOnInit -> Verify that a stack has size 0 after initialization;
3. push -> Verify that a stack isn't empty after n pushes and that its size is n;
4. push_pop -> Verify that a pop after a push, correctly returns the element that was pushed;
5. push_peek -> Verify that a peek after a push, correctly returns the element that was pushed and the size remains the same;
6. n_push_pop -> Verify that n pops after n pushes results in a stack with size 0;
7. pop_empty -> Verify that popping from an empty stack throws an NoSuchElementException;
8. peek_empty -> Verify that peeking from an empty stack throws an NoSuchElementException;
9. push_bounded -> Verify that pushing to a full bounded stack, throws an IllegalStateException.

## 2a
In order to fix the testFormat error, i changed the line corresponding to the star string formation so that each star occupied 3 places and added an append at the end to close the square brackets.
Implemented the testConstructorFromBadArrays test logic to check if an IllegalArgumentException was thrown when instantiating Dip's with the wrong count of numbers, and the wrong count of stars.

## 2b

### Added the following tests:

1. testAddDuplicate -> In order to confirm tht an IllegalArgumentException was thrown when adding duplicate elements to sets through the multiple ways of adding said elements (adding as an array, as a single element as using the fromArray method).
2. testEquals -> Verify that 2 equal sets are considered equal.

## 2c
Added 4 constants, for max count of stars and numbers, and the maximum value that each star or number can be.

- Note:
 - "Magic Numbers" are numbers that have meaning, they should be associated to a constant instead of being explicitly written throughout the code.

## 2d
mvn test -> mvn jacoco:report -> target/site/jacoco

### Results:
![Alt text](Resources/overall_coverage.png?raw=true "Overall Results")

From the picture above we can verify each package's coverage.
The euromillions package has 79% coverage over instructions and 80% over branches (coverage over if and switch statements).

To further inspect the coverage we can click on each package, i will be examining the euromillions package.
![Alt text](Resources/euromillions_coverage.png?raw=true "Euromillions Coverage")

According to the picture above, the EuromillionsDraw class is almost completely covered, but the Dip and CuponEuromillions have a bit less coverage.
If we click on each individual class we can further inspect it, seeing each method's coverage.
In the CuponEuromillions class this is mostly due to the fact that no tests are being done over the format() method, which significantly lowers the coverage since it includes most of the lines that need to be tested.

Clicking in the Dip class results in the following table:
![Alt text](Resources/dip_coverage.png?raw=true "Dip Methods Coverage")

From which we can come to the conclusion that most methods are well covered with the exception of hashCode() and equals() (mostly in the missed branches category), these methods usually don't need to be fully covered by our tests since they are auto-added and if we have many classes they are (usually) identical.

We can also click on an individual method which will result in the code coverage being shown:
![Alt text](Resources/code_coverage.png?raw=true "Code Coverage hashCode equals")

Through the picture above we can see that the hashCode method isn't being covered by any tests and that most branches on the equals method aren't covered either, which results in the poor coverage shown above.










