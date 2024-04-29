-- https://www.codewars.com/kata/57c18a16c82ce75f4b000020/train/haskell
import Data.Char (ord)
import Data.List (elemIndex)
import Data.Maybe (fromJust)
import Debug.Trace (trace)

countDigit :: String -> Char -> Int -> Int -> Int
countDigit s digit toBase fromBase = let num = parseInt s fromBase
                                         num2 = toString num toBase 
                                     in length $ filter (digit==) num2

parseInt :: [Char] -> Int -> Int
parseInt s base = foldl (\acc a -> acc * base + fromJust (elemIndex a charMap)) 0 s

charMap :: [Char]
charMap = ['0'..'9'] ++ ['a' .. 'z']

toString :: Int -> Int -> [Char]
toString 0 _ = "0"
toString i b = build "" i 
   where build acc 0 = acc 
         build acc i = let idx = i `mod` b 
                           c = charMap !! idx 
                       in build (c:acc) (i `div` b)