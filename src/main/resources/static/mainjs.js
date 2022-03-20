const postData = require('./PostData');

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
			"isASpecialist": selectedSpecialist.value ? true : false,
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
			"dob": recepdob.value,
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
		postData('http://localhost:8080/admin/saveDoctor', {
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

