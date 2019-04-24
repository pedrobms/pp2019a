%1 -
odd(N) :-
  S is mod(N,2),
  S =\= 0.

%2 -
hasN([],0).
hasN([_|Xs], N) :-
  N > 0,
  N1 is N - 1,
  hasN(Xs, N1).

%3 -
inc99([],[]).
inc99([X|Xs], [Y|Ys]) :-
  Y is X + 99,
  inc99(Xs,Ys).

%4 -
incN([],[],_).
incN([X|Xs], [Y|Ys], N) :-
  Y is X + N,
  incN(Xs, Ys, N).

%5 -
comment([],[]).
comment([X|Xs],[Y|Ys]) :-
  string_concat(X, '%%', Y),
  comment(Xs, Ys).
