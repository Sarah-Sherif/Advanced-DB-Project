function formDataToXml(formData) {
	var xmlDoc = document.createElement("employee");
	formData.forEach(function (value, key) {
		var element = document.createElement(key);
		element.textContent = value;
		xmlDoc.appendChild(element);
	});
	return xmlDoc;
}

function submitForm() {
	const form = document.getElementById("employee-form");
	const formData = new FormData(form);
	const xml = formDataToXml(formData);
	console.log(xml);
	fetch("", {
		method: "POST",
		body: xml,
	});
}

function controlSpecialization() {
	if (document.getElementById("role").value == "engineer") {
		document.getElementById("specialization").style.display = "";
		document.getElementById("specialization-label").style.display = "";
	} else {
		document.getElementById("specialization").style.display = "none";
		document.getElementById("specialization-label").style.display = "none";
	}
}

const form = document.getElementById("employee-form");
form.addEventListener("change", (event) => {
	if (event.target.id == "role") {
		controlSpecialization();
	}
});
