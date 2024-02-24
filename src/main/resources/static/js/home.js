console.log("home js");

function generatePDF() { 

const color=document.getElementById("color").value	;

console.log("generatePDF ",color);

var dataToSend = {
	pen: 10,
	pencil: 20,
	eraser: 15,
};

/*fetch('/pdf/demo', {
	method: 'POST',
	headers: {
		'Content-Type': 'application/json'
	},
	body: JSON.stringify(dataToSend)
})
	.then(response => {
		console.log('Response received:', response);
		// Check if the response is successful
		if (!response.ok) {
			throw new Error('Network response was not ok');
		}

		// Extracting content disposition header
		const contentDisposition = response.headers.get('content-disposition');
		const fileName = contentDisposition.split('filename=')[1];

		// Handling different content types
		const contentType = response.headers.get('content-type');
		if (contentType && contentType.includes('application/pdf')) {
			// Content type is PDF, so we can display or download it
			response.blob().then(blob => {
				const url = window.URL.createObjectURL(blob);
				const a = document.createElement('a');
				a.href = url;
				a.download = fileName || 'document.pdf';
				document.body.appendChild(a);
				a.click();
				window.URL.revokeObjectURL(url);
			});
		} else {
			// Handle other content types if needed
			console.error('Unsupported content type:', contentType);
		}
	})
	.catch(error => {
		// Handle errors if any
		console.error('Error occurred:', error);
	});*/


}