module RemoveDuplicateWords where

removeDuplicateWords :: String -> String
removeDuplicateWords s = unwords $ remove [] $ words s
  where
    remove res [] = reverse res
    remove res (w:ws)
      | w `elem` res = remove res ws
      | otherwise =remove (w: res) ws
