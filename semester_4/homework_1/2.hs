fibonachi :: Int -> Int
fibonachi 1 = 1
fibonachi 2 = 1
fibonachi n = fibonachi(n - 1) + fibonachi(n - 2)
          
main = print (fibonachi 7)
