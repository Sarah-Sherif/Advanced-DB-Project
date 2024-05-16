function formDataToXml(formData) {
	var xmlDoc = document.createElement("employee");
	formData.forEach(function (value, key) {
		var element = document.createElement(key);
		element.textContent = value;
		xmlDoc.appendChild(element);
	});
	return xmlDoc;
}

// on submitting the form, convert the form data to XML and send to server
function submitForm() {
	form = document.getElementById("customer-form");
	const formData = new FormData(form);
	const xml = formDataToXml(formData);
	const xmlString = new XMLSerializer().serializeToString(xml);
	console.log(xml);
	fetch("http://localhost:8081/customer", {
		method: "POST",
		body: xml,
		headers: {
			"Content-Type": "application/xml",
		},
	});
	console.log(xml);
}
