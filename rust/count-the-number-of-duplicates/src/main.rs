fn count_duplicates(text: &str) -> u32 {
    use std::collections::HashMap;
    let mut count = 0_u32;
    let mut map = HashMap::<char, i32>::new();
    text.to_lowercase().chars().for_each(|c| match map.get(&c) {
        Some(1) => {
            count += 1;
            map.insert(c, 2);
        }
        Some(v) => {
            map.insert(c, v + 1);
        }
        None => {
            map.insert(c, 1);
        }
    });
    count
}
fn main() {
    println!("{}", count_duplicates("indivisibility"));
}
