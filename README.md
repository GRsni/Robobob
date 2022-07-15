# Robobob

Robobob is a fictional children's mathematics app (GUI application implemented in Java).
Can answer a limited set of written questions, and resolve simple arithmetic expressions *e.g. "-7\*10+(5+1)/2"*.

## Characteristics

- Can answer questions from an existing list that is kept in persistent storage, currently a simple txt file.
  - This is achieved by creating a storage class that implements the interface [StorageInterface](https://github.com/GRsni/Robobob/blob/master/src/main/java/com/provenir/robobob/storage/StorageInterface.java). 
  All future classes that handle the storage of written questions just need to implement said interface to be compatible with the program.
  Moreover, the StorageInterface-implementing-class is passed to the [QuestionSolver](https://github.com/GRsni/Robobob/blob/master/src/main/java/com/provenir/robobob/solver/QuestionSolver.java) class in the constructor, as a means of dependency injection, 
  both allowing for the interchangeability of the actual storage medium, and for easier testing of the classes.
- Can solve simple arithmetic expression involving these operators: '+', '-', '*', '/', '(', ')' and decimal numbers.
  - The expressions are solved using a recursive descent parser algorithm, implemented in the class [Parser](https://github.com/GRsni/Robobob/blob/master/src/main/java/com/provenir/robobob/solver/parser/Parser.java). 
  This algorithm creates an expression tree from the tokens extracted from the input expression, through a series of recursive calls
  that implements the different nonterminal tokens of the grammar. 
  - The grammar specified supports tokens for :
    - Values, in this cased modeled by a wrapper to a Java Float object.
    - Addition.
    - Subtraction.
    - Multiplication.
    - Division.
    - Negation
  - In the case there is an error while parsing or evaluating the expression, an exception of type [ParserException](https://github.com/GRsni/Robobob/blob/master/src/main/java/com/provenir/robobob/solver/parser/exception/ParserException.java), which allows
  for easier error handling.
- For the sake of a better user experience, if the program does not find an answer or solution to the input expression, it will 
print to the output a sentence informing the user that the query failed.
- A [logger](https://github.com/GRsni/Robobob/tree/master/src/main/java/com/provenir/robobob/logger) service has also been implemented, that registers meaningful events that occur throught the execution of the program.