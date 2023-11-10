function submit() {
    let form = document.getElementById('mainForm')
    let validateResult = validate()
    if (validateResult)
        form.submit()
}
function validate() {
    let validateResult = true
    let lastname = document.getElementById('lastname')
    let name = document.getElementById('name')
    let surname = document.getElementById('surname')
    let birthday = document.getElementById('birthday')
    let rank = document.getElementById('rank')
    let email = document.getElementById('email')
    let phone = document.getElementById('phone')
    if (lastname.value === null || lastname.value.size > 255) {
        lastname.focus()
        validateResult = false
    }
    if (name.value === null || name.value.size > 255) {
        name.focus()
        validateResult = false
    }
    if (surname.value === null || surname.value.size > 255) {
        surname.focus()
        validateResult = false
    }
    if (birthday.value === null || !/^\d{4}-\d{2}-\d{2}$/.test(birthday.value)) {
        birthday.focus()
        validateResult = false
    }
    if (rank.value === null || rank.value > 200 || rank.value < 0) {
        rank.focus()
        validateResult = false
    }
    if (email.value == null || !/^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/.test(email.value)) {
        email.focus()
        validateResult = false
    }
    if (phone.value == null || !/^\(?\d{3}\)?[-.\s]?\d{3}[-.\s]?\d{4}$/.test(phone.value)) {
        phone.focus()
        validateResult = false
    }
    return validateResult;
}
