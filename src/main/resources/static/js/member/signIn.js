function submitForm() {
    const form = document.getElementById('loginForm');
    const formData = {
        username: form.username.value,
        password: form.password.value
    };

    fetch('/api/v1/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
        .then(response => {
            if (response.ok) {
                window.location.href = "/";  // 로그인 성공 시 리다이렉트
            } else {
                alert('일치하는 유저 정보가 없습니다.');
            }
        });
}