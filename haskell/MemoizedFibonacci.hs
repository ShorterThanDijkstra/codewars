module MemoizedFibonacci where

fibonacci :: Int -> Integer
fibonacci n = memFib !! n
  where memFib = 0:1:zipWith (+) memFib (tail memFib)

nat :: [Int]
nat  = 0:map (+1) nat