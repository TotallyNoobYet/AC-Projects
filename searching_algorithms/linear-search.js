const cards = [1,2,3,4,5,6,7,8,9];  

function findCard(num) {
    for (let i = 0; i < cards.length; i++) {
        if (cards[i] === num) {
            return cards[i]; 
        }
    }
    return "Not found"; 
}

console.log(findCard(3)); 


for ( let i = 0; i <= cards.length; i++){
    console.log('findCard(' + i + ')');
    console.log(findCard1(i, cards));
    console.log('**************');
}