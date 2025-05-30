## Table of Contents

[JavaScript Core](#javascript-core)

  1. [let, const](#let-and-const)
  2. [Destructuring](#destructuring)
  3. [New String Features](#new-string-features)
  4. [New Number Features](#new-number-features)
  5. [New Array Features](#new-array-features)
  6. [New Function Features](#new-function-features)
  7. [New Object Features](#new-object-features)
  8. [Symbols](#symbols)
  9. [Proxy, Reflect](#proxy-reflect)
  10. [Sets, Maps](#sets-and-maps)
  11. [Iterators, for-of loop](#iterators-and-for-of-loop)
  12. [Generators](#generators)
  13. [Promises](#promises)
  14. [Classes](#classes)
  15. [Modules](#modules)

[Reference Information](#reference-information)

<br />

## JavaScript Core

<a name="let-and-const"></a>
### let, const

  * `let` declares variables similar to `var`, but with block scope

    Example:
    ```javascript
    {
        let a = 10;
        var b = 1;
    }

    console.log(a);     // ReferenceError: a is not defined
    console.log(b);     // => 1
    ```

  * `let` and `const` declarations are not hoisted - they must be declared before use

    Example:
    ```javascript
    console.log(foo);     // => undefined
    console.log(bar);     // ReferenceError: bar is not defined

    var foo = 2;
    let bar = 2;
    ```

  * Temporal Dead Zone (TDZ): Variables are bound to their block scope after declaration

    Example:
    ```javascript
    var tmp = 123;

    if (true) {
        tmp = 'abc';     // ReferenceError: tmp is not defined
        let tmp;
    }
    ```

  * `let` and `const` don't allow duplicate declarations in the same scope

    Example:
    ```javascript
    {
        let a = 10;
        var a = 1;          // SyntaxError: Identifier 'a' already declared
    }
    ```

  * **Block Scope**: `let` and `const` provide true block scope in JavaScript

    Example:
    ```javascript
    {
      let n = 5;
      if (true) {
          let n = 10;
          console.log(n);     // => 10
      }
      console.log(n);         // => 5
    }
    ```

  * `const` declares read-only constants that can't be reassigned

    Example:
    ```javascript
    const PI = 3.1415;
    PI = 3;     // TypeError: Assignment to constant
    ```

  * `const` must be initialized when declared

    Example:
    ```javascript
    const PI;     // SyntaxError: Missing initializer
    ```

  * Top-level `var` and `function` declarations become properties of the global object, while `let`, `const` and `class` do not

    Example:
    ```javascript
    var a = 1;
    console.log(window.a);     // => 1

    let b = 1;
    console.log(window.b);     // => undefined
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="destructuring"></a>
### Destructuring

  * Extract values from arrays/objects into distinct variables

    Example:
    ```javascript
    let [foo, [[bar], baz]] = [1, [[2], 3]];
    console.log(foo);     // => 1
    ```

  * Failed destructuring returns `undefined`

    Example:
    ```javascript
    var [foo] = [];
    console.log(foo);     // => undefined
    ```

  * Default values can be specified

    Example:
    ```javascript
    var [foo = true] = [];
    console.log(foo);     // => true
    ```

  * Object destructuring matches by property name

    Example:
    ```javascript
    var { bar, foo } = { foo: "aaa", bar: "bbb" };
    console.log(foo);     // => 'aaa'
    ```

  * Function parameter destructuring

    Example:
    ```javascript
    function move({x = 0, y = 0} = {}) {
        return [x, y];
    }
    move({x: 3});     // => [3, 0]
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="new-string-features"></a>
### New String Features

  * New string methods:
    - `includes()`: Checks if string contains substring
    - `startsWith()`: Checks if string starts with substring  
    - `endsWith()`: Checks if string ends with substring

    Example:
    ```javascript
    let str = 'Hello world!';
    str.startsWith('Hello');     // => true
    ```

  * `repeat()`: Repeats string

    Example:
    ```javascript
    'x'.repeat(3);     // => 'xxx'
    ```

  * **Template Literals**: Use backticks for multi-line strings and interpolation

    Example:
    ```javascript
    let name = 'Bob';
    `Hello ${name}`;     // => 'Hello Bob'
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="new-number-features"></a>
### New Number Features

  * `Number.isFinite()`: Checks if value is finite number
  * `Number.isNaN()`: Checks if value is NaN
  * `Number.isInteger()`: Checks if value is integer
  * `Math.trunc()`: Removes decimal part
  * `Math.sign()`: Returns sign of number

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="new-array-features"></a>
### New Array Features

  * `Array.from()`: Converts array-like objects to arrays

    Example:
    ```javascript
    Array.from(document.querySelectorAll('div'));
    ```

  * New array methods:
    - `find()`: Finds first matching element
    - `findIndex()`: Finds index of first matching element
    - `fill()`: Fills array with value
    - `keys()/values()/entries()`: For iteration

  * Spread operator (`...`): Expands array into arguments

    Example:
    ```javascript
    Math.max(...[1, 2, 3]);     // => 3
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="new-function-features"></a>
### New Function Features

  * Default parameters

    Example:
    ```javascript
    function greet(name = 'World') {
        return `Hello ${name}`;
    }
    ```

  * Rest parameters (`...`): Collects remaining arguments

    Example:
    ```javascript
    function sum(...numbers) {
        return numbers.reduce((a, b) => a + b);
    }
    ```

  * Arrow functions: Shorter syntax and lexical `this`

    Example:
    ```javascript
    const square = x => x * x;
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="new-object-features"></a>
### New Object Features

  * Property shorthand

    Example:
    ```javascript
    const x = 1;
    const obj = { x };     // { x: 1 }
    ```

  * Computed property names

    Example:
    ```javascript
    const prop = 'name';
    const obj = { [prop]: 'John' };     // { name: 'John' }
    ```

  * `Object.assign()`: Merges objects

    Example:
    ```javascript
    Object.assign({}, {a: 1}, {b: 2});     // {a: 1, b: 2}
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="symbols"></a>
### Symbols

  * New primitive type for unique property keys

    Example:
    ```javascript
    const sym = Symbol('description');
    const obj = { [sym]: 'value' };
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="proxy-reflect"></a>
### Proxy, Reflect

  * `Proxy`: Intercept and customize object operations

    Example:
    ```javascript
    const handler = {
        get(target, prop) {
            return prop in target ? target[prop] : 37;
        }
    };
    const p = new Proxy({}, handler);
    ```

  * `Reflect`: Methods for object operations

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="sets-and-maps"></a>
### Sets, Maps

  * `Set`: Collection of unique values

    Example:
    ```javascript
    const set = new Set([1, 2, 3, 3]);
    set.size;     // => 3
    ```

  * `Map`: Key-value collection with any key type

    Example:
    ```javascript
    const map = new Map();
    map.set('name', 'John');
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="iterators-and-for-of-loop"></a>
### Iterators, for-of loop

  * Iterable protocol for custom iteration

    Example:
    ```javascript
    const iterable = {
        [Symbol.iterator]() {
            // Return iterator object
        }
    };
    ```

  * `for-of` loop for iterating over iterables

    Example:
    ```javascript
    for (const x of ['a', 'b']) {
        console.log(x);
    }
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="generators"></a>
### Generators

  * Functions that can pause and resume execution

    Example:
    ```javascript
    function* gen() {
        yield 1;
        yield 2;
    }
    const g = gen();
    g.next();     // { value: 1, done: false }
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="promises"></a>
### Promises

  * Asynchronous programming solution

    Example:
    ```javascript
    const promise = new Promise((resolve, reject) => {
        if (success) {
            resolve(value);
        } else {
            reject(error);
        }
    });
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="classes"></a>
### Classes

  * Syntactic sugar over prototype-based inheritance

    Example:
    ```javascript
    class Point {
        constructor(x, y) {
            this.x = x;
            this.y = y;
        }
        
        toString() {
            return `${this.x},${this.y}`;
        }
    }
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

<a name="modules"></a>
### Modules

  * `export`: Exports bindings
  * `import`: Imports bindings

    Example:
    ```javascript
    // lib.js
    export const sqrt = Math.sqrt;
    
    // app.js
    import { sqrt } from 'lib';
    sqrt(4);     // => 2
    ```

**[⬆ back to top](#table-of-contents)**

<br />
<br />

## Reference Information

JavaScript ECMAScript 6 Primer (Author: Ruan Yifeng)

Exploring ES6: Upgrade to the next version of JavaScript (Author: Dr. Axel Rauschmayer)

<br />
