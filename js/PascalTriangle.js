function pascalsTriangle(n) {
    if (n === 1) {
        return [1];
    }
    let left = 1;
    let rowCount = 2;
    const res = [1, 1, 1];
    while (rowCount < n) {
        res.push(1);
        for (let i = 0; i < rowCount - 1; i++) {
            res.push(res[left] + res[left + 1]);
            left += 1;
        }
        res.push(1);
        left += 1;
        rowCount += 1;
    }
    return res
}