# JavaScript Comprehensive Guide

## Table of Contents

[JavaScript Concept](#javascript-concept)

[JavaScript Core](#javascript-core)

1. [Lexical Structure](#lexical-structure)
2. [Types, Values, and Variables](#types-values-and-variables)
3. [Expressions and Operators](#expressions-and-operators)
4. [Statements](#statements)
5. [Objects](#objects)
6. [Arrays](#arrays)
7. [Functions](#functions)
8. [let, const](#let-and-const)
9. [Destructuring](#destructuring)
10. [New String Features](#new-string-features)
11. [New Number Features](#new-number-features)
12. [New Array Features](#new-array-features)
13. [New Function Features](#new-function-features)
14. [New Object Features](#new-object-features)
15. [Symbols](#symbols)
16. [Proxy, Reflect](#proxy-reflect)
17. [Sets, Maps](#sets-and-maps)
18. [Iterators, for-of loop](#iterators-and-for-of-loop)
19. [Generators](#generators)
20. [Promises](#promises)
21. [Classes](#classes)
22. [Modules](#modules)

[Reference Information](#reference-information)

<br />

## JavaScript Concept

* JavaScript was created in 1995 by [Brendan Eich](https://twitter.com/BrendanEich) while working at Netscape
* ECMAScript is the standardized name for JavaScript

<br />

## JavaScript Core

### Lexical Structure

* JavaScript programs should be written using the Unicode character set (ES5 requires implementations to support Unicode 3 and later)
* JavaScript is case-sensitive, so "keywords, variables, function name, and identifiers" must maintain consistent casing
* **Literal**: A data value that appears directly in program code
* **Identifier**: A name used to identify "variables, functions, or labels in loops". Must start with "a letter, underscore, or dollar sign", followed by "letters, digits, underscores, or dollar signs"
* **Reserved words**: Cannot be used as identifiers

**[⬆ back to top](#table-of-contents)**

<br />
<a name="types-values-and-variables"></a>
### Types, Values, and Variables

* JavaScript types are divided into two categories: primitive types and object types
* **Primitive types**: numbers, strings, booleans, null, undefined
* **Object types**: Anything that's not a primitive type is an object type
* JavaScript variables are untyped, use lexical scoping, and are declared with `var`
* All numbers in JavaScript are represented as floating-point values (not integers)
* **String literals**: Enclose string characters in matching single or double quotes
* **Escape sequences in string literals**: Used to represent characters that can't be directly represented, using `\`
* **String concatenation**: The `+` operator joins strings together
* **null**: Represents the absence of a value
* **undefined**: Occurs in these situations: uninitialized variables, accessing non-existent object properties or array elements, functions with no return value, function parameters with no corresponding arguments
* **Global object**: When the JavaScript interpreter starts or when a browser loads a new page, it creates a global object with initial properties
* **The `this` keyword**: Not a constant - its value changes depending on where it appears in the code
* **Wrapper objects**: When you refer to a property of a string, number, or boolean, JavaScript converts it to a temporary object
* **Primitive types**: Compared by value, values are immutable
* **Object types**: Compared by reference, values are mutable
* **Explicit type conversion**: Use conversion functions
* **Variable declaration**: Use `var`, `let`, or `const`
* **Variable scope**: Variables declared at the top-level are global. Variables declared in a function body are local
* **Hoisting**: `var` declarations and `function` declarations are "hoisted" to the top of their scope

**[⬆ back to top](#table-of-contents)**

<br />
<a name="expressions-and-operators"></a>
### Expressions and Operators

* **Expression**: Something the interpreter can evaluate to produce a value
* **Operators**: Most operators are represented by punctuation. They have precedence and associativity.
* **Operands**: The elements that operators evaluate

**[⬆ back to top](#table-of-contents)**

<br />
<a name="statements"></a>
### Statements

* **Conditional statements**: `if`, `else if`, `switch`
* **Loop statements**: `while`, `do/while`, `for`, `for/in`
* **Labeled statements**: Add a label to a statement for reference elsewhere
* **Jump statements**: `break`, `continue`, `return`, `try/catch/finally`
* 'use strict': Indicates that following code is strict code

**[⬆ back to top](#table-of-contents)**

<br />
<a name="objects"></a>
### Objects

* Objects are collections of properties
* Each property has associated property attributes: writable, enumerable, configurable
* Each object has associated object attributes: prototype, class, extensible
* Create objects using: object literals, `new` keyword, or `Object.create()`
* Every object has a prototype object from which it inherits properties
* **Prototype chain**: The inheritance relationship between objects
* Access properties using `.` or `[]` operators
* Delete properties with `delete` operator
* Check property attributes with `Object.getOwnPropertyDescriptor()`
* Set property attributes with `Object.defineProperty()`
* Enumerate object properties
* Get/set object attributes
* **Object serialization**: Convert objects to strings and back

**[⬆ back to top](#table-of-contents)**

<br />
<a name="arrays"></a>
### Arrays

* Array elements can be any type, and different elements can have different types
* Create arrays with `[]` or `new Array()`. **Array literals allow trailing commas**
* Read/write array elements with `[]`
* `forEach()`: Iterates through all elements

**[⬆ back to top](#table-of-contents)**

<br />
<a name="functions"></a>
### Functions

* **Function**: A block of JavaScript code defined once but can be invoked multiple times
* When assigned to an object property, it's called a method
* Function declaration with `function`
* Function expressions can omit the function name
* Invoke functions four ways: "as functions", "as methods", "as constructors", and "indirectly"
* Function invocation doesn't check argument types or count
* `arguments` is array-like object
* Functions are not just syntax - they're values
* Functions are specialized objects and can have properties
* Parameter passing: Call by sharing
* Each function has a prototype property referencing a prototype object
* `call()`, `apply()`: For indirect invocation
* `bind()`: Binds a function to an object
* **Callback**: A function passed as an argument to another function to be executed later
* **Closure**: A function that has access to the parent scope, even after the parent function has closed

**[⬆ back to top](#table-of-contents)**

<br />
<a name="let-and-const"></a>
### let, const

* `let` declares variables similar to `var`, but with block scope
* `let` and `const` declarations are not hoisted - they must be declared before use
* Temporal Dead Zone (TDZ): Variables are bound to their block scope after declaration
* `let` and `const` don't allow duplicate declarations in the same scope
* **Block Scope**: `let` and `const` provide true block scope in JavaScript
* `const` declares read-only constants that can't be reassigned
* `const` must be initialized when declared
* Top-level `var` and `function` declarations become properties of the global object, while `let`, `const` and `class` do not

**[⬆ back to top](#table-of-contents)**

<br />
<a name="destructuring"></a>
### Destructuring

* Extract values from arrays/objects into distinct variables
* Failed destructuring returns `undefined`
* Default values can be specified
* Object destructuring matches by property name
* Function parameter destructuring

**[⬆ back to top](#table-of-contents)**

<br />
<a name=""></a>
### New String Features
<a name="new-string-features"><a/>
* New string methods:
  - `includes()`: Checks if string contains substring
  - `startsWith()`: Checks if string starts with substring  
  - `endsWith()`: Checks if string ends with substring
* `repeat()`: Repeats string
* **Template Literals**: Use backticks for multi-line strings and interpolation

**[⬆ back to top](#table-of-contents)**

<br />
<a name="new-number-features"><a/>
### New Number Features

* `Number.isFinite()`: Checks if value is finite number
* `Number.isNaN()`: Checks if value is NaN
* `Number.isInteger()`: Checks if value is integer
* `Math.trunc()`: Removes decimal part
* `Math.sign()`: Returns sign of number

**[⬆ back to top](#table-of-contents)**

<br />
<a name="new-array-features"><a/>
### New Array Features

* `Array.from()`: Converts array-like objects to arrays
* New array methods:
  - `find()`: Finds first matching element
  - `findIndex()`: Finds index of first matching element
  - `fill()`: Fills array with value
  - `keys()/values()/entries()`: For iteration
* Spread operator (`...`): Expands array into arguments

**[⬆ back to top](#table-of-contents)**

<br />
<a name="new-function-features"><a/>
### New Function Features

* Default parameters
* Rest parameters (`...`): Collects remaining arguments
* Arrow functions: Shorter syntax and lexical `this`

**[⬆ back to top](#table-of-contents)**

<br />
<a name="new-object-features"><a/>
### New Object Features

* Property shorthand
* Computed property name
* `Object.assign()`: Merges objects

**[⬆ back to top](#table-of-contents)**

<br />
<a name="symbols"><a/>
### Symbols

* New primitive type for unique property keys

**[⬆ back to top](#table-of-contents)**

<br />
<a name="proxy-reflect"><a/>
### Proxy, Reflect

* `Proxy`: Intercept and customize object operations
* `Reflect`: Methods for object operations

**[⬆ back to top](#table-of-contents)**

<br />
<a name="sets-and-maps"><a/>
### Sets, Maps

* `Set`: Collection of unique values
* `Map`: Key-value collection with any key type

**[⬆ back to top](#table-of-contents)**

<br />
<a name="iterators-and-for-of-loop"><a/>
### Iterators, for-of loop

* Iterable protocol for custom iteration
* `for-of` loop for iterating over iterables

**[⬆ back to top](#table-of-contents)**

<br />
<a name="generators"><a/>
### Generators

* Functions that can pause and resume execution

**[⬆ back to top](#table-of-contents)**

<br />
<a name="promises"><a/>
### Promises

* Asynchronous programming solution

**[⬆ back to top](#table-of-contents)**

<br />
<a name="classes"><a/>
### Classes

* Syntactic sugar over prototype-based inheritance

**[⬆ back to top](#table-of-contents)**

<br />
<a name="modules"><a/>
### Modules

* `export`: Exports bindings
* `import`: Imports bindings

**[⬆ back to top](#table-of-contents)**

<br />
<a name="reference-information"><a/>
## Reference Information

* JavaScript: The Definitive Guide, 6E Traditional Chinese (Author: David Flanagan)
* Speaking JavaScript, Traditional Chinese (Author: Dr. Axel Rauschmayer)
* JavaScript — call-by-sharing (Author: Avinash Kondeti)
* Introduction to JavaScript Parameter Passing (Author: Tommy Lin)
* JavaScript ECMAScript 6 Primer (Author: Ruan Yifeng)
* Exploring ES6: Upgrade to the next version of JavaScript (Author: Dr. Axel Rauschmayer)
