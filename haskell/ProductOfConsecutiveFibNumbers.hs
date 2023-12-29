module Codewars.Kata.Fib where

-- | Returns a pair of consecutive Fibonacci numbers a b,
--   where (a*b) is equal to the input, or proofs that the
--   number isn't a product of two consecutive Fibonacci
--   numbers.
productFib :: Integer -> (Integer, Integer, Bool)
productFib n =
  let fib = 0 : 1 : zipWith (+) fib (tail fib)
   in go fib
  where
    go (f1 : f2 : rest)
      | f1 * f2 == n = (f1, f2, True)
      | f1 * f2 > n = (f1, f2, False)
      | otherwise = go (f2 : rest)