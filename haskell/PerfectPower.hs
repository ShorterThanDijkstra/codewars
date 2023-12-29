-- https://www.codewars.com/kata/54d4c8b08776e4ad92000835/train/haskell

module PerfectPower where

import Debug.Trace (trace)

isPP :: Integer -> Maybe (Integer, Integer)
isPP n = goM 2
  where
    goM m
      | m * m > n = Nothing
      | otherwise = goK m 2
    goK m k
      | m ^ k == n = Just (m, k)
      | m ^ k > n = goM (m + 1)
      | otherwise = goK m (k + 1)