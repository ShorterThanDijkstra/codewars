fn rot13(message: &str) -> String {
    let range_up_1 = 'A' as u8 .. ('M' as u8) + 1;
    let range_up_2 = 'N' as u8 .. ('Z' as u8) + 1;

    let range_low_1 = 'a' as u8 .. ('m' as u8) + 1;
    let range_low_2 = 'n' as u8 .. ('z' as u8) + 1;
    message
        .chars()
        .map(|c| {
            let c_u8 = c as u8;
            if range_low_1.contains(&c_u8) || range_up_1.contains(&c_u8) {
                (c_u8 + 13) as char
            }else if  range_low_2.contains(&c_u8) || range_up_2.contains(&c_u8)  {
                (c_u8 - 13) as char
            } else {
                c
            }
        })
        .collect::<String>()
}

fn main() {
    println!("{:?}", ('a'..='m').contains(&'m'))
}
