\ https://www.codewars.com/kata/559e3224324a2b6e66000046/forth

: sumin-x ( n x -- result )
  0 rot rot 1 rot 1+ swap u+do  dup i min rot + swap loop drop ;

: sumin ( n -- result )
   0 swap dup 1+ 1 u+do dup i sumin-x rot + swap loop drop ;

: sumax-x ( n x -- result )
  0 rot rot 1 rot 1+ swap u+do  dup i max rot + swap loop drop ;

: sumax ( n -- result )
   0 swap dup 1+ 1 u+do dup i sumax-x rot + swap loop drop ;

: sum-x ( n x -- result )
  swap 0 rot rot 1+ 1 u+do dup i + rot + swap loop drop ;

: sumsum ( n -- result )
    0 swap dup 1+ 1 u+do dup i sum-x rot + swap loop drop ;