/**
 * Doctor's Registration form validattions
 */
 
 function onRegister(){
		
		var name = document.getElementById("docName");
		var email = document.getElementById("docEmail");
		var password = document.getElementById("docPass");
		var fees = document.getElementById("docFees");
		var experience = document.getElementById("docExp");
		var about = document.getElementById("docAbout");
		
		//Doctor's name validation	
		if(name.value.length < 4 || name.value.length > 100)
		{
		name.classList.add("is-invalid");
		}else{
			name.classList.remove("is-invalid");
		}
		
		//Doctor's email validation
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(email.value.match(mailformat))
		{
			email.classList.remove("is-invalid");
			}else{
				email.classList.add("is-invalid");
			}
			
		
		//Doctor's password validation
		var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
		if(password.value.match(decimal)) 
		{
			password.classList.remove("is-invalid");
			}else{
				password.classList.add("is-invalid");
			}

	
		//Doctor's fees validation
		var feesnum= /^[0-9]+$/;
		if(fees.value.match(feesnum)) 
		{
			fees.classList.remove("is-invalid");
			}else{
				fees.classList.add("is-invalid");
			}
		
		//Doctor's experience validation	
		var expnum= /^[0-9]+$/;
		if(experience.value.match(expnum)) 
		{
			experience.classList.remove("is-invalid");
			}else{
				experience.classList.add("is-invalid");
			}
			
		//Doctor's about validation	
		if(about.value.length < 0 || about.value.length > 250)
		{
		about.classList.add("is-invalid");
		}else{
			about.classList.remove("is-invalid");
		}
		
	}
	
	
/**
 * Receptionist Registration form validattions
 */
 
 
	function onRecepRegister(){
		var recepname = document.getElementById("recepName");
		var recepemail = document.getElementById("recepEmail");
		var receppassword = document.getElementById("recepPassword");
		
		
		//Receptionist name validation	
		if(recepname.value.length < 4 || recepname.value.length > 100)
		{
		recepname.classList.add("is-invalid");
		}else{
			recepname.classList.remove("is-invalid");
		}
		
		//Receptionist email validation
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(recepemail.value.match(mailformat))
		{
			recepemail.classList.remove("is-invalid");
			}else{
				recepemail.classList.add("is-invalid");
			}
			
		//Receptionist password validation
		var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
		if(receppassword.value.match(decimal)) 
		{
			receppassword.classList.remove("is-invalid");
			}else{
				receppassword.classList.add("is-invalid");
			}
	}
	 function onPatRegister(){
		var patname = document.getElementById("patName");
		var patemail = document.getElementById("patEmail");
		var patpassword = document.getElementById("patPassword");
		
		
		//Receptionist name validation	
		if(patname.value.length < 4 || patname.value.length > 100)
		{
		patname.classList.add("is-invalid");
		}else{
			patname.classList.remove("is-invalid");
		}
		
		//Receptionist email validation
		var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
		if(patemail.value.match(mailformat))
		{
			patemail.classList.remove("is-invalid");
			}else{
				patemail.classList.add("is-invalid");
			}
			
		//Receptionist password validation
		var decimal=  /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{6,20}$/;
		if(patpassword.value.match(decimal)) 
		{
			patpassword.classList.remove("is-invalid");
			}else{
				patpassword.classList.add("is-invalid");
			}
		
	}