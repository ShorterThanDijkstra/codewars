module Codewars.Kata.Phone where

-- "(123) 456-7890"  => True
-- "(1111)555 2345"  => False
-- "(098) 123 4567"  => False
validPhoneNumber :: String -> Bool
validPhoneNumber str =
  length str == 14 &&
  parseChar '(' str  &&
  parseNums 3 (tail str) &&
  parseChar ')' (drop 4 str) &&
  parseChar ' ' (drop 5 str) &&
  parseNums 3 (drop 6 str) &&
  parseChar '-' (drop 9 str) && parseNums 4 (drop 10 str)

parseChar c [] = False
parseChar c cs = head cs == c

parseNums 0 cs = True
parseNums n [] = False
parseNums n (c:cs)
  | c <= '9' && c >= '0' = parseNums (n - 1) cs
  | otherwise = False
