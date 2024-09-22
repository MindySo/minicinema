function submitForm() {
        const form = document.getElementById('signupForm');

        var auth = "USER";
        if(form.authority.value != null){
            auth = form.authority.value;
        }

        form.authority.value
        const formData = {
        username: form.username.value,
        password: form.password.value,
        nickname: form.password.value,
        authority: auth
    };

    fetch('/api/v1/auth/signup', {
        method: 'POST',
        headers: {
        'Content-Type': 'application/json'
    },
        body: JSON.stringify(formData)
    })
        .then(response => {
        if (response.ok) {
        window.location.href = "/signupSuccess";  // 로그인 성공 시 리다이렉트
    } else {
        alert('회원가입 실패');
    }
    });
}