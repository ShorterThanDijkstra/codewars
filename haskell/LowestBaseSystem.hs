module LowestBaseSystem (getMinBase) where

allOnes :: Int -> Int -> Bool
allOnes 0 _ = True
allOnes x base = x `mod` base == 1 && allOnes (x `div` base)  base

getMinBase :: Int -> Int
getMinBase n = go 3 $ ceiling $ logBase (fromIntegral 2) $ fromIntegral n
   where go i end | i == end + 1 = n - 1
                  | otherwise = let base = floor (fromIntegral n ** (1 / (fromIntegral i - 1)))
                                in if allOnes n base 
                                   then base
                                   else go (i + 1) end
