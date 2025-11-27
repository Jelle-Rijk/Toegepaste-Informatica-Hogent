# Som1

```
function Som1(n)
    x <- 0
    for i = 1 ... n do
        x <- x + 1
    return (x)
end function
```

| n   | voorspelde x | berekende x |
| --- | ------------ | ----------- |
| 1   | 1            | 1           |
| 2   | 2            | 2           |
| 4   | 4            | 4           |
| 8   | 8            | 8           |
| 16  | 16           | 16          |
| 32  | 32           | 32          |
| 64  | 64           | 64          |
| 128 | 128          | 128         |

T(n) = O(n)

# Som2

```
function Som2(n)
    x <- 0
    for i = 1 ... 2n do
        for j = 1 ... n do
            x <- x + 1
    return (x)
end function
```

| n   | voorspelde x | berekende x |
| --- | ------------ | ----------- |
| 1   | 2            | 2           |
| 2   | 8            | 8           |
| 3   | 18           | 18          |
| 4   | 32           | 32          |
| 8   | 128          | 128         |
| 16  | 512          | 512         |
| 32  | 2048         | 2048        |
| 64  | 8192         | 8192        |
| 128 | 32768        | 32768       |

T(n) = O(n<sup>2</sup>)

# Som3

```
function Som3(n)
    x <- 0
    for i = 1 ... n do
        for j = 1 ... i do
            for k = 1 ... j do
                x <- x + 1
    return x
```

| n   | voorspelde x | berekende x |
| --- | ------------ | ----------- |
| 1   | 1            | 1           |
| 2   | 8            | 4           |
| 3   | 27           | 10          |
| 4   | 64           | 20          |
| 8   | 512          | 120         |
| 16  | 4096         | 816         |

| n    | berekend |
| ---- | -------- |
| 1000 |
