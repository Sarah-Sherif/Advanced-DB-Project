function convertFormDataToXML(formData) {
	let xml = "";
	for (var key in formData) {
		xml += "<" + key + ">";
		xml += formData[key];
		xml += "</" + key + ">";
	}
	return xml;
}

// on submitting the form, convert the form data to XML and send to server
function submitForm() {
	form = document.getElementById;
	const xml = convertFormDataToXML(form);
	fetch("/api/submit", {
		method: "POST",
		body: xml,
	});
	console.log(xml);
}
