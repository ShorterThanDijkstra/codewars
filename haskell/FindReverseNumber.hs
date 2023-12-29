module ReverseNumber (findReverseNumber) where

findReverseNumber :: Integer -> Integer
findReverseNumber 0 = 0
findReverseNumber n = go 0 0
  where go num i | isReverse num = if i == n - 1 then num else  go (num + 1) (i + 1)
                 | otherwise = go (num + 1) i
        isReverse num = reverse (show num) == show num

reverseNLen n = go 0
  where go i | reverse (show i) == show i = if length (show i) > n then [] 
                                            else if length (show i) == n then i : go (i + 1)
                                            else go (i + 1)
             | otherwise = go (i + 1)