 //needs to be run somewhere with window,like a browser, to use prompt
 const TAX_RATE=0.08;
 const PHONE_PRICE=99.99;
const SPENDING_THRESHOLD=200;
const ACCESSORY_PRICE=9.99;
 
 var balance=301;//Number(prompt("Enter your balance"));
amount=0;
function calculateTax(price){
    return price*TAX_RATE;
}

function formatAmount(price){
    return "$"+price.toFixed(2);
}

while (amount<balance){
    amount+=PHONE_PRICE;
    if (amount<SPENDING_THRESHOLD){
        amount+=ACCESSORY_PRICE;
    }

}
amount+=calculateTax(amount);

console.log("Your purchase"+formatAmount(amount));

if (amount>balance){
    console.log("You can't afford this purchase");
}