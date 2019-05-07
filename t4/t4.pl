relacionamento(anita, bernardo).
relacionamento(bernardo, caren).
relacionamento(anita, pedro).
relacionamento(pedro, alice).
relacionamento(adriano, caren).

pobre(bia).
pobre(pedro).
pobre(maria).
pobre(bernardo).

insano(adriano).
insano(maria).

localizacao(pedro, segunda, staMaria).
localizacao(pedro, terca, staMaria).
localizacao(pedro, quarta, portoAlegre).
localizacao(pedro, quinta, staMaria).
localizacao(pedro, sexta, apto).

localizacao(caren, segunda, portoAlegre).
localizacao(caren, terca, portoAlegre).
localizacao(caren, quarta, portoAlegre).
localizacao(caren, quinta, staMaria).
localizacao(caren, sexta, apto).

localizacao(henrique, segunda, apto).
localizacao(henrique, terca, portoAlegre).
localizacao(henrique, quarta, apto).
localizacao(henrique, quinta, apto).
localizacao(henrique, sexta, apto).

localizacao(bia, segunda, apto).
localizacao(bia, terca, portoAlegre).
localizacao(bia, quarta, portoAlegre).
localizacao(bia, quinta, staMaria).
localizacao(bia, sexta, apto).

localizacao(adriano, segunda, apto).
localizacao(adriano, terca, apto).
localizacao(adriano, quarta, staMaria).
localizacao(adriano, quinta, apto).
localizacao(adriano, sexta, apto).

localizacao(alice, segunda, apto).
localizacao(alice, terca, portoAlegre).
localizacao(alice, quarta, portoAlegre).
localizacao(alice, quinta, apto).
localizacao(alice, sexta, apto).

localizacao(bernardo, segunda, staMaria).
localizacao(bernardo, terca, staMaria).
localizacao(bernardo, quarta, portoAlegre).
localizacao(bernardo, quinta, staMaria).
localizacao(bernardo, sexta, apto).

localizacao(maria, segunda, apto).
localizacao(maria, terca, staMaria).
localizacao(maria, quarta, staMaria).
localizacao(maria, quinta, staMaria).
localizacao(maria, sexta, apto).

bastao(X) :-
  localizacao(X, quinta, portoAlegre);
  localizacao(X, quarta, staMaria).

martelo(X) :-
  localizacao(X, quarta, apto);
  localizacao(X, quinta, apto).

chave(X) :-
  localizacao(X, segunda, staMaria);
  localizacao(X, terca, portoAlegre).

ciumes(X) :-
  relacionamento(anita, Y),
  relacionamento(Y, X).

motivo(X) :-
  pobre(X);
  ciumes(X);
  insano(X).

arma(X) :-
  bastao(X);
  martelo(X).

noApto(X) :-
  localizacao(X, quinta, apto);
  localizacao(X, sexta, apto).

acesso(X) :-
  arma(X),
  chave(X),
  noApto(X).

assassino(X) :-
  motivo(X),
  acesso(X), !.
