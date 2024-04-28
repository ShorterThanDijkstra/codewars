-- https://www.codewars.com/kata/543d218022e0f307fb000173/train/haskell
module FoldMapAllTheThings where

import Data.Foldable (foldMap, Foldable)
import Data.Monoid

myToList :: Foldable t => t a -> [a]
myToList = foldMap $ \x -> [x]

data MaxMin a = Max | Min a 
instance (Ord a) => Semigroup (MaxMin a) where
    (<>) :: (Ord a) => MaxMin a -> MaxMin a -> MaxMin a
    (Min a) <> (Min b) = if a < b then Min a else Min b
    _ <> m@(Min a) = m
    m@(Min a) <> _ = m

instance (Ord a) => Monoid (MaxMin a) where
    mempty :: Ord a => MaxMin a
    mempty = Max
    mappend :: Ord a => MaxMin a -> MaxMin a -> MaxMin a
    mappend = (<>)
   
myMinimum :: (Ord a, Foldable t) => t a -> Maybe a
myMinimum ta = case foldMap Min ta of Max -> Nothing
                                      Min a -> Just a

newtype Acc a = Acc (a -> a)

instance Semigroup (Acc a) where
    (<>) :: Acc a -> Acc a -> Acc a
    Acc a <> Acc b = Acc (\x -> a $ b x)

instance Monoid (Acc a) where
    mempty :: Acc a
    mempty = Acc (\x -> x)
    mappend :: Acc a -> Acc a -> Acc a
    mappend = (<>)


myFoldr :: Foldable t => (a -> b -> b) -> b -> t a -> b
myFoldr f init ta = let (Acc acc) = foldMap (\a -> Acc $ f a) ta
                    in acc init