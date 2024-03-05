# Tutorial 1
## Reflection 1
### You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code.
As part of my efforts in adhering to clean code principles, among other things I have done:
1. Using meaningful names, as it is also easier for me to read.
2. Making different functions for each of the (relatively) simple features that should be implemented
3. In my opininon the previous 2 clean coding practices have made this project fairly readable, so I didn't use many comments, as to avoid clutter.
4. Getters and Setters were also used to avoid making accidental changes to any object's attributes

## Reflection 2
### 1.
**After writing the unit test, how do you feel?** \
I feel tired. \
**How many unit tests should be made in a class?** \
The number of unit tests needed for a class can vary depending on factors such as the complexity of the class, the number of methods it contains, and the different scenarios it needs to handle. However, there's no strict rule for the exact number of unit tests that should be created for a class. The focus should be on ensuring that the tests adequately cover the behavior of the class under various conditions. \
**How to make sure that our unit tests are enough to verify our program?** \
They should cover various scenarios, like edge cases and typical usage patterns. \
**It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?** \
No, having 100% code coverage doesn't mean your code is bug-free. Code coverage measures how much of your source code is executed by your tests. While high code coverage indicates that most parts of your code are being tested, it doesn't guarantee that all possible scenarios and edge cases are covered. It's still possible to have bugs in untested code paths or due to incorrect assumptions in the tests themselves.

### 2.
**Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables. Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!** \
One potential clean code issue is the duplication of setup procedures and instance variables in the new functional test suite. Repeating these setup steps violates the DRY (Don't Repeat Yourself) principle, making the code less maintainable and prone to errors.
To improve the cleanliness and maintainability of the code, I can refactor the common setup procedures and instance variables into a shared parent class or utility methods. By centralizing common functionality, I can avoid redundancy and ensure consistency across different test suites.

# Tutorial 2
## 1. List the code quality issue(s) that you fixed during the exercise and explain your strategy on fixing them.
I used SonarCloud, and it only gave me 1 code quality issue, which was that the products table html code didn't contain a description. So I added one using <caption>
## 2. Look at your CI/CD workflows (GitHub)/pipelines (GitLab). Do you think the current implementation has met the definition of Continuous Integration and Continuous Deployment? Explain the reasons!
Yes, CI, is handled by my ci.yml file. which automates testing every new push. CD is handled by Koyeb, my PaaS of choice, which I have set to automatically deploy every new push


# Tutorial 3
## 1. Explain what principles you apply to your project!
I applied the principles of SRP and DIP to my project, by separating CarController class from ProductController into its own file. Doing this accomplishes applying both principles at once, as now CarController and ProductController are separate classes which each serve one responsibility. Meanwhile, DIP is also adhered to now, as previously CarController extends ProductController.

## 2. Explain the advantages of applying SOLID principles to your project with examples.
  - SRP: It becomes easier to maintain and reason about the code when each class has a single responsibility, enabling us to modify each component independently, such as with the CarController and ProductController classes.
  - OCP: Similar to SRP, by designing modules to be open for extension and closed for modification, you can add new features without altering existing code.
  - LSP: Switching between implementations are easier.
  - ISP: It is easier for us to know which methods to implement and use.
  - DIP: The project is more flexible.

## 3. Explain the disadvantages of not applying SOLID principles to your project with examples.
  - SRP: When a class takes on multiple responsibilities, it becomes harder to maintain and understand.
  - OCP: Difficult to extend code without modifying existing components.
  - LSP:  Can lead to unexpected behavior when substituting subclasses for superclasses.
  - ISP: Unnecessary methods may be implemented, leading to code bloat.
  - DIP: The system is less flexible.

# Tutorial 4
## 1. Reflect based on Percival (2017) proposed self-reflective questions (in “Principles and Best Practice of Testing” submodule, chapter “Evaluating Your Testing Objectives”), whether this TDD flow is useful enough for you or not. If not, explain things that you need to do next time you make more tests.

**• Are my feedback cycles as fast as I would like them? When do I get
warned about bugs, and is there any practical way to make that happen
sooner?** \
Yes, they are pretty fast, and I haven't found a way to make them substantially faster.
**• Is there some way that I could write faster integration tests that would
get me feedback quicker?** \
Not that I am aware of.
**• Can I run a subset of the full test suite when I need to?** \
Yes, I have tests for each class in the model, repository, and service folders.
**• Am I spending too much time waiting for tests to run, and thus less time
in a productive flow state?** \
Not really, they run in seconds.

## 2. You have created unit tests in Tutorial. Now reflect whether your tests have successfully followed F.I.R.S.T. principle or not. If not, explain things that you need to do the next time you create more tests.
**Fast: The tests run as fast as possible so it can be run without interrupting your
workflow.** Yes, they run in seconds
**Isolated/Independent: A test case must not interfere, change the state of functions,
or dependent to other test cases.** Yes, they merely test their function
**Repeatable: Tests must be able to run repeatedly, with consistent result.** Yes
**Self-Validating: Tests must be self-validating (have strict and correct assertions to
pass/fail).** Yes
**Thorough/Timely: Tests must cover all happy paths and unhappy paths. Cover all
possibility of results and errors. Tests must be designed before coding.** Yes, as can be seen through my commits, which is RED first and then GREEN.
