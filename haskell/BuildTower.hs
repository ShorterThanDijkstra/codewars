module Codewars.BuildTower where

buildTower :: Int -> [String]
buildTower 0 = []
buildTower n = build 1 (n - 1) (2 * n - 1)
  where
    build star space max
      | star == max = [replicate star '*']
      | otherwise =
          ( replicate space ' '
              ++ replicate star '*'
              ++ replicate space ' '
          )
            : build (star + 2) (space - 1) max