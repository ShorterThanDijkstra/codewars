
evaporator :: Double -> Double -> Double -> Integer
evaporator content evap_per_day threshold = go content (content * threshold / 100.0)
  where go content min | content < min = 0
                       | otherwise = 1 + go (content - content * evap_per_day / 100.0)  min