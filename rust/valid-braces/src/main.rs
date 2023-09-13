fn is_open(c: char) -> bool {
    match c {
        '(' => true,
        '[' => true,
        '{' => true,
        _ => false,
    }
}
fn is_close(c: char) -> bool {
    match c {
        ')' => true,
        ']' => true,
        '}' => true,
        _ => false,
    }
}
fn is_match(open: char, close: char) -> bool {
    match open {
        '(' => close == ')',
        '[' => close == ']',
        '{' => close == '}',
        _ => false,
    }
}
fn valid_braces(s: &str) -> bool {
    let mut v = Vec::<char>::new();
    for c in s.chars() {
        if is_open(c) {
            v.push(c);
        } else if is_close(c) {
            match v.pop() {
                Some(p) => {
                    if !is_match(p, c) {
                        return false;
                    }
                }
                None => {
                    return false;
                }
            }
        } else {
            return false;
        }
    }
    v.is_empty()
}
fn main() {
    println!("{}", valid_braces("()"));
}
