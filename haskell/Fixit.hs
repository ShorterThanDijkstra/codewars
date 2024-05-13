module Fixit where

import Prelude hiding (foldr, reverse)

fix :: (a -> a) -> a
fix f = let x = f x in x

reverse' :: ([a] -> [a]) -> [a] -> [a]
reverse' f [] = []
reverse' f (x : xs) = f xs ++ [x]

foldr' :: ((a -> b -> b) -> b -> [a] -> b) -> (a -> b -> b) -> b -> [a] -> b
foldr' f acc init [] = init
foldr' f acc init (x : xs) = acc x $ f acc init xs