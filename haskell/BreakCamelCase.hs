module Codewars.Kata.BreakCamelCase where

import           Data.Char

solution :: String -> String
solution cs = dropWhile isSpace $ go cs
  where
    go [] = ""
    go (c:cs)
      | isUpper c = ' ' : toUpper c : go cs
      | otherwise = c : go cs
