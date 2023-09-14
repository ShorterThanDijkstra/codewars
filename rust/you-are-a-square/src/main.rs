fn is_square(n: i64) -> bool {
    if n < 0 {
        false
    } else {
        let sqrt = (n as f64).sqrt().floor();
        (sqrt * sqrt) as i64 == n
    }
}
fn main() {}
