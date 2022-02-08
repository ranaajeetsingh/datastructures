Important points about Java arrays.

In Java, all arrays are dynamically allocated.
The variables in the array are ordered and each has an index beginning from 0.
The size of an array must be specified by int or short value and not long.
The direct superclass of an array type is Object.
Every array type implements the interfaces Cloneable and Serializable.

Creation:

type var_name[]; // declaring array
or
type[] var_name[]

Initializing:

var_name = new type[size]; // allocating memory to array

Creation and Initialization in single statement

type[] var_name = new type[size];

Array Literal:
In a situation where the size and variables of the array are already known, array literals can be used.

type[] var_name = new type[]{e1,e2,e3};

* There is no need to write the new type[] part in the latest versions of Java.

Accessing:

var_name[index];

If we try to access elements outside the array size JVM throws ArrayIndexOutOfBoundsException

Types of Java Array
- Single dimensional arrays: type[] var_name = new type[size];
- Multidimensional arrays: type\[]\[] var_name = new type\[size][size];
- Anonymous arrays: new type{e1,e2,e3};

The main objective of anonymous arrays are just for instant usage.