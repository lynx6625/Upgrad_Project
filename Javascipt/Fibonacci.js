var a = 1, b = 1, f;
/* complete this "for" loop*/
for(let i = 3; i<=15; i++){   //technically 1 and 1 are 2nd and 3rd fibonacci cause fibonacci starts from zero
    f = a+b;                  // f is result var
    a=b;                      //shifting a and b forward by one position
    b=f;                      
}

console.log(f)