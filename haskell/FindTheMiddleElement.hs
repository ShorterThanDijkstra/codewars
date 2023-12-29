module Codewars.Kata.Middle where

-- | Return the index of the middle element.
--   The first element has index 0.
middle a b c = a < c && a > b || a < b && a > c

gimme :: Ord a => (a, a, a) -> Int
gimme (a, b, c) | middle a b c = 0
                | middle b a c = 1
                | middle c a b = 2