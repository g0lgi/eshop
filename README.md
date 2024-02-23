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
