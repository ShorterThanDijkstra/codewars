-- https://www.codewars.com/kata/525c65e51bf619685c000059/train/haskell
type Ingredient = String

type Amount = Int

type Recipe = [(Ingredient, Amount)]

type Storage = [(Ingredient, Amount)]

cakes :: Recipe -> Storage -> Int
cakes recipe storage =
  minimum $
    map
      ( \(ingred, amount) -> case lookup ingred storage of
          Nothing -> 0
          Just v -> v `div` amount
      )
      recipe
