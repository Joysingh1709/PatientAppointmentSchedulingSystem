var toast = $("#myToast");
var toastMessage = document.getElementById("toast-body-message");

document.addEventListener('DOMContentLoaded', function (e) {
	var patient = localStorage.getItem("patient");
	var doctor = localStorage.getItem("doctor");
	var receptionist = localStorage.getItem("receptionist");
	var adminData = localStorage.getItem("admin");

	let path = window.location.pathname;

	if (adminData) {
		!path.includes("admin") ? window.location.href = "/admin" : null;
	}
	else if (receptionist) {
		!path.includes("receptionist") ? window.location.href = "/receptionist" : null;
	}
	else if (doctor) {
		!path.includes("doctor") ? window.location.href = "/doctor" : null;
	}
	else if (patient) {
		!path.includes("patient") ? window.location.href = "/patient" : null;
	}
	else if (path.includes("registration") && !patient && !doctor && !receptionist && !adminData) {
		!path.includes("registration") ? window.location.href = "/registration" : null;
	}
	else {
		if (!path.includes("login")) {
			window.location.href = "/login";
		}
		localStorage.removeItem("patient");
		localStorage.removeItem("doctor");
		localStorage.removeItem("receptionist");
		localStorage.removeItem("admin");
	}

	if (adminData) {
		document.querySelector(".admin_name").innerHTML = JSON.parse(adminData).name;
	}
	else if (receptionist) {
		document.querySelector(".admin_name").innerHTML = JSON.parse(receptionist).name;
	}
	else if (doctor) {
		document.querySelector(".admin_name").innerHTML = JSON.parse(doctor).name;
	}
	else if (patient) {
		document.querySelector(".admin_name").innerHTML = JSON.parse(patient).name;
	}
});

function logout() {
	localStorage.removeItem("patient");
	localStorage.removeItem("doctor");
	localStorage.removeItem("receptionist");
	localStorage.removeItem("admin");
	window.location.href = "/login";
}

/**
 * Doctor's Registration form validattions
 */

function onRegister() {

	var canSubmit = false;

	var name = document.getElementById("docName");
	var email = document.getElementById("docEmail");
	var password = document.getElementById("docPass");
	var fees = document.getElementById("docFees");
	var experience = document.getElementById("docExp");
	var about = document.getElementById("docAbout");
	var docdob = document.getElementById("docDob");
	var isaspecialist = document.getElementById("IsASpecialist");
	var gender = document.getElementById("docGender")
	var specialization = document.getElementById("docSpecialization");



	//Doctor's name validation	
	if (name.value.length < 4 || name.value.length > 100) {
		name.classList.add("is-invalid");
		canSubmit = false;
	} else {
		name.classList.remove("is-invalid");
		canSubmit = true;
	}

	//Doctor's email validation
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(mailformat)) {
		email.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		email.classList.add("is-invalid");
		canSubmit = false;
	}


	//Doctor's password validation
	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
	if (password.value.match(decimal)) {
		password.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		password.classList.add("is-invalid");
		canSubmit = false;
	}


	//Doctor's fees validation
	var feesnum = /^[0-9]+$/;
	if (fees.value.match(feesnum)) {
		fees.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		fees.classList.add("is-invalid");
		canSubmit = false;
	}

	//Doctor's experience validation	
	var expnum = /^[0-9]+$/;
	if (experience.value.match(expnum)) {
		experience.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		experience.classList.add("is-invalid");
		canSubmit = false;
	}

	//Doctor's about validation	
	if (about.value.length < 0 || about.value.length > 250) {
		about.classList.add("is-invalid");
		canSubmit = false;
	} else {
		about.classList.remove("is-invalid");
		canSubmit = true;
	}

	if (canSubmit) {
		postData('http://localhost:8080/admin/saveDoctor', {
			"name": name.value,
			"email": email.value,
			"password": password.value,
			"specialization": specialization.value,
			"gender": gender.value,
			"about": about.value,
			"experience": experience.value,
			"fee": fees.value,
			"isASpecialist": isaspecialist.value,
			"dob": docdob.value,
			"status": true
		}).then(data => {
			if (data.status) {
				alert(data.message)
			}
		})

	}

}


