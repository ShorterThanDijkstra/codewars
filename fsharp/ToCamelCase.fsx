// https://www.codewars.com/kata/517abf86da9663f1d2000003/train/fsharp

let split (delimiters: Set<char>) (text: string) : string list =
    let rec go res starts len =
        let ends = starts + len in

        if ends >= text.Length then
            if starts < text.Length then
                text.Substring starts :: res
            else
                res
        elif delimiters.Contains(text.Chars ends) then
            go (text.Substring(starts, len) :: res) (ends + 1) 0
        else
            go res starts (len + 1) in

    go [] 0 0 |> List.filter (fun s -> s.Length > 0) |> List.rev

let toCamelCase (text: string) : string =
    let ds = Set.ofList [ '-'; '_' ] in
    let split' = split ds text in

    if split'.Length = 0 then
        ""
    else
        let uppers =
            List.head split'
            :: (List.map
                    (fun (s: string) -> (s.Chars 0).ToString().ToUpperInvariant() + s.Substring(1))
                    (List.tail split')) in
        String.concat "" uppers
