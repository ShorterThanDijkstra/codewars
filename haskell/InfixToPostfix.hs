module InfixToPostfix where

import Control.Monad.State (State)
import Data.Char (ord)
import Text.Read (Lexeme (String))

--  Expr -> AddSub
--  AddSub -> AddSub + MulDiv
--  AddSub -> MulDiv
--  MulDiv -> MulDiv * Term
--  MulDiv -> Term
--  Term -> Int

newtype Term = Term Int 

data MulDiv = MulDivTerm Term | Mul MulDiv Term | Div MulDiv Term

data AddSub = AddSubMulDiv MulDiv | Add AddSub MulDiv | Sub AddSub MulDiv

newtype Expr = Expr AddSub
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