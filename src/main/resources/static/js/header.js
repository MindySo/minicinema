document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('searchForm').addEventListener('submit', function(event) {
        var keyword = document.getElementById('keyword').value.trim(); // 입력값에서 공백 제거
        if (keyword === '') { // 값이 비어있으면
            alert('검색어를 입력해 주세요.');
            event.preventDefault(); // 폼 제출을 막음
        }
    });
});

function logout() {
    if(confirm('로그아웃 하시겠습니까?')) {
        fetch('/logout', {
            method: 'get',
        })
            .then(response => {
                if (response.ok) {
                    window.location.href = "/";
                } else {
                    alert('잠시 후 다시 시도해주세요.');
                }
            })

    }
}