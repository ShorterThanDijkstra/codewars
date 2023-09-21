fn valid_isbn10(isbn: &str) -> bool {
    if isbn.len() != 10 {
        false
    } else {
        let (_, acc) = isbn
            .char_indices()
            .map(|(i, c)| match c {
                '0'..='9' => Some((c as i32) - ('0' as i32)),
                'X' => {
                    if i == 9 {
                        Some(10)
                    } else {
                        None
                    }
                }
                _ => None,
            })
            .fold((1, Some(0)), |(i, acc), x| {
                if let (Some(v1), Some(v2)) = (x, acc) {
                    (i + 1, Some(v1 * i + v2))
                } else {
                    (i + 1, None)
                }
            });
        if let Some(v) = acc {
            v % 11 == 0
        } else {
            false
        }
    }
}
fn main() {
    // println!("{:?}", valid_isbn10("1112223339"))
    let x = "hello".chars().enumerate();
}
