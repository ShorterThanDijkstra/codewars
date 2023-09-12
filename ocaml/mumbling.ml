let rec accum_help s i res = 
  let next = res ^ 
             "-" ^ 
             String.make 1 (Char.uppercase_ascii s.[i]) ^
             String.make i (Char.lowercase_ascii s.[i])
  in if String.length s - 1 == i 
     then next
     else accum_help s (i + 1) next

let accum (s:string): string =
   match s with
    | "" -> ""
    | str -> accum_help str 1  (String.make 1 (Char.uppercase_ascii str.[0]))
