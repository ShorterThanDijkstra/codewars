export function getLengthOfMissingArray(arr: any[]): number {
  if (arr == null || arr.length == 0) {
    return 0
  }
  for (const a of arr) {
    if (a == null || a.length == 0) {
      return 0
    }
  }
  const newArr = arr.map(it => it.length).sort();
  for (let i = 1; i < newArr.length; i++) {
    if (newArr[i] != newArr[i-1] + 1) {
      return  newArr[i-1] + 1;
    }
  }
  return 0
}
