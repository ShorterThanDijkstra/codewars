-- https://www.codewars.com/kata/54c9fcad28ec4c6e680011aa/train/haskell

module MergedStringChecker where
isMerge :: String -> String -> String -> Bool
isMerge [] [] [] = True
isMerge [] _  _ = False
isMerge (c:cs) (c1:cs1) (c2:cs2) | c==c1 = isMerge cs 