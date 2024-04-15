module InfixToPostfix where

import Control.Monad.State (State)
import Data.Char (ord)
import Debug.Trace (trace)
import Text.Read (Lexeme (String))

-- 左结合+优先级：
--  Expr -> Add
--  Add -> Add + Mul
--  Add -> Mul
--  Mul -> Mul * Term
--  Mul -> Term
--  Term -> Int

-- 消除左递归：
--  Expr -> Add
--  Add -> Mul Add'
--  Add' -> + Mul Add'
--  Add' -> epsilon
--  Mul -> Term Mul'
--  Mul' -> * Term Mul'
--  Mul' -> epsilon
--  Term -> Int

newtype Expr = Expr AddSub deriving (Show)

data AddSub = AddSub MulDiv AddSub' deriving (Show)

data AddSub' = Add MulDiv AddSub' | Sub MulDiv AddSub' | AddSubEmpty' deriving (Show)

data MulDiv = MulDiv Term MulDiv' deriving (Show)

data MulDiv' = Mul Term MulDiv' | Div Term MulDiv' | MulDivEmpty' deriving (Show)

newtype Term = Term Int deriving (Show)

parseExpr :: String -> Expr
parseExpr s =
  let ("", e) = parseAddSub s
   in Expr e

parseAddSub :: String -> (String, AddSub)
parseAddSub s =
  let (s1, muldiv) = parseMulDiv s
      (s2, addsub') = parseAddSub' s1
   in (s2, AddSub muldiv addsub')

parseAddSub' :: String -> (String, AddSub')
parseAddSub' [] = ("", AddSubEmpty')
parseAddSub' (c : s) 
  | c == '+' || c == '-' = 
  let (s1, muldiv) = parseMulDiv s
      (s2, addsub') = parseAddSub' s1
   in (s2, op c muldiv addsub')

  | otherwise = (c:s,  AddSubEmpty')
  where
    op '+' = Add
    op '-' = Sub
parseMulDiv :: String -> (String, MulDiv)
parseMulDiv s =
  let (s1, term) = parseTerm s
      (s2, muldiv') = parseMulDiv' s1
   in (s2, MulDiv term muldiv')

parseMulDiv' :: String -> (String, MulDiv')
parseMulDiv' [] = ("", MulDivEmpty')
parseMulDiv' (c : s)
  | c == '*' || c == '/' =
      let (s1, term) = parseTerm s
          (s2, muldiv') = parseMulDiv' s1
       in (s2, op c term muldiv')
  | otherwise = (c : s, MulDivEmpty')

  where
    op '*' = Mul
    op '/' = Div

parseTerm :: String -> (String, Term)
parseTerm (c : s) | c <= '9' && c >= '0' = (s, Term (ord c - ord '0'))

-- parseParentheses :: String -> (String, Expr)
-- parseParentheses s =
--   let (s1, e) = parseExpr s
--    in (tail s1, e)

-- parseOp :: String -> (String, Expr -> Expr -> Expr)
-- parseOp ('+' : rest) = (rest, Add)
-- parseOp ('-' : rest) = (rest, Sub)
-- parseOp ('*' : rest) = (rest, Mul)
-- parseOp ('/' : rest) = (rest, Div)
-- parseOp ('^' : rest) = (rest, Expo)

-- isOpStart :: [Char] -> Bool
-- isOpStart [] = False
-- isOpStart (c : _) = c == '+' || c == '-' || c == '*' || c == '/' || c == '^'

-- parseTerm :: String -> (String, Expr)
-- parseTerm (c:s) | c <= '9' && c >= '0'
-- parseExpr :: String -> (String, Expr)
-- parseExpr [] = error "bad input"
-- parseExpr (c : s)
--   | c <= '9' && c >= '0' && null s = ("", Value $ ord c - ord '0')

--   | c == '(' =
--       withRightOrDefault $ parseParentheses s
--   | otherwise = let (s1, l) = parseExpr (c:s)
--                     (s2, op) = parseOp s1
--                     (s3, r) = parseExpr s2
--                 in (s3, op l r)
--   where
--     withRightOrDefault (s, l) =
--       if isOpStart s
--         then
--           let (s1, op) = parseOp s
--               (s2, r) = parseExpr s1
--            in (s2, op l r)
--         else (s, l)

toPostfix :: String -> String
toPostfix = undefined