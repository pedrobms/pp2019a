% Exemplo de programa em Prolog que define
% fatos e regras sobre pessoas e localizacoes geograficas.

localizado_em(santa_maria, rs).
localizado_em(salvador, bahia).
localizado_em(rs, brasil).
localizado_em(bahia, brasil).
localizado_em(paris, franca).
localizado_em(franca, europa).

nasceu_em(andre, santa_maria).
nasceu_em(joao, salvador).
nasceu_em(joana, salvador).
nasceu_em(michel, paris).
nasceu_em(X, Y) :- localizado_em(Z, Y), nasceu_em(X, Z).

mora_em(andre, paris).
mora_em(joao, salvador).
mora_em(X, Y) :- localizado_em(Z, Y), mora_em(X, Z).

idade(andre, 25).
idade(joao, 32).
idade(joana, 22).
idade(michel, 40).

gaucho(X) :- nasceu_em(X, rs).
brasileiro(X) :- nasceu_em(X, brasil).
europeu(X) :- nasceu_em(X, europa).

maisVelho(A, B) :- idade(A, X), idade(B, Y), X > Y.

soma(A,B,C) :- C is A + B. 
pred(A,B,C) :- X is (A+B)^2, C is X*2+1.

anoNasc(P, A) :- idade(P, X), A is 2019 - X.

isVowel(X) :- member(X, [a, e, i, o, u]).