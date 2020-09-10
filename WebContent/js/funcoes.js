function validatePassword() {
	var password = document.getElementById("txtPassword"), confirm_password = document
	.getElementById("txtConfirmPassword");
	
	if (password.value != confirm_password.value) {
		confirm_password.setCustomValidity("Senhas diferentes!");
	} else {
		confirm_password.setCustomValidity('');
	}
	
	password.onchange = validatePassword;
	confirm_password.onkeyup = validatePassword;
}