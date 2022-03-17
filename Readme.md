Patient Appointment Scheduling System(PASS)

-- book appointments with the doctors available at the time needed
-- user registration
-- Admin System
-- Doctors, Receptionist are registered by the Admin of the system
-- patient, one can log in/register, add their family members, 
-- check the doctor availability, and can book appointments with the doctors
-- able to view the payments
-- As a receptionist, one can confirm a patient’s appointment
-- able to print the receipt
-- can make an appointment with the specialist doctor
-- cancel the patients' appointment if the patient doesn’t show up
-- is able to cancel/reschedule all the appointments of 
   doctor if the doctor is on leave
-- 

User, doctor, Receptionist, Admin



userdb - {
		userId,
		email,
		password,
		name,
		gender,
		dob,
		appointments[],
		familyMembers[],
	}

doctordb - {
		docId,
		email,
		password,
		name,
		specialization,
		gender,
		about,
		experience,
		fee,
		isASpecialist,
		dob,
		status
	}



scheduledb {
		docId,
		scheduleId,
		schedule : {
				days: [],
				maxApp,
				slots: [{ startDate, endDate}],
			}
	}

ReceptionistDb : {
		receptionistId,
		email,
		password,
	}

AppointmentDb: {
		createdDate,
		updatedDate,
		doctorId,
		userId,
		problem,
		status,
		appointmentTime
	}


AdminUser: {
		adminId,
		name,
		username,
		password,
	}

user -> app book -> doc list -> app booked -> 'Pending' -> receptionist -> Accept



user flow 
use case
entity rel
running app
java 