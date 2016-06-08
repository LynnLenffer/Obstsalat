// Initialize
var impressum = document.getElementById('impressum');
var impressumButtons = document.getElementsByClassName('impressumButton');

var datenschutz = document.getElementById('datenschutz');
var datenschutzButtons = document.getElementsByClassName('datenschutzButton');

var closeButtons = document.getElementsByClassName('closeButton');

// Event-Handler
for(var i = 0; i < closeButtons.length; i++) {
	closeButtons[i].addEventListener('click', closeLightbox );
}
for(var i = 0; i < impressumButtons.length; i++) {
	impressumButtons[i].addEventListener('click', openImpressum );
}
for(var i = 0; i < datenschutzButtons.length; i++) {
	datenschutzButtons[i].addEventListener('click', openDatenschutz);
}

// open Impressum
function openImpressum() {
	impressum.className = 'lightbox lightboxShow'; 
}

// open Impressum
function openDatenschutz() {
	datenschutz.className = 'lightbox lightboxShow'; 
}


// close Lightbox
function closeLightbox() {
	impressum.className = 'lightbox lightboxHide';
	datenschutz.className = 'lightbox lightboxHide';
}