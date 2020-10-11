Here is a Haskell function implementing the Fibonacci function from its
definition in the lab writeup, using pattern matching

> fibonacci :: (Eq a, Num a, Num a1) => a -> a1
> fibonacci 0 = 1
> fibonacci 1 = 1
> fibonacci n = fibonacci (n - 1) + fibonacci (n - 2)

> ackermann :: (Num a, Num a1, Ord a, Ord a1) => a -> a1 -> a1
> ackermann 0 n = n + 1
> ackermann m 0 = ackermann (m-1) 1
> ackermann m n = ackermann (m-1) (ackermann m (n-1))
