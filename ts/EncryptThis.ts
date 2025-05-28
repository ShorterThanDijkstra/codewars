export const encryptThis = (str: string): string => {
    return str.split(/\s+/g).map(encryptWord).join(' ').trim()
}

function encryptWord(str: string) {
    const len = str.length;
    if (len == 0) {
        return "";
    }
    const fst = str.charCodeAt(0);
    const snd = str.charAt(1);
    let lst = str.charAt(len - 1);

    let rest = str.substring(2, len - 1);
    if (len == 1 || len == 2) {
        lst = "";
        rest = "";
    }
    return `${fst}${lst}${rest}${snd}`
}