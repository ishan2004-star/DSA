/**
 * @param {string} text
 * @return {number}
 */
var maxNumberOfBalloons = function(text) {

    let arr = new Array(26).fill(0);

    for (let ch of text) {
        arr[ch.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }

    let min = arr['b'.charCodeAt(0) - 'a'.charCodeAt(0)];

    min = Math.min(min, arr['a'.charCodeAt(0) - 'a'.charCodeAt(0)]);
    min = Math.min(min, arr['l'.charCodeAt(0) - 'a'.charCodeAt(0)] / 2);
    min = Math.min(min, arr['o'.charCodeAt(0) - 'a'.charCodeAt(0)] / 2);
    min = Math.min(min, arr['n'.charCodeAt(0) - 'a'.charCodeAt(0)]);

    return Math.floor(min);

};