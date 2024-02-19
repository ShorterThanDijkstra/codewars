% https://www.codewars.com/kata/51fd6bc82bc150b28e0000ce/train/prolog
% no_odds_iter([],Acc,Res) :- reverse(Acc,Res).
% no_odds_iter([H|T],Acc,Res) :-
%   0 is H mod 2,
%   no_odds_iter(T,[H|Acc],Res).
% no_odds_iter([H|T],Acc,Res) :-
%   not(0 is H mod 2),
%   no_odds_iter(T,Acc,Res).

% no_odds(Values, Result) :- no_odds_iter(Values,[],Result).

no_odds([], []).
no_odds([H|T], Result) :-
  1 is H mod 2,
  no_odds(T, Result).
no_odds([H|T], [H|TResult]) :-
  0 is H mod 2,
  no_odds(T, TResult).