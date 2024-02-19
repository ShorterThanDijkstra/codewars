% https://www.codewars.com/kata/56dbe0e313c2f63be4000b25/train/prolog
vert_mirror(String, Result) :- split(String, Tmp), maplist(reverse, Tmp, Tmp1),  writeln(Tmp1),join(Tmp1, Result).
hor_mirror(String, Result) :- split(String, Tmp),reverse(Tmp, Result).

split(S,R) :- split_string(S,"\n","",R).
join([S],S).
join([S|SS],R):-join(SS,R1),string_concat("\n",R1,R2),string_concat(S,R2,R).