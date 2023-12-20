module Codewars.BackspacesInString where
import Distribution.Simple.Utils (safeTail)

cleanString :: String -> String
cleanString = clean []

clean :: String -> String -> String
clean stack [] = reverse stack
clean stack ('#':cs) = clean (safeTail stack) cs
clean stack (c:cs) = clean (c:stack) cs