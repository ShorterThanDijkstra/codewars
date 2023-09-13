fn order_weight(s: &str) -> String {
    // your code
    let mut v = s
        .split_whitespace()
        .map(|s| s.to_string())
        .collect::<Vec<String>>();
    v.sort_by(|a, b| {
        let cmp = sum_str(a).cmp(&sum_str(b));
        if let std::cmp::Ordering::Equal = cmp {
            a.cmp(b)
        } else {
            cmp
        }
    });
    v.join(" ")
}
fn sum_str(s: &String) -> u32 {
    s.chars().fold(0, |acc, c| acc + (c as u32) - ('0' as u32))
}
fn main() {
    println!("{:?}", order_weight("56 65 74 100 99 68 86 180 90"))
}
