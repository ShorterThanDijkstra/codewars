fn move_zeros(arr: &[u8]) -> Vec<u8> {
    let mut res = arr
        .into_iter()
        .filter(|&&x| x != 0)
        .map(|x| x.to_owned())
        .collect::<Vec<u8>>();
    let zeros = arr.len() - res.len();
    for _ in 0..zeros {
        res.push(0)
    };
    res
}

fn main() {
    for i in 1..3 {
        println!("{}", i)
    }
}
