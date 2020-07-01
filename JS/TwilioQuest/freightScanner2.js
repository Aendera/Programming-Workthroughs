function scan(inputArray){
  let contrabandIndexes=[];
  for (let i=0;i<inputArray.length;i++){
      if (inputArray[i]==="contraband"){
          contrabandIndexes.push(i);
      }
  }  
  return contrabandIndexes;
}
const indexes = scan(['dog', 'contraband', 'cat', 'zippers', 'contraband']);
console.log('Contraband Indexes: ' + indexes); // should be [1, 4]