## KnapSack

The objective of the Knapsack problem is to select objects to put into the Knapsack in order to maximize the sum of their values, while ensuring that the total weight of the selected objects does not exceed the capacity of the Knapsack.

## Dynamic programming

- if n = 0  =>  0
- if w = 0  =>  0
- if n > 0 and w > 0  =>  max(totalValue(n-1, w) , totalValue(n-1, w-weight(n)) + value(n))
- if w < 0  =>  minus infinity

n : number of objects
w : Maximum capacity
weight : weight of objects
value  : value of objects

## Example

w = 10

```
n       weight         value
1          1           1200
2          7           5000
3          5           1300
4          10          2700
5          2           1000

   0  1     2     3     4     5     6     7     8     9     10
0  0  0     0     0     0     0     0     0     0     0     0  
1  0  1200  1200  1200  1200  1200  1200  1200  1200  1200  1200
2  0  1200  1200  1200  1200  1200  1200  5000  6200  6200  6200
3  0  1200  1200  1200  1200  1300  2500  5000  6200  6200  6200
4  0  1200  1200  1200  1200  1300  2500  5000  6200  6200  6200
5  0  1200  1200  2200  2200  2200  2500  5000  6200  6200  7200

```

List of items to take : 5, 2, 1.