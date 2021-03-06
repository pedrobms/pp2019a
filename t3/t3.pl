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

%6 -
onlyEven([],[]).
onlyEven([X|Xs],[Y|Ys]) :-
  N1 is mod(X, 2),
  N1 =:= 0,
  Y is X,
  onlyEven(Xs, Ys), !.

onlyEven([_|Xs], L2) :-
  onlyEven(Xs, L2).

%7 -
countdown(0, []).
countdown(N, [X|Xs]) :-
  N > 0,
  X is N,
  N1 is N-1,
  countdown(N1, Xs).

%8 -
nRandoms(0,[]).
nRandoms(N,[X|Xs]) :-
  N > 0,
  random(0, 100, X),
  N1 is N-1,
  nRandoms(N1, Xs).

%9 -
potN0(0, []).
potN0(N, [X|Xs]) :-
  N > 0,
  X is 2^N,
  N1 is N-1,
  potN0(N1, Xs), !.

%10 -
zipmult([],[],[]).
zipmult([X|Xs],[Y|Ys],[Z|Zs]) :-
  Z is X*Y,
  zipmult(Xs, Ys, Zs).

%11 -
pot(_,0,[]).
pot(E,N,[X|Xs]) :-
  X is 2^E,
  E1 is E+1,
  N1 is N-1,
  pot(E1,N1,Xs), !.

potencias(N, L) :-
  N >= 0,
  pot(0,N,L), !.

%12 -
cedulas(_, [], []).
cedulas(V, [X|Xs], [Y|Ys]) :-
  V >= 0,
  Y is floor(V/X),
  V1 is V - Y * X,
  cedulas(V1, Xs, Ys), !.
