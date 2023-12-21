module ReverseEveryOtherWord (reverseEveryOther) where

reverseEveryOther :: String -> String
reverseEveryOther s = unwords $ map (\(f, word) ->f word) (zip  (cycle [id, reverse]) (words s))