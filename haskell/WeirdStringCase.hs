module WeIrDStRiNgCaSe where

import           Data.Char

toWeirdCase :: String -> String
toWeirdCase str =
  let ws = words str
      zipped = map (\w -> zip [0 .. length w] w) ws
   in unwords $ map (map mapper) zipped
  where
    mapper =
      \(i, c) ->
        if i `mod` 2 == 0
          then toUpper c
          else toLower c
