import Control.Arrow (Arrow (second))
import Debug.Trace (trace)

-- https://www.codewars.com/kata/55a29405bc7d2efaff00007c/train/haskell
truncate' :: Double -> Double
truncate' x = fromIntegral (floor (x * t)) / t
  where
    t = 10 ^ 6

going :: Integer -> Double
going n =
  truncate' $
    fst $
      foldl
        ( \(sum, acc) i ->
            let acc' = acc * i
             in (sum + 1.0 / fromIntegral acc', acc')
        )
        (1.0, 1)
        (reverse [2 .. n])