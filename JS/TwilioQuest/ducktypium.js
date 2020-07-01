class Ducktypium{
    constructor(color){
            if (!((color==="blue")||(color==="yellow")||(color==="red")))
            {
                throw new SyntaxError("wrong color");
            }
            this.color=color;
        this.calibrationSequence=[];
    }
    refract(color){
        if (!((color==="blue")||(color==="yellow")||(color==="red")))
        {
            throw new SyntaxError("wrong color");
        }
        if (this.color==color){return color;}

        if (this.color==="blue" ||color==="blue"){
            if (this.color==="red" ||color==="red"){
                return "purple";
            }else{return "green";}
        }else{return "orange";}
    }
    calibrate(inputArray){
        this.calibrationSequence=inputArray.sort().map(element=>element*3);
    }
}
// The following would produce an error
try {
    const badColor = new Ducktypium('pink');
  } catch(e) {
    console.log('Color must be red, yellow, or blue!');
  }
  
  // Create a new instance of the class
  const dt = new Ducktypium('red');
  
  console.log(dt.color); // prints 'red'
  
  console.log(dt.refract('blue')); // prints 'purple'
  console.log(dt.refract('red')); // prints 'red'
  
  dt.calibrate([3, 5, 1]);
  
  console.log(dt.calibrationSequence); // prints [3, 9, 15]