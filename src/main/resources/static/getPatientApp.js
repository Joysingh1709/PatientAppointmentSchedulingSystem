const baseUrl = "http://localhost:8080/";

document.addEventListener('DOMContentLoaded', function() {
	var appointmentsTable = document.getElementById("appointmentsTable");

	var recentAppointmentsTable = document.getElementById("patientRecentAppointments");

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
			if (appointmentsTable) {
				for (var i = 0; i < res.data.length; i++) {
					var row = appointmentsTable.insertRow(i + 1);
					var cell1 = row.insertCell(0);
					var cell2 = row.insertCell(1);
					var cell3 = row.insertCell(2);
					var cell4 = row.insertCell(3);
					var cell5 = row.insertCell(4);
					var cell6 = row.insertCell(5);

					cell1.innerHTML = res.data[i].appointmentId;
					cell2.innerHTML = res.data[i].doctor.name;
					cell3.innerHTML = res.data[i].doctor.specialization;
					cell4.innerHTML = res.data[i].appointmentTime.toString();
					cell5.innerHTML = res.data[i].patientName;
					cell6.innerHTML = res.data[i].status;
				}
			}


			if (recentAppointmentsTable) {
				document.getElementById("totalAppBooked").innerHTML = res.data.length;
				for (var j = 0; j < res.data.length; j++) {

					var rrow = recentAppointmentsTable.insertRow(j + 1);
					var rcell1 = rrow.insertCell(0);
					var rcell2 = rrow.insertCell(1);
					var rcell3 = rrow.insertCell(2);
					var rcell4 = rrow.insertCell(3);
					var rcell5 = rrow.insertCell(4);
					var rcell6 = rrow.insertCell(5);

					rcell1.innerHTML = res.data[j].appointmentId;
					rcell2.innerHTML = res.data[j].doctor.name;
					rcell3.innerHTML = res.data[j].doctor.specialization;
					rcell4.innerHTML = res.data[j].appointmentTime.toString();
					rcell5.innerHTML = res.data[j].patientName;
					rcell6.innerHTML = res.data[j].status;
				}
			}

		}
	});
});