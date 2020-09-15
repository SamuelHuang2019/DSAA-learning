# Lots to Solve, Less to Write—Matrices Read Write and Multiplication in Python

Matrix multiplication you're familiar with, now presented in Python.

In lab 2, this question is also one for checking attendance. However, sadly, since I have an interview so I left the class early, and also because I'm not so familiar with **Python**, I didn't make it to accomplish my code during class time. But now it's the time for sharing my clumsy work.

>To be honest, this is the first time I use Python to write a complete piece of code to solve a problem, forgive my poor coding skills~

A friend of mine (a skilled Python developer) told me that my Python code has a "**Java flavor**", I hope readers of this thread could give me some advice on Python coding.

---

## Code

The complete source code can be retrieved at [multiply.py](https://github.com/SamuelHuang2019/DSAA-learning/blob/master/lab/multiply.py).

Several methods are defined to achieve the goal.

### The `generate` function

Firstly, we need to generate two matrices and store them in a file (generally `.txt` file)

```python
def generate(dim_g):
    dim = 10
    f = open('matrices.txt', 'w')
    for i in range(dim_g):
        for i in range(dim_g):
            f.write(str(random.random()) + ' ')
        pass
        f.write('\n')
    pass

    f.write('\n')

    for i in range(dim_g):
        for i in range(dim_g):
            f.write(str(random.random()) + ' ')
        pass
        f.write('\n')
    pass

    f.write('\n')
    pass
```

This function needs a `dim_g` parameter for the dimension of the matrices generated, and the two matrices are separated with a line break.

Another important thing is, the elements in the matrices generated are all `float` type in range 0 to 1, since they are generated by calling `random.random()`.

As you can see, the crucial part of these codes is for loop, and there are 6 duplicated lines, which is indeed a slight problem. What solution would be better?

---

### The `read_dim` function

This function is for reading the dimension of the matrices recorded in `matrices.txt`.

```python
def read_dim():
    f = open('matrices.txt', 'r')
    dim = 0
    while f.readline() != '\n':
        dim = dim + 1
        pass
    return dim
```

"Declare a variable then manipulate it", is this typical "Java flavor"?

---

### The `read` function

This is the most annoying part I met. Unlike Java, which provides `nextInt()`, `next()` and `nextLine()` method capsulated in `Scanner`  class, reading a input is kinda tricky and not intuitive I think. (Or I should change my way of thinking to be more "Python")

```python
def read(dim_r):
    # dim_r = 10
    f = open('matrices.txt')
    matrix1 = np.zeros((dim_r, dim_r), dtype=float)
    for i in range(dim_r):
        line = list(map(float, f.readline().split()))
        # print(l)
        # print(matrix)
        for j in range(dim_r):
            matrix1[i][j] = line[j]
            print(line[j])
            pass
        pass

    f.readline()
    matrix2 = np.zeros((dim_r, dim_r), dtype=float)
    for i in range(dim_r):
        line = list(map(float, f.readline().split()))
        for j in range(dim_r):
            matrix2[i][j] = line[j]
            print(line[j])
            pass
        pass
    return matrix1, matrix2
```

This function takes a input `dim_r`, the dimension of the matrices, which can be retrieved by calling function `read_dim()`, and returns a tuple consists of the two matrices.

At the beginning, I tried to use a 2-D array for storing the matrices — just like in Java. However, this is just another difference between Java and Python. Multi-dimension array (or more accurately, `list`) is not convenient in both initializing or manipulating. I also tried using tuple of tuples, also not a good choice.

After searching online, in conclusion, the best way dealing with matrix, or any other multi-dimensional data in Python should be library `numpy`. After importing numpy, I could manipulating matrix easily... (Just like 2D array in Java)

>Such tasks, simple as 2D-array, cannot be easily handled in Python "natively", I think this is exactly a feature of Python. Python is light-weighted and brief, and has a lot of useful modules. Without these modules, Python may behave less practical than other languages; with them, Python becomes a powerful tool.

---

### Calling the functions

```Python
generate(3)
matrices = read(read_dim())
print(np.multiply(matrices[0], matrices[1]))
```

Since I already utilized `numpy`, `numpy.multiply()` is available to obtain the product of two matrices directly. Obviously this is a shortcut, and the problem doesn't want me to do so...

---

## Output

![Output](https://gitee.com/SamuelHuang2019/figure-bed/raw/master/img/20200915201434-multiplication.png)

Running `multiply.py`, in terminal, Python outputs elements in the two matrices generated, then the result.

---

## To-Do

- Code can be more "Python" instead of being with "Java flavor" (though I don't know how)
- Duplicated lines need to be dealt with.
- Write my own `multiply` function.
- Optimize the program, so that I could interact with the terminal to input dimension.of the matrices, file name, etc, without need of modifying the variable in the code.

>Apparently, I won't work on this anymore...