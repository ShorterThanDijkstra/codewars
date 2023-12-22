module Codewars.G964.Scramblies where

import Data.Map (Map, empty, insert, lookup)

scramble :: [Char] -> [Char] -> Bool
scramble s1 s2 =
  let m = buildMap s1
   in go s2 m
  where
    go [] m = True
    go (c : cs) m = case Data.Map.lookup c m of
      Nothing -> False
      Just v -> v > 0 && (let m' = insert c (v - 1) m in go cs m')

buildMap :: [Char] -> Map Char Int
buildMap =
  Prelude.foldl
    ( \acc c -> case Data.Map.lookup c acc of
        Nothing -> insert c 1 acc
        Just v -> insert c (v + 1) acc
    )
    empty