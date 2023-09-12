let rec good_count str i = 
  if String.length str == i 
  then 0 
  else let c = str.[i] 
       in if c <= 'm' && c >= 'a' 
          then 1 + good_count str (i + 1)
          else good_count str (i + 1)

let printer_error(s: string): string = 
  let len = String.length s 
  in let err =  len - good_count s 0
     in string_of_int err ^ "/" ^ string_of_int len
