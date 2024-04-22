-- https://www.codewars.com/kata/547202bdf7587835d9000c46/train/haskell
{-# LANGUAGE NoImplicitPrelude #-}

module Monads where

import Data.Monoid
import Prelude hiding (Identity, Maybe (..), Monad, Reader, State, Writer)

class Monad m where
  return :: a -> m a
  (>>=) :: m a -> (a -> m b) -> m b

data Identity a = Identity a
  deriving (Show, Eq)

data Maybe a = Nothing | Just a
  deriving (Show, Eq)

data State s a = State {runState :: s -> (a, s)}

data Reader s a = Reader {runReader :: s -> a}

data Writer w a = Writer {runWriter :: (w, a)}

instance Monad Identity where
  return = Identity
  (Identity v) >>= f = f v

instance Monad Maybe where
  return = Just
  Nothing >>= f = Nothing
  (Just v) >>= f = f v

instance Monad (State s) where
  return a = State $ \s -> (a, s)
  (State g) >>= f = State $ \s ->
    let (a, s1) = g s
        (State h) = f a
     in h s1

instance Monad (Reader s) where
  return = undefined
  (Reader g) >>= f = undefined

instance (Monoid w) => Monad (Writer w) where
  return = undefined
  (Writer (s, v)) >>= f = undefined
