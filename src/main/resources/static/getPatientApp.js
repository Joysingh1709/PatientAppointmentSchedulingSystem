/*const baseUrl = "https://pass-dev.herokuapp.com/";*/
const baseUrl = "http://localhost:8080/";

document.addEventListener('DOMContentLoaded', function() {
	var appointmentsTable = document.getElementById("appointmentsTable");

	var patient = JSON.parse(localStorage.getItem("patient"));
	var patientId = patient.userId;

	fetch(baseUrl + "patient/appointments/" + patientId, {
		method: 'GET',
		headers: {
			'Content-Type': 'application/json'
		}
	}).then(function(response) {
		return response.json();
	}).then((res) => {
		if (res.status) {
			console.log(res.data);
			for (var i = 0; i < res.data.length; i++) {
				var row = appointmentsTable.insertRow(i + 1);
				var cell1 = row.insertCell(0);
				var cell2 = row.insertCell(1);
				var cell3 = row.insertCell(2);
				var cell4 = row.insertCell(3);
				var cell5 = row.insertCell(4);
				var cell6 = row.insertCell(5);
                var cell6 = row.insertCell(6);

				cell1.innerHTML = res.data[i].appointmentId;
				cell2.innerHTML = res.data[i].doctor.name;
				cell3.innerHTML = res.data[i].doctor.specialization;
				cell4.innerHTML = res.data[i].appointmentTime.toString();
				cell5.innerHTML = res.data[i].patientName;
				cell6.innerHTML = res.data[i].problem;
                cell6.innerHTML = res.data[i].status;
			}
		}
	});
});