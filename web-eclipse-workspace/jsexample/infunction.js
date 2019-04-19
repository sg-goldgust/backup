/**
 * 
 */
function launch() {
	console.log('발사!....');
	clearInterval(timerId);
	console.log('---');
}

function fire() {
	console.log('Boom!....');
}

function countdown(counter, fn) {
	var timerId = setInterval(fn,counter) ;
}

countdown(10000,launch);