-- https://www.codewars.com/kata/54c9fcad28ec4c6e680011aa/train/haskell

module MergedStringChecker where

isMerge :: String -> String -> String -> Bool
isMerge [] [] [] = True
isMerge [] _ _ = False
isMerge cs [] part2 = cs == part2
isMerge cs part1 [] = cs == part1
isMerge (c : cs) (c1 : cs1) (c2 : cs2) =
  case (c == c1, c == c2) of
    (True, True) -> isMerge cs cs1 (c2 : cs2) || isMerge cs (c1 : cs1) cs2
    (True, False) -> isMerge cs cs1 (c2 : cs2)
    (False, True) -> isMerge cs (c1 : cs1) cs2
    (False, False) -> False