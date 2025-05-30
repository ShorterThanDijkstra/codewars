export function interpreter(code: string, tape: string): string {
    const ops = code.split('');
    const cells = tape.split('');
    const tapeLen = tape.length;
    let tapePoint = 0;
    let i = 0;
    while (i < ops.length) {
        const op = ops[i];
        if (op === '>') {
            tapePoint += 1;
        } else if (op === '<') {
            tapePoint -= 1;
        } else if (op === '*') {
            if (cells[tapePoint] === '0') {
                cells[tapePoint] = '1';
            } else if (cells[tapePoint] === '1') {
                cells[tapePoint] = '0';
            }
        } else if (op === '[') {
            if (cells[tapePoint] === '0') {
                while (i < ops.length && ops[i] !== ']') {
                    i += 1;
                }
                if (i >= ops.length) {
                    return cells.join('');
                }
            }
        } else if (op === ']') {
            if (cells[tapePoint] !== '0') {
                while (i >= 0 && ops[i] !== '[') {
                    i -= 1;
                }
                if (i < 0) {
                    return cells.join('');
                }
            }
        }
        if (tapePoint < 0 || tapePoint >= tapeLen) {
            return cells.join('');
        }
        i += 1;
    }
    return cells.join('');
}
