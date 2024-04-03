function pickPeaks(arr) {
    const pos = [];
    const peaks = [];
    if (arr.length < 3) {
        return {pos, peaks}
    }
    let pre = arr[0];
    let i = 1;
    while (i < arr.length - 1) {
        let curr = arr[i];
        let next = arr[i + 1];
        if (pre < curr) {
            if (next < curr) {
                pos.push(i);
                peaks.push(curr);
            } else if (next === curr) {
                const start = i;
                while (i < arr.length - 1 && next === curr) {
                    i += 1;
                    curr = arr[i];
                    next = arr[i + 1];
                }
                if (next < arr[start]) {
                    pos.push(start);
                    peaks.push(arr[start]);
                }
            }

        }
        pre = curr;
        i++;
    }
    return {pos, peaks}
}