/**
 * Receptionist Registration form validattions
 */


function onRecepRegister() {
	var canSubmit = false;
	var recepname = document.getElementById("recepName");
	var recepemail = document.getElementById("recepEmail");
	var receppassword = document.getElementById("recepPassword");
	var recepdob = document.getElementById("recepDob");
	var recepgender = document.getElementById("recepGender");

	//Receptionist name validation	
	if (recepname.value.length < 4 || recepname.value.length > 100) {
		recepname.classList.add("is-invalid");
		canSubmit = false;
	} else {
		recepname.classList.remove("is-invalid");
		canSubmit = true;
	}

	//Receptionist email validation
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (recepemail.value.match(mailformat)) {
		recepemail.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		recepemail.classList.add("is-invalid");
		canSubmit = false;
	}

	//Receptionist password validation
	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
	if (receppassword.value.match(decimal)) {
		receppassword.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		receppassword.classList.add("is-invalid");
		canSubmit = false;
	}

	if (canSubmit) {
		postData('http://localhost:8080/admin/saveReceptionist', {
			"name": recepname.value,
			"email": recepemail.value,
			"password": receppassword.value,
			"gender": recepgender.value,
			"dob": recepdob.value
		}).then(data => {
			if (data.status) {
				alert(data.message)
			}
		})
	}
}

/**
 * Patient's Registration form validattions
 */

function onPatRegister() {

	var canSubmit = false;
	var patname = document.getElementById("patName");
	var patemail = document.getElementById("patEmail");
	var patpassword = document.getElementById("patPassword");
	var patdob = document.getElementById("patDob");
	var patgender = document.getElementById("patGender");



	//Patient's name validation	
	if (patname.value.length < 4 || patname.value.length > 100) {
		patname.classList.add("is-invalid");
		canSubmit = false;
	} else {
		patname.classList.remove("is-invalid");
		canSubmit = true;
	}

	//Patient's email validation
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (patemail.value.match(mailformat)) {
		patemail.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		patemail.classList.add("is-invalid");
		canSubmit = false;
	}

	//Patient's password validation
	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
	if (patpassword.value.match(decimal)) {
		patpassword.classList.remove("is-invalid");
		canSubmit = true;
	} else {
		patpassword.classList.add("is-invalid");
		canSubmit = false;
	}

	if (canSubmit) {

		postData('http://localhost:8080/patient/savePatient', {
			"name": patname.value,
			"email": patemail.value,
			"password": patpassword.value,
			"gender": patgender.value,
			"dob": patdob.value,
		}).then(data => {
			if (data.status) {
				alert(data.message)
			}
		})
	}
}


