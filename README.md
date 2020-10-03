# Kotlin

## Contribution Guidelines
 - If you add an algorithm then you have to add a test (JUnit) along with it. In the absence of a test, the PR will not be approved.
 - Follow the correct coding guidelines with proper description of the methods. Refer [Kotlin Coding Standards](https://kotlinlang.org/docs/reference/coding-conventions.html).
 - Your work will be distributed under [MIT License](LICENSE) once your pull request is merged.
 - Please do not add a signature inside the code. The commit history is sufficient to determine who has added the code to the repo.
 - Make sure the algorithm which is getting added comes under a certain domain of Algorithms. Please don't create a package with a name such as Misc, Others, etc. 
 - While making a PR, make sure you are committing the Kotlin files only and not any project specific files. If you feel that your IDE is generating some extra files, then either don't add them to git, or add the extensions to ```.gitignore```.
 - Please don't raise a PR for solutions to problems from online judges such as Hackerrank, Leetcode, etc.

## Steps to raise a PR
- Fork the [Kotlin Repo](https://github.com/TheAlgorithms/Kotlin)
- Open the forked repo on your local machine through IntelliJ by importing the project as a Gradle project
- Make the changes on your local machine
- Push the changes to the forked repository
- Raise a PR against the master branch
