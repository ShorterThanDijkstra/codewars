module Codewars.G964.Longestconsec where

import Data.List

longestConsec :: [String] -> Int -> String
longestConsec strarr k
  | k <= 0 = ""
  | length strarr < k = ""
  | otherwise =
      minimumBy (\s1 s2 -> compare (length s2) (length s1)) $ consec strarr k

consec :: [String] -> Int -> [String]
consec strarr k =
  let suffixes = map (`drop` strarr) [0 .. length strarr - 1]
      consecs = filter (\s -> length s == k) $ map (take k) suffixes
   in map concat consecs
