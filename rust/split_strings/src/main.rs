fn solution(s: &str) -> Vec<String> {
    let mut vec = Vec::new();
    let mut buf = String::new();
    for char in s.chars() {
        buf.push(char);
        if buf.len() == 2 {
            vec.push(buf.to_owned());
            buf.clear();
        }
    }
    if buf.len() == 1 {
        buf.push('_');
        vec.push(buf.to_owned());
        buf.clear();
    }
    vec
}
fn main() {
    println!("{:?}", solution("abcdefg"))
}
