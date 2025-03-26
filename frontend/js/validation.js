function validateRegisterFormOnSubmit(theForm) {
    let reason = "";

    reason += validateName(theForm.firstName);
    reason += validateName(theForm.lastName);
    reason += validateEmail(theForm.email);

    if (reason.length > 0) {  // Changed from reason != ""
        alert("There was a problem:\n" + reason);
        return false;
    }
    return true;
}

function validateLoginFormOnSubmit(theForm) {
    let reason = "";

    reason += validateEmail(theForm.email);
    reason += validatePassword(theForm.password);

    if (reason.length > 0) {  // Changed from reason != ""
        alert("There was a problem:\n" + reason);
        return false;
    }
    return true;
}

// Validate name (first and last name)
function validateName(fld) {
    let error = "";
    const illegalChars = /\W/;  // Using const for constant regex pattern

    if (fld.value === "") {
        fld.style.background = '#ffb6c1';
        error = "Name is required.\n";
    } else if (fld.value.length < 2 || fld.value.length > 45) {
        fld.style.background = '#ffb6c1';
        error = "Invalid name length.\n";
    } else if (illegalChars.test(fld.value)) {
        fld.style.background = '#ffb6c1';
        error = "Name contains illegal characters.\n";
    } else {
        fld.style.background = 'White';
    }
    return error;
}

// Validate password
function validatePassword(fld) {
    fld.style.background = 'White';

    let error = "";

    if (fld.value === "") {
        fld.style.background = '#ffb6c1';
        error = "Password is required.\n";
    } else if (fld.value.length < 8) {
        error = "Password must be at least 8 characters long.\n";
        fld.style.background = '#ffb6c1';
    } else if (fld.value.length > 20) {
        error = "Password cannot be longer than 20 characters.\n";
        fld.style.background = '#ffb6c1';
    } else if (!/[A-Z]/.test(fld.value)) {
        error = "Password must contain at least one uppercase letter.\n";
        fld.style.background = '#ffb6c1';
    } else if (!/\d/.test(fld.value)) {
        error = "Password must contain at least one digit.\n";
        fld.style.background = '#ffb6c1';
    } else {
        fld.style.background = 'White';
    }

    return error;
}


function trim(s) {
    return s.replace(/^\s+|\s+$/, '');
}

function validateEmail(fld) {
    let error = "";
    const tfld = trim(fld.value);
    const emailFilter = /^[^@]+@[^@.]+\.[^@]*\w\w$/;
    const illegalChars = /[\(\)\<\>\,\;\:\\\"\[\]]/;  // No need to escape the quotes

    if (fld.value === "") {
        fld.style.background = '#ffb6c1';
        error = "Email is required.\n";
        document.getElementById('emailError').innerText = error;
    } else if (!emailFilter.test(tfld)) {
        fld.style.background = '#ffb6c1';
        error = "Please enter a valid email address.\n";
        document.getElementById('emailError').innerText = error;
    } else {
        fld.style.background = 'White';
        document.getElementById('emailError').innerText = '';
    }
    return error;
}

