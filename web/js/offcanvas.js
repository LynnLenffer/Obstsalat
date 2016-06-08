// Initialize
var canvas = document.getElementsByClassName('canvas')[0];
var canvasButtonLeft = document.getElementsByClassName('canvas-button-left')[0];
var canvasButtonRight = document.getElementsByClassName('canvas-button-right')[0];
var closeButton = document.getElementsByClassName('close-button')[0];
var offCanvasLeft = document.getElementsByClassName('off-canvas-left')[0];
var offCanvasRight = document.getElementsByClassName('off-canvas-right')[0];


// Event-Handler
if(canvasButtonLeft) {
	canvasButtonLeft.addEventListener('click', openOffcanvasLeft);
}
if(canvasButtonRight) {
	canvasButtonRight.addEventListener('click', openOffcanvasRight);
}

closeButton.addEventListener('click', closeOffcanvas);


// open Off-Canvas left
function openOffcanvasLeft() {
    
	canvas.className = 'canvas canvas-active-left';
	offCanvasLeft.className = 'off-canvas-left off-canvas-active-left';
	closeButton.className = 'close-button canvas-active-left active';

} 


// open Off-Canvas right
function openOffcanvasRight() {
    
	canvas.className = 'canvas canvas-active-right';
	offCanvasRight.className = 'off-canvas-right off-canvas-active-right';
	closeButton.className = 'close-button canvas-active-right active';

} 


// close Off-Canvas
function closeOffcanvas() {
    
	canvas.className = 'canvas';

	if(canvasButtonLeft) {
		offCanvasLeft.className = 'off-canvas-left';
	}
	if(canvasButtonRight) {
		offCanvasRight.className = 'off-canvas-right';
	}

	closeButton.className = 'close-button notactive';

}
