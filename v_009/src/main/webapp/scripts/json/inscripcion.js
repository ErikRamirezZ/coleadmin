function init() {
	console.info("cargando eventos");
	dojo.connect(dojo.byId('btn_save_alumno'), "onclick", saveAlumno);
}


function saveAlumno() {
	console.info("json FormAlumno =>" + getJsonFromForm('_form_alumno'));
	dojo.xhrPost({
		url: "alumnoes/upload",
		postData: getJsonFromForm('_form_alumno'),
		handleAs: "text",
		load: function(data){
			console.info("Message posted.");
		},
		error: function(error){
			// We'll 404 in the demo, but that's okay.  We don't have a 'postIt' service on the
			// docs server.
			console.info( "Message posted. ERROR");
		}
	});
	
}

function getJsonFromForm(idForm) {
	var formJson = dojo.formToJson(idForm);
	return formJson;
}