function getComments() {
  fetch('/data').then(response => response.json()).then((cars) => {
    const commentsListElement = document.getElementById('quote-container');
    commentsListElement.innerHTML = '';
    commentsListElement.appendChild(
        createListElement('First car: ' + cars.firstCar));
    commentsListElement.appendChild(
        createListElement('Middle car: ' + cars.middleCar));
    commentsListElement.appendChild(
        createListElement('Last car: ' + cars.lastCar));

  });
  }
/** Creates an <li> element containing text. */
function createListElement(text) {
  const liElement = document.createElement('li');
  liElement.innerText = text;
  return liElement;
}


function createMap() {
  const map = new google.maps.Map(
      document.getElementById('map'),
      {center: {
          lat: 37.419857, 
          lng: -122.078827},
           zoom: 16});
}


