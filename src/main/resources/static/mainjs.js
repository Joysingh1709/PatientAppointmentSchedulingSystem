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
	var isaspecialist = document.getElementsByName("Specialist");
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
		var selectedSpecialist = Array.from(isaspecialist).find(val => val.checked)
		postData('http://localhost:8080/admin/saveDoctor', {
			"name": name.value,
			"email": email.value,
			"password": password.value,
			"specialization": specialization.value,
			"gender": gender.value,
			"about": about.value,
			"experience": experience.value,
			"fee": fees.value,
			"isASpecialist": selectedSpecialist.value ? true:false,
			"dob": docdob.value,
			"status": true
		}).then(data => {
			if(data.status){
<<<<<<< HEAD
				alert (data.message)
=======

>>>>>>> 649303c59953922c205f91b14a7aacc916d12481
			}
		})
	}

}


/**
 * Receptionist Registration form validattions
 */


function onRecepRegister() {
	var recepname = document.getElementById("recepName");
	var recepemail = document.getElementById("recepEmail");
	var receppassword = document.getElementById("recepPassword");


	//Receptionist name validation	
	if (recepname.value.length < 4 || recepname.value.length > 100) {
		recepname.classList.add("is-invalid");
	} else {
		recepname.classList.remove("is-invalid");
	}

	//Receptionist email validation
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	if (recepemail.value.match(mailformat)) {
		recepemail.classList.remove("is-invalid");
	} else {
		recepemail.classList.add("is-invalid");
	}

	//Receptionist password validation
	var decimal = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
	if (receppassword.value.match(decimal)) {
		receppassword.classList.remove("is-invalid");
	} else {
		receppassword.classList.add("is-invalid");
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