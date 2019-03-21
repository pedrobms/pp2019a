import Data.Char

--1 - Verifica se caracter e vogal
isVowel :: Char -> Bool
isVowel c = c=='a' || c=='e' || c=='i' || c=='o' || c=='u'

--2 - Adiciona uma virgula ao final de cada string
addComma :: [String] -> [String]
addComma s = map (\x -> x ++ ",") s

--3a - Retorna strings formatadas como itens de lista em HTML
htmlListItems :: [String] -> [String]
htmlListItems s = map (\x -> "<li>" ++ x ++ "<li>") s

--3b - Retorna strings formatadas como itens de lista em HTML
liFormat :: String -> String
liFormat s = "<li>"++ s ++"<li>"
liFormatList :: [String] -> [String]
liFormatList s = map liFormat s

--4a - Retorna string sem vogais
semVogais :: String -> String
semVogais s = filter (\c -> if c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U' then False else True) s

--4b - Retorna string sem vogais
removeVowel :: Char -> Bool
removeVowel c = if c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U' then False else True
semVogaisA :: String -> String
semVogaisA s = filter removeVowel s

--5a - Substitui qualquer letra por "-", mantendo os espaços
codifica  ::  String -> String
codifica s = map (\x -> if x == ' ' then ' ' else '-') s

--5b - Substitui qualquer letra por "-", mantendo os espaços
codificaC :: Char -> Char
codificaC c = if c == ' ' then ' ' else '-'
codificaA :: String -> String
codificaA s = map codificaC s

--6 - Retorna primeiro nome
firstName :: String -> String
firstName s = takeWhile (\x -> x/=' ') s

--7 - Verifica se string contem somente numeros
charIsInt :: Char -> Bool
charIsInt c = if (c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9') then True else False
isInt :: String -> Bool
isInt s = all charIsInt s

--8 - Retorna o ultimo sobrenome
lastName :: String -> String
lastName s = reverse (takeWhile (\x -> x /= ' ') (reverse s))

--9 - Cria nome de usuario com primeira letra do nome seguida do sobrenome, tudo em minúsculas.
toLowerString :: String -> String
toLowerString s = map toLower s
userName :: String -> String
userName s = toLowerString ([head s]++ lastName s)

--10 - Substitui vogais em uma string, conforme o esquema a seguir: a = 4, e = 3, i = 2, o = 1, u = 0.
encodeChar :: Char -> [Char]
encodeChar c
  |c == 'a' = "4"
  |c == 'e' = "3"
  |c == 'i' = "2"
  |c == 'o' = "1"
  |c == 'u' = "0"
  |c == 'A' = "4"
  |c == 'E' = "3"
  |c == 'I' = "2"
  |c == 'O' = "1"
  |c == 'U' = "0"
  |otherwise = [c]
encodeName :: String -> String
encodeName s = concat(map encodeChar s)

--11 - Substitui vogais em uma string, conforme o esquema a seguir: a = 4, e = 3, i = 2, o = 1, u = 00.
betterEncodeName :: String -> String
betterEncodeName s = concat(map (\x -> if x == 'u' || x == 'U' then "00" else encodeChar x) s)

