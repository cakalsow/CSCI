StarterCode.lhs

Haskell Code for CSCI 239, Lab 4

> module StarterCode where

This function determines whether one of its two parameters divides the other.
Both parameters can not be zero. The type will be determined in lab.

> oneDividesTheOther 0 0 = False
> oneDividesTheOther n 0 = True
> oneDividesTheOther n m = n `mod` m == 0 || m `mod` n == 0

This function returns the minimum element in a non-empty list of ordinal values.

> minList :: Ord a => [a] -> a
> minList (x:[])  = x
> minList (x:xs)
>   | x < minRest = x
>   | otherwise   = minRest
>   where minRest = minList xs

This function returns the maximum element in a non-empty list of ordinal values.

> maxList :: Ord a => [a] -> a
> maxList (x:[])  = x
> maxList (x:xs)
>   | x > maxRest = x
>   | otherwise   = maxRest
>   where maxRest = maxList xs

A function that returns the median of the first three of fewer elements in a list

> median1st3 :: Ord a => [a] -> a
> median1st3 (x:[]) = x
> median1st3 (x:y:[]) = x
> median1st3 (x:y:z:xs)
>   | x == y || x == z = x
>   | y == z = y
>   | x > minList [x, y, z] && x < maxList [x, y, z] = x
>   | y > minList [x, y, z] && y < maxList [x, y, z] = y
>   | otherwise = z

A function that returns a list of the medians of every three elements of a list

> medianAll3s :: Ord a => [a] -> [a]
> medianAll3s [] = []
> medianAll3s (x:[]) = [x]
> medianAll3s (x:y:[]) = [x]
> medianAll3s (x:y:z:xs) = (median1st3 (x:y:z:xs)) : (medianAll3s(xs))

A function that repeatedly calls medianAll3s until it has reduced its list parameter to a single element

> medianOfMedian3s (x:[]) = [x]
> medianOfMedian3s (x:y:[]) = [x]
> medianOfMedian3s (x:y:z:xs) = medianOfMedian3s(medianAll3s(x:y:z:xs))

A function that takes a list parameter and returns a pair of lists that together contain exactly the elements of the original list, evenly divided between the two lists.

> splitList :: [a] -> ([a], [a])
> splitList [] = ([], [])
> splitList (x:[]) = ([x], [])
> splitList (x:y:xs) = (x:xs1, y:xs2)
>   where (xs1, xs2) = splitList xs

A function that takes two sorted lists as its parameters and returns a single list containing exactly the elements of the two lists in sorted order.

> mergeLists :: Ord a => [a] -> [a] -> [a]
> mergeLists (xs) [] = xs
> mergeLists [] (xs) = xs
> mergeLists (x:xs) (y:ys)
>   | x < y = x:(mergeLists xs (y:ys))
>   | otherwise = y:(mergeLists (x:xs) ys)

This function sorts a list of ordinal values. It uses to auxiliary functions
splitList and mergeLists, which must be implemented before this function can be
compiled.

> mergeSort :: Ord a => [a] -> [a]
> mergeSort []     = []
> mergeSort (x:[]) = x:[]
> mergeSort (x:xs) =
>   mergeLists sl1 sl2
>   where
>     (l1, l2) = splitList (x:xs)
>     sl1      = mergeSort l1
>     sl2      = mergeSort l2

A function that takes three parameters and returns a tuple containing the values

> quadRoots1 a b c = ((((-b) + sqrt((b^2) - (4 * a * c))) / (2 * a)), ((((-b) - sqrt((b^2) - (4 * a * c))) / (2 * a))))

A function that modifies quadRoots1 to return a pair of pairs

> quadRoots2 a b c = ((((-b) + sqrt((b^2) - (4 * a * c))) / (2 * a), 0), ((((-b) - sqrt((b^2) - (4 * a * c))) / (2 * a), 0)))

A function that modifies quadRoots2 to handle two cases

> quadRoots3 a b c
>   |(b ^ 2) - (4 * a * c) >= 0 = ((((-b) + sqrt((b ^ 2) - (4 * a * c))) / (2 * a), 0), ((((-b) - sqrt((b ^ 2) - (4 * a * c))) / (2 * a), 0)))
>   | otherwise = ((((-b) / (2 * a)), (sqrt((4 * a * c) - (b ^ 2)) / (2 * a))), (((-b) / (2 * a)), ((-1 * sqrt((4 * a * c) - (b ^ 2)) / (2 * a)))))




