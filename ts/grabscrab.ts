function cmp(s1: string[], s2: string[]): boolean {
    if (s1.length !== s2.length) {
        return false;
    }
    for (let i = 0; i < s1.length; i++) {
        if (s1[i] !== s2[i]) {
            return false;
        }
    }
    return true;
}
export function grabscrab(anagram: string, dictionary: string[]): string[] {
    const anagramSort = anagram.split('').sort();
    const res = [] as string[];
    for (const word of dictionary) {
        if (cmp(anagramSort, word.split('').sort())) {
            res.push(word);
        }
    }
    return res;
}
