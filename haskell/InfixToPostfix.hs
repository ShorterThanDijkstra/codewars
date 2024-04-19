module InfixToPostfix where

import Control.Monad.State (State)
import Data.Char (ord, chr)
import Debug.Trace (trace)
import Text.Read (Lexeme (String))

-- 左结合+优先级：
--  Expr -> Add
--  Add -> Add + Mul
--  Add -> Mul
--  Mul -> Mul * Expo
--  Mul -> Expo
--  Expo -> Term ^ Expo
--  Expo -> Term
--  Term -> Int
--  Term -> (Expr)

-- 消除左递归：
--  Expr -> Add
--  Add -> Mul Add'
--  Add' -> + Mul Add'
--  Add' -> epsilon
--  Mul -> Expo Mul'
--  Mul' -> * Expo Mul'
--  Mul' -> epsilon
--  Expo -> Term ^ Expo
--  Expo -> Term
--  Term -> Int
--  Term -> (Expr)

data Expr = Add Expr Expr | Sub Expr Expr | Mul Expr Expr | Div Expr Expr | Expo Expr Expr | Term Int deriving (Show)

parseExpr :: String -> (String, Expr)
parseExpr = parseAddSub

parseAddSub :: String -> (String, Expr)
parseAddSub s =
  let (s1, muldiv) = parseMulDiv s
   in parseAddSub' muldiv s1

parseAddSub' :: Expr -> String -> (String, Expr)
parseAddSub' expr ('+' : s) =
  let (s1, muldiv) = parseMulDiv s
   in parseAddSub' (Add expr muldiv) s1
parseAddSub' expr ('-' : s) =
  let (s1, muldiv) = parseMulDiv s
   in parseAddSub' (Sub expr muldiv) s1
parseAddSub' expr s = (s, expr)

parseMulDiv :: String -> (String, Expr)
parseMulDiv s =
  let (s1, expo) = parseExpo s
   in parseMulDiv' expo s1

parseMulDiv' :: Expr -> String -> (String, Expr)
parseMulDiv' expr ('*' : s) =
  let (s1, expo) = parseExpo s
   in parseMulDiv' (Mul expr expo) s1
parseMulDiv' expr ('/' : s) =
  let (s1, expo) = parseExpo s
   in parseMulDiv' (Div expr expo) s1
parseMulDiv' expr s = (s, expr)

parseExpo :: String -> (String, Expr)
parseExpo s =
  let (s1, base) = parseTerm s
   in case s1 of
        ('^' : s2) ->
          let (s3, power) = parseExpo s2
           in (s3, Expo base power)
        _ -> (s1, base)

parseTerm :: String -> (String, Expr)
parseTerm (c : s)
  | c <= '9' && c >= '0' = (s, Term (ord c - ord '0'))
  | c == '(' =
      let (')' : s1, e) = parseExpr s
       in (s1, e)
  | otherwise = error $ c : s

toPostfix :: String -> String
toPostfix s =
  let ("", expr) = parseExpr s
   in reverse $ toPostfix' [] expr

toPostfix' :: [Char] -> Expr -> [Char]
toPostfix' stack (Add l r) = '+' : (toPostfix' $ toPostfix'  stack l)  r
toPostfix' stack (Sub l r) = '-' : (toPostfix' $ toPostfix' stack l) r
toPostfix' stack (Mul l r) = '*' : (toPostfix' $ toPostfix' stack l) r
toPostfix' stack (Div l r) = '/' : (toPostfix' $ toPostfix' stack l) r
toPostfix' stack (Expo b p) = '^' : (toPostfix' $ toPostfix' stack b) p
toPostfix' stack (Term v) = chr (v + ord '0') : stack
