function scan(inputArray){
    let count=0;
    inputArray.forEach(element => {
        if (element==="contraband")
        {count=count+1;}
    });
    return count;
}
const numItems = scan(['dog', 'contraband', 'cat', 'zippers', 'contraband']);
console.log('Number of "contraband": ' + numItems); // should be 2