async function postData(url = '', data = {}) {
	const response = await fetch(url, {
		method: 'POST', // *GET, POST, PUT, DELETE, etc.
		headers: {
			'Content-Type': 'application/json'
			// 'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: JSON.stringify(data) // body data type must match "Content-Type" header
	});
	return response.json(); // parses JSON response into native JavaScript objects
}

async function getData(url = '', data = {}) {
	const response = await fetch(url, {
		method: 'GET', // *GET, POST, PUT, DELETE, etc.
		headers: {
			'Content-Type': 'application/json'
			// 'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: JSON.stringify(data) // body data type must match "Content-Type" header
	});
	return response.json(); // parses JSON response into native JavaScript objects
}

async function putData(url = '', data = {}) {
	const response = await fetch(url, {
		method: 'PUT', // *GET, POST, PUT, DELETE, etc.
		headers: {
			'Content-Type': 'application/json'
			// 'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: JSON.stringify(data) // body data type must match "Content-Type" header
	});
	return response.json(); // parses JSON response into native JavaScript objects
}

async function deleteData(url = '', data = {}) {
	const response = await fetch(url, {
		method: 'DELETE', // *GET, POST, PUT, DELETE, etc.
		headers: {
			'Content-Type': 'application/json'
			// 'Content-Type': 'application/x-www-form-urlencoded',
		},
		body: JSON.stringify(data) // body data type must match "Content-Type" header
	});
	return response.json(); // parses JSON response into native JavaScript objects
}




//Login Page validation
function docDisFunction() {
	document.getElementById("docDIV").style.display = "block";
	document.getElementById("patDIV").style.display = "none";
	document.getElementById("resDIV").style.display = "none";
}
function patDisFunction() {
	document.getElementById("patDIV").style.display = "block";
	document.getElementById("docDIV").style.display = "none";
	document.getElementById("resDIV").style.display = "none";
}
function resDisFunction() {
	document.getElementById("resDIV").style.display = "block";
	document.getElementById("docDIV").style.display = "none";
	document.getElementById("patDIV").style.display = "none";
}
function patLogin() {

	var canLogin = false;
	var email = document.getElementById("typeEmailX-1");
	var password = document.getElementById("typePasswordX-1");

	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(mailformat)) {
		email.classList.remove("is-invalid");
		canLogin = true;
	} else {
		email.classList.add("is-invalid");
		canLogin = false;
	}


	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
	if (password.value.match(decimal)) {
		password.classList.remove("is-invalid");
		canLogin = true;
	} else {
		password.classList.add("is-invalid");
		canLogin = false;
	}

	if (canLogin) {
		postData('http://localhost:8080/patient/login', {
			"email": email.value,
			"password": password.value,
		}).then(data => {
			if (data.status) {
				console.log(data.message);
				localStorage.setItem("patient", JSON.stringify(data.data));
				window.location.href = "/patient";
			} else {
				console.log(data);
				toastMessage.innerHTML = data.message;
				toast.toast("show");
			}
		}).catch(err => {
			console.log(err);
			localStorage.removeItem("patient");
		})
	}

	document.forms['patForm'].reset();

}
function docLogin() {

	var canLogin = false;
	var email = document.getElementById("typeEmailX-2");
	var password = document.getElementById("typePasswordX-2");

	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(mailformat)) {
		email.classList.remove("is-invalid");
		canLogin = true;
	} else {
		email.classList.add("is-invalid");
		canLogin = false;
	}


	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
	if (password.value.match(decimal)) {
		password.classList.remove("is-invalid");
		canLogin = true;
	} else {
		password.classList.add("is-invalid");
		canLogin = false;
	}


	if (canLogin) {
		postData('http://localhost:8080/doctor/login', {
			"email": email.value,
			"password": password.value,
		}).then(data => {
			if (data.status) {
				console.log(data.message);
				localStorage.setItem("doctor", JSON.stringify(data.data));
				window.location.href = "/doctor";
			}
		}).catch(err => {
			console.log(err);
			localStorage.removeItem("doctor");
		})
	}


	document.forms['docForm'].reset();

}
function resLogin() {

	var canLogin = false;
	var email = document.getElementById("typeEmailX-3");
	var password = document.getElementById("typePasswordX-3");

	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (email.value.match(mailformat)) {
		email.classList.remove("is-invalid");
		canLogin = true;
	} else {
		email.classList.add("is-invalid");
		canLogin = false;
	}


	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
	if (password.value.match(decimal)) {
		password.classList.remove("is-invalid");
		canLogin = true;
	} else {
		password.classList.add("is-invalid");
		canLogin = false;
	}


	if (canLogin) {
		postData('http://localhost:8080/receptionist/login', {
			"email": email.value,
			"password": password.value,
		}).then(data => {
			if (data.status) {
				console.log(data.message);
				localStorage.setItem("receptionist", JSON.stringify(data.data));
				window.location.href = "/receptionist";
			}
		}).catch(err => {
			console.log(err);
			localStorage.removeItem("receptionist");
		})
	}


	document.forms['resForm'].reset();

}

