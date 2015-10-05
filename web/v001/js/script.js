var myCenter;
var mapProp;
var marker;
var map;

$(document).ready(function(){
	google.maps.event.addDomListener(window, 'load', init);
});

function init() {	
	myCenter = new google.maps.LatLng(20.9436157,-101.4229463);

	mapProp = {
		center:myCenter,
		zoom:18,
		mapTypeId:google.maps.MapTypeId.ROADMAP
	};

	map = new google.maps.Map(document.getElementById("googleMap"),mapProp);
	marker = new google.maps.Marker({
		position:myCenter,
	});
	marker.setMap(map);

}
