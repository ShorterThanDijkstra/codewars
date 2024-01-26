rot_i(N, I, R) :-
  Left is N div (10 ^ I),
  Right is N mod (10 ^ (I - 1)),
  Mid is (N mod (10 ^ I)) div (10 ^ (I - 1)),
  R is Left * (10 ^ I) + Right * 10 + Mid.

rot_iter(N,Max,1,Res) :- Res is max(Max,N).

rot_iter(N,Max,I,Res) :-
  rot_i(N,I,N1),
  I1 is I - 1,
  Max1 is max(Max,N1),
  rot_iter(N1,Max1,I1,Res).

len_n_iter(0,Acc,Acc).
len_n_iter(N,Acc,Len) :-
  N > 0,
  N1 is N div 10,
  Acc1 is Acc + 1,
  len_n_iter(N1,Acc1,Len).

len_n(N,Len) :- len_n_iter(N, 0, Len). 

maxrot(N,Max) :-
  len_n(N,I),
  rot_iter(N,N,I,Max).