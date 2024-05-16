// convert form data to xml format
export function convertFormDataToXML(formData) {
	let xml = "";
	for (var key in formData) {
		xml += "<" + key + ">";
		xml += formData[key];
		xml += "</" + key + ">";
	}
	return xml;
}
