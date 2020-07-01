statusID=Number(process.argv[2]);
drylevel=Number(process.argv[3]);

if ((statusID===0)&&(drylevel>10)){
    console.log("WATER");
}