fn snail(matrix: &[Vec<i32>]) -> Vec<i32> {
    let n = matrix.len();
    if n == 0 {
        return Vec::new();
    }
    if n == 1 && matrix[0].len() == 0 {
        return Vec::new();
    }
    let mut start_x = 0;
    let mut start_y = 0;
    let mut steps = n - 1;
    let mut v = Vec::new();
    while steps > 0 {
        // println!("{} {} {}", start_x, start_y, steps);
        right(steps, start_x, start_y, &mut v, matrix);
        down(steps, start_x, start_y + steps, &mut v, matrix);
        left(steps, n - 1 - start_x, n - 1 - start_y, &mut v, matrix);
        up(steps, n - 1 - start_x, start_y, &mut v, matrix);
        start_x += 1;
        start_y += 1;
        steps = if steps > 1 { steps - 2 } else { 0 }
    }
    if n % 2 != 0 {
        v.push(matrix[start_x][start_y])
    }
    v
}
fn right(steps: usize, x: usize, y: usize, v: &mut Vec<i32>, matrix: &[Vec<i32>]) {
    for i in 0..steps {
        v.push(matrix[x][y + i])
    }
}
fn down(steps: usize, x: usize, y: usize, v: &mut Vec<i32>, matrix: &[Vec<i32>]) {
    for i in 0..steps {
        v.push(matrix[x + i][y])
    }
}
fn left(steps: usize, x: usize, y: usize, v: &mut Vec<i32>, matrix: &[Vec<i32>]) {
    for i in 0..steps {
        v.push(matrix[x][y - i])
    }
}
fn up(steps: usize, x: usize, y: usize, v: &mut Vec<i32>, matrix: &[Vec<i32>]) {
    for i in 0..steps {
        v.push(matrix[x - i][y])
    }
}
fn main() {
    let matrix = &[
        vec![1, 2, 3, 1],
        vec![4, 5, 6, 4],
        vec![7, 8, 9, 7],
        vec![7, 8, 9, 7],
    ];
    // let matrix = &[vec![1, 2, 3], vec![4, 5, 6], vec![7, 8, 9]];
    println!("{:?}", snail(matrix))
}
