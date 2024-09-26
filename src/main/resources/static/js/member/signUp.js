function submitForm() {
        const form = document.getElementById('signupForm');

        var auth = "USER";
        if(form.authority.value !== ''){
            auth = form.authority.value;
        }

        const formData = {
        username: form.username.value,
        password: form.password.value,
        nickname: form.nickname.value,
        authority: auth
    };
        console.log(formData);

    fetch('/api/v1/auth/signup', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
    },
        body: JSON.stringify(formData)
    })
        .then(response => {
        if (response.ok) {
            alert('회원가입되었습니다. 로그인 페이지로 이동합니다.')
            window.location.href = "/signIn";
        } else {
            alert('회원가입 실패');
        }
    });
}