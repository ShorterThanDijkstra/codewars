module Josephus where

josephus :: [a] -> Int -> [a]
josephus xs k = go xs (mod (k - 1) (length xs)) []
  where
    go :: [a] -> Int -> [a] -> [a]
    go [] i res = reverse res
    go xs i res =
      let rem = xs !! i
          xs' = take i xs ++ drop (i + 1) xs
          i' = mod (i + k - 1) (length xs')
       in go xs' i' (rem : res)