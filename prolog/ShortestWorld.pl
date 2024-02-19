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
  find_min_iter(T,Min,Res).