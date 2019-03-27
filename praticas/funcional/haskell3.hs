-- 1
add10toall :: [Int] -> [Int]
add10toall li = [x + 10 | x <- li]

--2
multN :: Int -> [Int] -> [Int]
multN n li = [x*n | x <- li]

--3
applyExpr :: [Int] -> [Int]
applyExpr li = [3*x+2 | x <- li]

--4
addSuffix :: String -> [String] -> [String]
addSuffix sf ls = [x ++sf | x <- ls]

--5
selectgt5 :: [Int] -> [Int]
selectgt5 li = [x | x <- li, x > 5]

--6
sumOdds :: [Int] -> Int
sumOdds li = sum [x | x <- li, x `mod` 2 /= 0]

--7
selectExpr :: [Int] -> [Int]
selectExpr li = [x | x <- li, x > 19 && x < 51] 

--8
countShorts :: [String] -> Int
countShorts ls = length [x | x <- ls, length x < 6]

--9
calcExpr :: [Float] -> [Float]
calcExpr lf = filter (\x -> x >10) [x^2/2 | x <-lf]

--10
trSpaces :: String -> String
trSpaces s = [if x == ' ' then '-' else x | x <- s]

--13
dotProd :: [Int] -> [Int] -> Int
dotProd liA liB = sum [fst x * snd x | x <- zip liA liB]

--15
dotProdA :: [Int] -> [Int] -> Int
dotProdA liA liB = sum (zipWith (\x y -> x*y) liA liB)