StarterCode.lhs

Haskell Code for CSCI 239, Lab 3

> module StarterCode where

Count the number of elements in a list.

> count :: Num a => [t] -> a
> count []     = 0
> count (x:xs) = 1 + (count xs)

Count the number of times an element occurs in a list.

> elemCount :: (Eq a1, Num a) => a1 -> [a1] -> a
> elemCount elem []     = 0
> elemCount elem (x:xs)
>   | elem == x         = 1 + (elemCount elem xs)
>   | otherwise         = elemCount elem xs

Return a list of numbers starting at n, increasing by one, up to m.

> range :: (Num a, Ord a) => a -> a -> [a]
> range n m
>   | n > m     = []
>   | otherwise = n : (range (n + 1) m)

Creates a list of the integers from negative ten to ten

> list2_1 = [ (-10) .. 10 ]

Creates a list of the odd integers from one to nineteen in descending order

> list2_2 = [ 19, 17 .. 1 ]

Creates a list of letters from a to z

> list2_3 = [ 'a' .. 'z' ]

Creates a list of letters from A to Z

> list2_4 = [ 'A' .. 'Z' ]

Creates a list of letters from A to z

> list2_5 = [ 'A' .. 'z' ]

Creates a list of characters from a to Z

> list2_6 = [ 'a' .. 'Z' ]

Creates a list of floating-point numbers from zero to four by thirds

> list2_7 = [ (0/3), (1/3) .. (12/3) ]

Creates a list of the integers from one to five, followed by five down to one

> list3_1 = [ 1 .. 5 ] ++ [ 5, 4 .. 1 ]

Creates a list of letters of the Latin alphabet, both uppercase and lowercase

> list3_2 = [ 'A' .. 'Z' ] ++ [ 'a' .. 'z' ]

Creates a list of the alphabet together with the decimal digits

> list3_3 = [ 'A' .. 'Z' ] ++ [ 'a' .. 'z' ] ++ [ '0' .. '9' ]

Creates a list of the squares of the numbers from one to twenty

> list4_1 = [ n ^ 2 | n <- [ 1 .. 20 ]]

Creates a list of the square roots of the number from one to ten

> list4_2 = [ sqrt(n) | n <- [ 1 .. 10 ]]

Creates a list of 2^n for numbers from zero to forty

> list4_3 = [ 2 ^ n | n <- [ 0 .. 40 ]]

Creates a list of the multiples of pi/4 for multipliers zero to eight

> list4_4 = [ pi/4 * n | n <- [ 0 .. 8 ]]

Creates a list of floating-point numbers from zero to four by thirds

> list5_1 = [ n / 3 | n <- [ 0 .. 12 ]]

Creates a list of numbers from one to twenty that are divisible by two, three, or both

> list5_2 = [ n | n <- [ 1 .. 20 ], n `mod` 2==0 || n `mod` 3==0 ]

Creates a list of the lowercase alphabet consonants

> list5_3 = [ n | n <- [ 'a' .. 'z' ], n /= 'a' && n /= 'e' && n /= 'i' && n /= 'o' && n /= 'u' ]

Creates a list of 3-tuples where n and m are both taken from the list of numbers from zero to four

> list6_1 = [ (n, m, n * m) | n <- [ 0 .. 4 ], m <- [ 0 .. 4 ]]

Creates a list of pairs where the first element of each pair is from the list of numbers from zero to ten, and the second number is the square root of the first

> list6_2 = [ (n, sqrt(n)) | n <- [0 .. 10 ]]

Creates a list of pairs where the first element of each pair is from the list of numbers from one to three by 0.1, and the second number is the log of the first

> list6_3 = [ ((n/10), log(n/10)) | n <- [ 10 .. 30 ]]

A function that computes the sum of a list

> mySum [] = 0
> mySum (x:xs) = x + mySum xs

A function that computes the mean of a list

> myMean [] = 0
> myMean (x:xs) = mySum (x:xs) / count (x:xs)

A function that counts all the lowercase vowels in a string

> vowelCount1 xs = (elemCount 'a' xs) + (elemCount 'e' xs) + (elemCount 'i' xs) + (elemCount 'o' xs) + (elemCount 'u' xs)

A function that counts all the lowercase vowels in a string

> vowelCount2 [] = 0
> vowelCount2 ('a':xs) = 1 + (vowelCount2 xs) 
> vowelCount2 ('e':xs) = 1 + (vowelCount2 xs) 
> vowelCount2 ('i':xs) = 1 + (vowelCount2 xs) 
> vowelCount2 ('o':xs) = 1 + (vowelCount2 xs)
> vowelCount2 ('u':xs) = 1 + (vowelCount2 xs)
> vowelCount2 (x:xs) = (vowelCount2 xs)

A function that generates the list of squares of numbers from n down to one

> squaresDown n
>     | n < 1 = []
>     | otherwise = (n ^ 2) : squaresDown(n - 1)

A function that takes a list of numbers and returns a list of numbers that are the negative of the numbers in the original list

> neglist [] = []
> negList (x:xs) = (-x) : negList(xs)
