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

instance Monad (Reader cfg) where
  return :: a -> Reader cfg a
  return a = Reader $ \cfg -> a

  (>>=) :: Reader cfg a -> (a -> Reader cfg b) -> Reader cfg b
  (Reader run1) >>= f = Reader $ \cfg ->
    let a = run1 cfg
        (Reader run2) = f a
     in run2 cfg

instance (Monoid w) => Monad (Writer w) where
  return :: (Monoid w) => a -> Writer w a
  return a = Writer (mempty, a)
  (>>=) :: (Monoid w) => Writer w a -> (a -> Writer w b) -> Writer w b
  (Writer (s1, a)) >>= f =
    let (Writer (s2, b)) = f a
     in Writer (s1 <> s2, b)