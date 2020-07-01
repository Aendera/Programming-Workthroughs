const numberInput = Number(process.argv[2]);
let output = '';
if (numberInput%3===0) {
  output += 'Java';
}

if (numberInput%5===0) {
  output += 'Script';
}

if (output==="") {
  output = String(numberInput);
}

console.log(output);