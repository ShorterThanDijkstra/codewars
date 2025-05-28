// https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/train/typescript
export function revRot(s: string, sz: number): string {
    if (sz == 0) {
        return "";
    }
    const chunks = [] as string[]
    let i = 0;
    let chunk = s.substring(i, sz + i);
    while (chunk.length == sz) {
        chunks.push(tweak(chunk));
        i += sz;
        chunk = s.substring(i, sz + i);
    }
    return chunks.join('');
}

function tweak(s: string): string {
    let sum = 0;
    for (let c of s) {
        sum += parseInt(c);
    }
    if (sum % 2 == 0) {
        return s.split('').reverse().join('');
    } else {
        return s.substring(1) + s[0];
    }
}