module OnesAndZeroes (toNumber) where

toNumber :: [Int] -> Int
toNumber = foldl (\acc n -> acc * 2 + n) 0 