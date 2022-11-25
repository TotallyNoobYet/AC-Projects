

const cards = [1,2,3,4,5,6,7,8,9]; 


function findCard1(num, cardsDeck){
    let deck = cardsDeck; 
    let middlePosition; 

    if (num < cardsDeck[0] || num > cardsDeck[deck.length -1]){
        return "not found"; 
    }


    while (num !== deck[middlePosition]){
        middlePosition = Math.floor(deck.length/2); 

        if ( num > deck[middlePosition] ){
            deck = deck.slice(middlePosition); 

        } else if ( num < deck[middlePosition]){
            deck = deck.slice(0, middlePosition);
        } 
    }
    return deck[middlePosition]; 
}

for ( let i = 0; i <= cards.length; i++){
    console.log('findCard(' + i + ')');
    console.log(findCard1(i, cards));
    console.log('**************');
}





