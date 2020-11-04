**Union-find with specific canonical element.** 

Add a method **find()** to the union-find data type so that **find(i)** returns the largest element in the connected component containing _i_. The operations, **union()**, **connected()**, and **find()** should all take logarithmic time or better.

For example, if one of the connected components is **{1,2,6,9}**, then the **find()** method should return **9** for each of the four elements in the connected components.