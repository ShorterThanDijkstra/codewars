module InfixToPostfix where
import Text.Read (Lexeme(String))
import Control.Monad.State (State)
import Data.Char (ord)

data Expr = Value Int | Add Expr Expr | Sub Expr Expr | Mul Expr Expr | Div Expr Expr | Expo Expr Expr

parseParentheses :: String -> (String, Expr)
parseParentheses s = let (s', e) = parseExpr s
                     in (tail s', e)

parseExpr :: String -> (String, Expr)
parseExpr (c:s) | c == '(' =  parseParentheses s
                | c <= '9' && c >= '0' = 
                    let d =  ord c - ord '0' 
                    in (s, Value d)
                

toPostfix :: String -> String
toPostfix = undefined