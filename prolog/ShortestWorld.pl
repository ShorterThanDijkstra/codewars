% https://www.codewars.com/kata/57cebe1dc6fdc20c57000ac9/train/prolog
find_short(String, Result) :-
  split_string(String, " ", " ", L),
  find_min(L, Result).

find_min_iter([],Min,Min).
find_min_iter([H|T],Min,Res) :- 
  string_length(H,LenH),
  Min_ is min(Min,LenH),
  find_min_iter(T,Min_,Res).

find_min([],0).
find_min([H|T],Res) :- 
  string_length(H,Min),
<<<<<<< HEAD
  find_min_iter(T,Min,Res).
=======
  find_min_iter(T,Min,Res).
>>>>>>> 26cc087026310ef01c29e39b96730ac9dfd24ed0
