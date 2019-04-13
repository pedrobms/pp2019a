import Text.Printf

type Point  = (Float, Float)
type Rect   = (Point, Float, Float)
type Circle = (Point, Float)

-------------
-- Paletas --
-------------
rgbPalette :: Int -> [(Int,Int,Int)]
rgbPalette n = take n $ cycle [(255,0,0),(0,255,0),(0,0,255)]

greenPalette :: Int -> Int-> [(Int,Int,Int)]
greenPalette c l = [(0,80+i*10+j*2,0) | i <- [0..c], j <- [0..l]]

redPallete :: Int -> [(Int, Int, Int)]
redPallete c = [(80+i*10,0,0) | i <- [0..c]]

bluePallete :: Int -> [(Int, Int, Int)]
bluePallete c = [(0,0,80+i*10) | i <- [0..c]]

yellowPallete :: Int -> [(Int, Int, Int)]
yellowPallete c = [(80+i*10, 80+i*10, 0) | i <- [0..c]]

orangePallete :: Int -> [(Int, Int, Int)]
orangePallete c = [(60+i*10, 30+i*5, 0) | i <- [0..c]]

------------------------
-- Geração de figuras --
------------------------
-- Gera lista representando retângulos de acordo com quantidade de linhas, colunas, espaçamento e dimensões dos retângulos
genRect :: Int -> Int -> [Rect]
genRect c l = [((x*(w+gap), y*(h+gap)), w, h) | x <- [0..fromIntegral(c-1)], y <- [0..fromIntegral(l-1)]]
  where (w, h) = (50, 25)
        gap    = 5

-- Conversao de graus para radianos
degreeToRad :: Float -> Float -> Float
degreeToRad x n = ((x*360)/n)*(pi/180)

-- Gera lista representando circunferência de círculos de acordo com quantidade de círculos, raio dos círculos e raio da circunferência
genCircle1 :: Int -> [Circle]
genCircle1 n = [(((cos(degreeToRad x (fromIntegral n))*rC+300), (sin(degreeToRad x (fromIntegral n))*rC+300)), r) | x <- [0..fromIntegral(n-1)]]
  where r  = 20
        rC = 200

genCircle2 :: Float -> Float -> Int -> [Circle]
genCircle2 c l nC = [((((cos(degreeToRad i (fromIntegral nC))*10+(r+10*2)) + (gap*j)), ((sin(degreeToRad i (fromIntegral nC))*10+(r+10*2)) + (gap*k))), r) | i <- [0..fromIntegral(nC)], j <- [0..(c-1)], k <- [0..(l-1)]]
  where gap = r*3
        r   = 20

----------------
-- Strings SVG --
----------------
-- Gera string representando retângulo SVG 
-- dadas coordenadas e dimensoes do retângulo e uma string com atributos de estilo
svgRect :: Rect -> String -> String 
svgRect ((x,y),w,h) style = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' stroke='black' style='%s' />\n" x y w h style

-- Gera string representando círculos SVG 
-- dadas coordenadas e raio do círculo e uma string com atributos de estilo
svgCircle :: Circle -> String -> String 
svgCircle ((x,y),r) style = 
  printf "<circle cx='%.3f' cy='%.3f' r='%.3f' stroke='black' style='%s' />\n" x y r style

-- String inicial do SVG
svgBegin :: Float -> Float -> String
svgBegin w h = printf "<svg width='%.2f' height='%.2f' xmlns='http://www.w3.org/2000/svg'>\n" w h 

-- String final do SVG
svgEnd :: String
svgEnd = "</svg>"

-- Gera string com atributos de estilo para uma dada cor
-- Atributo mix-blend-mode permite misturar cores
svgStyle :: (Int,Int,Int) -> String
svgStyle (r,g,b) = printf "fill:rgb(%d,%d,%d); mix-blend-mode: screen;" r g b

-- Gera strings SVG para uma dada lista de figuras e seus atributos de estilo
-- Recebe uma funcao geradora de strings SVG, uma lista de círculos/retângulos e strings de estilo
svgElements :: (a -> String -> String) -> [a] -> [String] -> String
svgElements func elements styles = concat $ zipWith func elements styles

--------------------------------------
-- Funções geradoras de arquivo SVG --
--------------------------------------
genCase1 :: IO ()
genCase1 = do
  writeFile "case1.svg" $ svgstrs
  where svgstrs = svgBegin w h ++ svgfigs ++ svgEnd
        svgfigs = svgElements svgRect rects (map svgStyle palette)
        rects = genRect colunas linhas
        palette = greenPalette colunas linhas
        colunas = 10
        linhas = 20
        (w,h) = (1024,768) -- width,height da imagem SVG

genCase2 :: IO ()
genCase2 = do
  writeFile "case2.svg" $ svgstrs
  where svgstrs = svgBegin w h ++ svgfigs ++ svgEnd
        svgfigs = svgElements svgCircle circles (map svgStyle palette)
        circles = genCircle1 circulos
        palette = orangePallete circulos
        circulos = 5
        (w,h) = (1024,768) -- width,height da imagem SVG

genCase3 :: IO ()
genCase3 = do
  writeFile "case3.svg" $ svgstrs
  where svgstrs = svgBegin w h ++ svgfigs ++ svgEnd
        svgfigs = svgElements svgCircle circles (map svgStyle palette)
        circles = genCircle2 (fromIntegral colunas) (fromIntegral linhas) nCirc
        palette = rgbPalette (nCirc*colunas*linhas)
        nCirc   = 3
        colunas  = 5
        linhas = 5
        (w,h) = (1024,768) -- width,height da imagem SVG