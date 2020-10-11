A sample Haskell module for courses at CSB|SJU.

Authors J. Andrew Whitford Holey and Lynn R. Ziegler,
based on FirstLiterate.lhs from Simon Thompson, The Craft of Functional Programming;
last modified August, 2015.
Tabs replaced with spaces September 5, 2016.

A function to square a number

>    square n = n * n


A function to cube a number by Channa

>    cube n = (square n) * n


A function to raise a number to the fourth power by Channa

>    fourth n = (square n) * (square n)


A function to raise a number to the eighth power by Channa

>    eighth n = (fourth n) * (fourth n)


A function to double a number

>    double n =  2 * n


A function to solve for a root in a quadratic function by Channa

>    quadratic a b c = (-b + sqrt((square b) - (4 * a * c))) / (2 * a)


A function to compute the value of a quadratic polynomial for a particular value by Channa

>    quadpoly :: Num a => a -> a -> a -> a -> a
>    quadpoly a b c x = (a * (square x)) + (b * x) + c


A function that uses quadpoly to evaluate a different polynomial by Channa

>    poly1 x = quadpoly 3 (-25) 7 x


A function to evaluate a cubic polynomial by Channa

>    cubicpoly a b c d x = (a * (cube x)) + (b * (square x)) + (c * x) + d


A function that uses cupicpoly to evaluate a different cubic polynomial by Channa

>    poly2 x = cubicpoly 1 0 0 (-5.359375) x


A function that determines if a triangle is equilateral, isoceles, or scalene by Channa

>    triangle a b c
>        | a == b && b == c = "This triangle is equilateral."
>        | a == b || a == c || b == c = "This triangle is isoceles."
>        | otherwise = "This triangle is scalene."


A function to compute the maximum of two numbers

>    max2a v1 v2
>        | v1 > v2    = v1
>        | otherwise  = v2

Here is another function to compute the maximum of two numbers

>    max2b v1 v2 = if (v1>v2) then v1 else v2


A recursive function to compute the largest common divisor of two integers

>    lcd m 0 = m
>    lcd 0 n = n
>    lcd m n = lcd n (mod m n)


A recursive function to apply a function to a list of arguments

>    applyIt f []    = []
>    applyIt f (x:l) = (f x):(applyIt f l)


A recursive function to apply a list of functions to an argument

>    applyThem [] x    = []
>    applyThem (f:l) x = (f x):(applyThem l x)


