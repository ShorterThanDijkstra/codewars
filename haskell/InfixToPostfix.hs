module InfixToPostfix where

import Control.Monad.State (State)
import Data.Char (ord)
import Text.Read (Lexeme (String))

-- Expr = (Expr)
-- Expr = Num
-- Expr = Expr Op Expr

data Expr = Value Int | Add Expr Expr | Sub Expr Expr | Mul Expr Expr | Div Expr Expr | Expo Expr Expr deriving (Show)

parseParentheses :: String -> (String, Expr)
parseParentheses s =
  let (s', e) = parseExpr s
   in (tail s', e)

parseOp :: String -> (String, Expr -> Expr -> Expr)
parseOp ('+' : rest) = (rest, Add)
parseOp ('-' : rest) = (rest, Sub)
parseOp ('*' : rest) = (rest, Mul)
parseOp ('/' : rest) = (rest, Div)
parseOp ('^' : rest) = (rest, Expo)

isOpStart (c : _) = c == '+' || c == '-' || c == '*' || c == '/' || c == '^'

parseExpr :: String -> (String, Expr)
parseExpr (c : s)
  | c == '(' = parseParentheses s
  | c <= '9' && c >= '0' =
      let d = ord c - ord '0'
          l = Value d
       in if isOpStart s
          then
              let (s', op) = parseOp s
               in let (s'', r) = parseExpr s'
                   in (s'', op l r)
          else (s, l)
            

toPostfix :: String -> String
toPostfix = undefined