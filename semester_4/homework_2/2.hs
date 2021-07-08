f :: Int -> [Int]
f 0 = [1]
f 1 = [1,2]
f n = f(n-1) ++ [2^n]

main = print (f 10)
