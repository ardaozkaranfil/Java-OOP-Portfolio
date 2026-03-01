# Java-OOP-Portfolio
Hello! I am a 2nd-year Software Engineering student, and this repository is a collection of my core Java projects.

I mainly built these projects to make sure I have a realy solid foundation in Java before I start jumping into bigger frameworks. 

## Projects in this repo

Here is a quick breakdown of what I've included:

- **Spell Checker & Text Processor:** This one is probably my favorite. I wrote a custom spell checker from scratch using the Levenshtein Distance algorithm (Dynamic Programming) to suggest word corrections. I also added a text censor module that uses `HashSet` for O(1) lookups.
- **Inventory & Sales Manager:** A generic stock tracking system. I used Java Generics (`<T extends Product>`) and HashMaps to safely handle different types of products and calculate daily sales.
- **Logistics System:** A shipping calculator where I practiced using multiple Interfaces (`Trackable`, `Insurable`, `Refundable`) for various package types.
- **Journal Manager:** A console-based diary app. I specifically built this to practice File I/O operations (like reading and writing both plain text and binary files).
- **Virtual Assistant Platform:** I used Abstract classes here to manage different types of smart assistants (like Home Control or Finance).
- **Library System:** Focused entirely on Custom Exception Handling (e.g., `OverLimitException`, `ItemNotFoundException`) to manage user limits without breaking the app.
- **RPG Battle Simulator:** A fun, turn-based console game engine just to practice Inheritance and Polymorphism.

## Concepts Covered
- **OOP:** Inheritance, Abstract Classes, Interfaces, Polymorphism.
- **Data Structures:** Collections Framework (`HashMap`, `HashSet`, `ArrayList`).
- **Advanced Java:** Generics, Custom Exceptions, File I/O (Text & Binary).
- **Algorithms:** Dynamic Programming (Levenshtein Distance).

Feel free to check out the source code.
