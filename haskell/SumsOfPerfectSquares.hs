module SumsOfPerfectSquares (sumOfSquares) where

isPerfectSquare :: Int -> Bool
isPerfectSquare n = sq * sq == n
  where
    sq = floor $ sqrt $ fromIntegral n

isSquare2 :: Int -> Bool
isSquare2 n = go 1 
        where go i | i * i >= n = False
                   | otherwise = let j = n - i * i 
                                     is2 = isPerfectSquare j
                                 in if is2 
                                    then True
                                    else go $ i + 1

is4k8m7 :: Int -> Bool 
is4k8m7 n = go n 
  where go n | n `mod` 4 == 0 = go $ n `div` 4
             | otherwise = n `mod` 8 == 7

sumOfSquares :: Int -> Int
sumOfSquares n | isPerfectSquare n = 1
               | is4k8m7 n = 4
               | isSquare2 n = 2
               | otherwise = 3
