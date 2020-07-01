
function addFirstToLast(inputArray){
let firstLast='';
if (inputArray.length>0){
    firstLast=inputArray[0]+inputArray[inputArray.length-1];
}
return firstLast;
}
console.log(addFirstToLast(['first', 'second', 'third']));
console.log(addFirstToLast(['golden', 'terrier']));
console.log(addFirstToLast(['cheerio']));
console.log(addFirstToLast([]))