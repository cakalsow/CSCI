> module StarterCode where

Recurrence relation F(n)

> relF n
>   | n == 1 = 5
>   | n > 1 = relF(n - 1) + ((3 * n) -2)

*StarterCode> map relF [1 .. 10]                                                
[5,7,11,15,19,23,27,31,35,39] 
                                                 
Recurrence relation G(n)

> relG n
>   | n == 0 = 3
>   | n > 0 = relG(n - 1) + (2 * n) + 4

*StarterCode> map relG [0 .. 9]
[3,9,17,27,39,53,69,87,107,129]
                                            

Recurrence relation H(n)

> relH n
>   | n == 0 = 2
>   | n > 0 = relH(n - 1) + (3 * (n ^ 2)) - (4 * n) + 1

*StarterCode> map relH [0 .. 9]                                                 
[2,2,7,23,56,112,197,317,478,686]

Recurrence relation J(n)

> relJ n
>   | n == 1 = 1
>   | n > 1 = relJ(n - 1) + (n ^ 2) - (2 * n) + 1

*StarterCode> map relJ [1 .. 10]
[1,2,6,15,31,56,92,141,205,286]

Recurrence relation L(n)

> relL n
>   | n == 1 = 1
>   | n > 1 = 2 * relL(n `div` 2) + n

*StarterCode> map relL [1..32]
[1,4,5,12,13,16,17,32,33,36,37,44,45,48,49,80,81,84,85,92,93,96,97,112,113,116,117,124,125,128,129,192]

Recurrence relation Q(n)

> relQ n
>   | n == 0 = 0
>   | n > 0 = relQ(n - 1) + (n ^ 3)

*StarterCode> map relQ [0 .. 9]
[0,1,9,36,100,225,441,784,1296,2025]

Recurrence relation T(n)

> relT n
>   | n == 1 = 1
>   | n > 1 = 2 * relT(n - 1) + 1

*StarterCode> map relT [1 .. 10]
[1,3,7,15,31,63,127,255,511,1023]

