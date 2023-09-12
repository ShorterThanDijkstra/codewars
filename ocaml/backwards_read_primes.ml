let is_prime x = 
  match x with
  | 1 -> false
  | _ -> let rec help i = 
            match i with 
              1 -> true
              | _ -> (x mod i != 0) && help (i - 1)
         in help (int_of_float (sqrt (float_of_int x)))

let backwards x = let rec help num res = 
      match num with
            | 0 -> res
            | _ -> help (num / 10) (res * 10 + num mod 10)
      in help x 0

let backwards_prime (m: int) (n: int): int list =
  let range = List.init (n - m + 1) (fun i -> m + i)
        in let primes = List.filter is_prime range
           in List.filter (fun x -> let bw = backwards x in bw != x && is_prime bw) primes
                