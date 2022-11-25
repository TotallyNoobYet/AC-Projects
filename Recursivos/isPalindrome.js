// melhorar: em vez de passar para um array fazer logo na str


function isPalindrome(str) {
    str = str.toLowerCase();
    letters = str.split(""); 

    console.log(letters); 

    if (letters.length <= 1) return true; 

    if (letters[0] !== letters[letters.length - 1]) return false;

    letters.shift(); 
    letters.pop(); 
    str = letters.join(""); 

    return isPalindrome(str); 
}

console.log(isPalindrome("Ovo"));