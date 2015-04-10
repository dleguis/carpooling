var directionsDisplay;
var directionsService = new google.maps.DirectionsService();
var map;

function initialize() {
  directionsDisplay = new google.maps.DirectionsRenderer();
  var mapOptions = {
    zoom: 12,
	scrollwheel: false,
    center: new google.maps.LatLng(50.627256, 3.088102)
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);
  directionsDisplay.setMap(map);
  directionsDisplay.setPanel(document.getElementById('directions-panel'));
  var control = document.getElementById('control');

  map.controls[google.maps.ControlPosition.TOP_CENTER].push(control);

  addMarker(new google.maps.LatLng(pointDepart.latitude, pointDepart.longitude), pointDepart.libelle);
  addMarker(new google.maps.LatLng(pointArrivee.latitude, pointArrivee.longitude), pointArrivee.libelle);

  jQuery.each(etapes, function(index, value) {
    addMarker(new google.maps.LatLng(value.latitude, value.longitude), value.libelle);
  });
}

function addMarker(latilongi, title) {

  console.log(map);

  var marker = new google.maps.Marker({
    position: latilongi,
    title: title,
    draggable: true,
    map: map
  });
  map.setCenter(marker.getPosition())
}

function calcRoute() {
  var start = document.getElementById('start').value;
  var end = document.getElementById('end').value;
  var request = {
    origin: start,
    destination: end,

    travelMode: google.maps.TravelMode.DRIVING
  };
  directionsService.route(request, function(response, status) {
    if (status == google.maps.DirectionsStatus.OK) {
      directionsDisplay.setDirections(response);
    }
  });
}
 // Setup the click event listeners: simply set the map to

google.maps.event.addDomListener(window, 'load', initialize);


// Add a marker to the map and push to the array.
function addMarker(location, libelle) {
  var marker = new google.maps.Marker({
    position: location,
    title: libelle,
    map: map
  });
  markers.push(marker);
}

/*
// In the following example, markers appear when the user clicks on the map.
// The markers are stored in an array.
// The user can then click an option to hide, show or delete the markers.

var map;
var markers = [];

function initialize() {
  var haightAshbury = new google.maps.LatLng(pointDepart.latitude, pointDepart.longitude);
  var mapOptions = {
    zoom: 12,
    center: haightAshbury
   // mapTypeId: google.maps.MapTypeId.TERRAIN
  };
  map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  // This event listener will call addMarker() when the map is clicked.
  //google.maps.event.addListener(map, 'click', function(event) {
  //  addMarker(event.latLng);
  //});
  //console.log(pointDepart.latitude);
  // Adds a marker at the center of the map.
  //addMarker(haightAshbury);

  addMarker(new google.maps.LatLng(pointDepart.latitude, pointDepart.longitude), pointDepart.libelle);
  addMarker(new google.maps.LatLng(pointArrivee.latitude, pointArrivee.longitude), pointArrivee.libelle);

  jQuery.each(etapes, function(index, value) {
    addMarker(new google.maps.LatLng(value.latitude, value.longitude), value.libelle);
  });

}



// Sets the map on all markers in the array.
function setAllMap(map) {
  for (var i = 0; i < markers.length; i++) {
    markers[i].setMap(map);
  }
}

// Removes the markers from the map, but keeps them in the array.
function clearMarkers() {
  setAllMap(null);
}

// Shows any markers currently in the array.
function showMarkers() {
  setAllMap(map);
}

// Deletes all markers in the array by removing references to them.
function deleteMarkers() {
  clearMarkers();
  markers = [];
}

google.maps.event.addDomListener(window, 'load', initialize);
    */