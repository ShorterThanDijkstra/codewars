import Data.Char (ord)
countDigit :: String -> Char -> Int -> Int -> Int
countDigit s c i b = let i1 = parseInt s 
                         i2 = toString i1 b 
                     in length $ filter (c==) i2

parseInt :: [Char] -> Int
parseInt  = foldl (\acc a -> acc * 10 + ord a - ord '0') 0 

charMap :: [Char]
charMap = ['0'..'9'] ++ ['a' .. 'z']

toString :: Int -> Int -> [Char]
toString i b = build "" i 
   where build acc 0 = acc 
         build acc i = let idx = i `mod` b 
                           c = charMap !! idx 
                       in build (c:acc) (i `div` b)