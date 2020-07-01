function getFirstAmountSorted(inputArray,n){
    let sortedArray=inputArray.sort();
    return sortedArray.slice(0,n);
}
const newArray = getFirstAmountSorted(['cat', 'apple', 'bat'], 2);
console.log(newArray); 