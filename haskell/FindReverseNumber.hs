module ReverseNumber (findReverseNumber) where

import Data.Char (digitToInt)

findReverseNumber :: Integer -> Integer
findReverseNumber 1 = 0
findReverseNumber n =
  let (level, offset) = findLevel $ n - 1
   in mirror level offset

mirror :: Integer -> Integer -> Integer
mirror level offset =
  let base = if even level then level `div` 2 - 1 else (level + 1) `div` 2 - 1
      offset' = offset + 10 ^ base
      part1 = show offset'
      part2 = if even level then reverse part1 else tail (reverse part1)
   in read $ part1 ++ part2

findLevel :: Integer -> (Integer, Integer)
findLevel 0 = (0, 0)
findLevel n = go n (toInteger 1) (toInteger 9)
  where
    go n i bound
      | n <= bound = (i, n - 1)
      | odd i = go (n - bound) (i + 1) bound
      | otherwise = go (n - bound) (i + 1) (10 * bound)

reverseNLen :: Int -> [Int]
reverseNLen n =
  let levels = go 3 [[i * 11 | i <- [1 .. 9]], [1 .. 9], [0]]
   in reverse levels !! n
  where
    go n' cache
      | n' > n = cache
      | otherwise =
          let inner = collectInner (n' - 2) 0 cache
              new = [10 ^ (n' - 1) * j + i * 10 + j | j <- [1 .. 9], i <- inner]
           in go (n' + 1) (new : cache)
    collectInner n base cache
      | n <= 0 = [0]
      | otherwise =
          collectInner (n - 2) (base + 1) cache
            ++ map (\it -> it * 10 ^ base) (reverse cache !! n)

findReverseNumber' :: Integer -> Integer
findReverseNumber' 0 = 0
findReverseNumber' n = go 0 0
  where
    go num i
      | isReverse num = if i == n - 1 then num else go (num + 1) (i + 1)
      | otherwise = go (num + 1) i
    isReverse num = reverse (show num) == show num

reverseNLen' :: Int -> [Int]
reverseNLen' n = go 0
  where
    go i
      | reverse (show i) == show i =
          if length (show i) > n
            then []
            else
              if length (show i) == n
                then i : go (i + 1)
                else go (i + 1)
      | otherwise = go (i + 1)