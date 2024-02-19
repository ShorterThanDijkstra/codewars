% https://www.codewars.com/kata/54da539698b8a2ad76000228/train/prolog
walk([],(0,0)).
walk(['n'|T],(V,H)) :-
  V1 is V + 1,
  walk(T,(V1,H)).
walk(['s'|T],(V,H)) :-
  V1 is V - 1,
  walk(T,(V1,H)).
walk(['w'|T],(V,H)) :-
  H1 is H - 1,
  walk(T,(V,H1)).
walk(['e'|T],(V,H)) :-
  H1 is H + 1,
  walk(T,(V,H1)).

is_valid_walk(Walk) :- 
  length(Walk,10),
  walk(Walk,(0,0)).