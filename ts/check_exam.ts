// https://www.codewars.com/kata/5a3dd29055519e23ec000074/train/typescript
export function checkExam(array1: string[], array2: string[]): number {
    const len: number = array1.length;
    let score = 0;
    for (let i = 0; i < len; i++) {
        const s1 = array1[i]
        const s2 = array2[i]
        if (s2.trim() == '') {
            score += 0;
        } else if (s1 == s2) {
            score += 4;
        } else {
            score -= 1;
        }
    }
    return Math.max(score, 0);
}
