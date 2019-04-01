{-
   Programa em Haskell para validar os digitos de um CPF
   Mais info em: http://pt.wikipedia.org/wiki/Cadastro_de_Pessoas_F%C3%ADsicas
-}
import Data.Char


expr1 :: [Int] -> Int 
expr1 li = (sum $ zipWith (*) [x | x <- take 9 li] [10, 9..2]) `mod` 11

expr2 :: [Int] -> Int 
expr2 li = (sum $ zipWith (*) [x | x <- take 10 li] [11, 10..2]) `mod` 11

isCpfOk :: [Int] -> Bool
isCpfOk cpf = dv1 == cpf !! 9 && dv2 == cpf !! 10
  where dv1 = if (expr1 cpf) < 2 then 0 else 11-(expr1 cpf)
        dv2 = if (expr2 cpf) < 2 then 0 else 11-(expr2 cpf)

main = do
   putStr "CPF: "
   cpf <- getLine
   let digits = (map digitToInt cpf)
   putStrLn (if isCpfOk digits then "OK" else "Not OK") 
   