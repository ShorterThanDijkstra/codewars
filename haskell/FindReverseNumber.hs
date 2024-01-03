module ReverseNumber (findReverseNumber) where

import Debug.Trace (trace)

findReverseNumber :: Integer -> Integer
findReverseNumber 0 = 0
findReverseNumber n = go 0 0
  where
    go num i
      | isReverse num = if i == n - 1 then num else go (num + 1) (i + 1)
      | otherwise = go (num + 1) i
    isReverse num = reverse (show num) == show num

reverseNLen :: Int -> [Int]
reverseNLen n =
  let levels = go 0 [[i * 11 | i <- [1 .. 9]], [1 .. 9], [0]]
   in head levels
  where
    go i cache
      | i == n = cache
      | otherwise =
          let inner = collectInner (i - 2) 0 cache
           in go (i + 1) ([10 ^ (n - 1) * j + i * 10 + j | j <- [1 .. 9], i <- inner] : cache)
    collectInner n base cache
      | n <= 0 = [0]
      | otherwise = collectInner (n - 2) (base + 1) cache ++ map (\it -> it * 10 ^ base) (reverse cache !! n)

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