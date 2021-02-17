Tame Of Thrones
============
#### Components API REST tests

##### Language Used
- Java

##### Command to create Jar
- mvn clean install -DskipTests -q assembly:single

##### Command to run jar 
- java -jar target/geektrust.jar <absolute_path_to_input_file>
- for input 1 use - tameofthrones\src\main\resources\input1.txt
- for input 2 use - tameofthrones\src\main\resources\input2.txt
- the .jar file is in target folder.
- Ex - java -jar geektrust.jar <your folder Location>\tameofthrones\src\main\resources\input1.txt

##### Command to run test
- use mvn clean test to run, it has some issues as I was facing some due
to sure fire, if that happens simple go to the test\java\FunctionTest.java file 
and run the tests. Hope it helps.
