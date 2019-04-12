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
------------------------
-- Geração de figuras --
------------------------
genRect :: Int -> Int -> [Rect]
genRect c l = [((x*(w+gap), y*(h+gap)), w, h) | x <- [0..fromIntegral(c-1)], y <- [0..fromIntegral(l-1)]]
  where (w, h) = (50, 25)
        gap    = 5

----------------
-- String SVG --
----------------

-- Gera string representando retângulo SVG 
-- dadas coordenadas e dimensoes do retângulo e uma string com atributos de estilo
svgRect :: Rect -> String -> String 
svgRect ((x,y),w,h) style = 
  printf "<rect x='%.3f' y='%.3f' width='%.2f' height='%.2f' style='%s' />\n" x y w h style

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
        linhas = 5
        (w,h) = (1500,1500) -- width,height da imagem SVG