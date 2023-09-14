fn next_smaller_number(n: u64) -> Option<u64> {
    if n == 0 {
        return None;
    }
    let mut v = Vec::new();
    let mut n_hat = n;
    while n_hat > 0 {
        v.push((n_hat % 10) as u8);
        n_hat /= 10;
    }
    v.reverse();
    let is_sorted = next_smaller(&mut v, 0);
    if is_sorted {
        None
    } else if v[0] == 0 {
        None
    } else {
        Some(join(&v))
    }
}
fn next_smaller(v: &mut Vec<u8>, index: usize) -> bool {
    if index == v.len() - 1 {
        return true;
    }
    let is_sorted = next_smaller(v, index + 1);
    if is_sorted {
        let d1 = v[index];
        let d2 = v[index + 1];
        if d1 <= d2 {
            return true;
        } else {
            // println!("{:?}", v);

            next_smaller_digit(d1, v, index);
            // println!("{:?}", v);

            let slice = &mut v[index + 1..];
            slice.sort_by(|&a, &b| b.cmp(&a));
            // println!("{:?}", v);

            return false;
        }
    } else {
        return false;
    }
}
fn next_smaller_digit(d: u8, v: &mut Vec<u8>, start: usize) {
    let mut next_smaller_index = start;
    let mut next_smaller = 0;
    for i in start..v.len() {
        if v[i] < d && v[i] >= next_smaller {
            next_smaller_index = i;
            next_smaller = v[i];
        }
    }

    let tmp = v[start];
    v[start] = v[next_smaller_index];
    v[next_smaller_index] = tmp;
}
fn join(v: &Vec<u8>) -> u64 {
    v.into_iter().fold(0, |acc, &d| acc * 10 + d as u64)
}

fn main() {
    println!("{:?}", next_smaller_number(14808099932685489883));
}
