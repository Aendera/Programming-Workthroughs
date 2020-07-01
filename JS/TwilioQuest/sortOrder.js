a=process.argv[2].toLowerCase();
b=process.argv[3].toLowerCase();

if (a===b){
    console.log(0);
}else if (a<b){
    console.log(-1);
}else{
    console.log(1);
}