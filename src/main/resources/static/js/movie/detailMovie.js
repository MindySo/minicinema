$(document).ready(function () {

    // 댓글 추가
    $(document).on('click', '.addComment', function () {
        var loginId = document.getElementById('loginInfoId').value;
        var nickname = document.getElementById('loginInfoNickname').value;
        var movieId = document.getElementById('movieId').value;
        var commentInput = document.getElementById('commentInput').value;
        if (commentInput.trim() === '') {
            alert('내용을 입력해주세요.');
        }

        const comment = {
            memberId: loginId,
            movieId: movieId,
            nickname: nickname,
            content: commentInput
        };

        console.log(comment);

        fetch('/api/v1/comment/addComment', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(comment)
        })
            .then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    alert('잠시 후 다시 시도해주세요.');
                }
            });
    });

    // 댓글과 대댓글에서 수정 버튼 클릭 시
    $(document).on('click', '.comment-edit', function () {
        // 이미 열려있는 수정버튼을 먼저 닫음
        $(".edit-form").hide();
        $(".commentWithButton").show();

        // 현재 클릭된 버튼의 가장 가까운 부모 div를 찾는다
        var parentDiv = $(this).closest('.singleComment');
        // .edit-form을 토글하고, .relay-form을 숨긴다
        parentDiv.find('.edit-form').show();
        parentDiv.find('.commentWithButton').hide();
    });

    // 수정 폼 - 취소 버튼 클릭 시
    $(document).on('click', '.edit-cancel', function () {
        // 현재 클릭된 버튼의 가장 가까운 부모 div를 찾는다
        var parentDiv = $(this).closest('.singleComment');
        // .edit-form을 토글하고, .relay-form을 숨긴다
        parentDiv.find('.edit-form').hide();
        parentDiv.find('.commentWithButton').show();
    });

    // 수정 폼 - 댓글 수정 (MiniCinema에 알맞게 수정해야 함)
    $(".edit-apply").on('click', function () {
        // 현재 클릭된 버튼이 속한 .edit-form을 찾습니다.
        let editForm = $(this).closest('.edit-form');

        // .edit-form 안의 textarea의 값을 가져옵니다.
        let content = editForm.find('textarea').val();

        // .edit-form의 부모 div로 올라가서 data-comment-id를 찾습니다.
        let commentId = $(this).closest('.singleComment').attr('id');

        const commentDTO = {
            id: commentId,
            content: content
        };

        fetch('/api/v1/comment/updateComment', {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(commentDTO)
        })
            .then(response => {
                if (response.ok) {
                    window.location.reload();
                } else {
                    alert('댓글 수정에 실패했습니다.');
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert('댓글 수정 중 오류가 발생했습니다.');
            });
    });

    // 댓글 삭제 버튼 클릭 시
    $('.comment-delete').on('click', function () {
        if (confirm('댓글을 삭제하시겠습니까?')) {

            var movieId = document.getElementById('movieId').value;
            var commentId = $(this).closest('.singleComment').attr('id');
            const comment = {
                id: commentId
            };

            fetch('/api/v1/comment/removeComment', {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(comment)
            })
                .then(response => {
                    if (response.ok) {
                        window.location.reload();
                    } else {
                        alert('잠시 후 다시 시도해주세요.');
                    }
                });
        }
    });

    // 비동기식 즐겨찾기 추가
    $(document).on('click', '.bi-star', function () {
        var loginId = document.getElementById('loginInfoId');
        if (loginId == null) {
            alert('로그인 후 이용 가능합니다.');
            window.location.href = "/signIn";
        }

        var $this = $(this); // 현재 클릭한 요소를 $this 변수에 저장

        const favoriteDto = {
            movieId: document.getElementById('movieId').value,
            id: loginId.value
        };

        console.log(favoriteDto);

        fetch('/api/v1/favorite/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(favoriteDto)
        })

            .then(response => {
                if (response.ok) {
                    $this.replaceWith(
                        '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-star-fill" viewBox="0 0 16 16" style="margin: 0px 10px">\
                        <path d="M3.612 15.443c-.386.198-.824-.149-.746-.592l.83-4.73L.173 6.765c-.329-.314-.158-.888.283-.95l4.898-.696L7.538.792c.197-.39.73-.39.927 0l2.184 4.327 4.898.696c.441.062.612.636.282.95l-3.522 3.356.83 4.73c.078.443-.36.79-.746.592L8 13.187l-4.389 2.256z"/>\
                        </svg>'
                    );
                } else {
                    alert('잠시 후 다시 시도해주세요.');
                }
            });
    });

    // 비동기식 즐겨찾기 해제
    $(document).on('click', '.bi-star-fill', function () {
        var $this = $(this); // 현재 클릭한 요소를 $this 변수에 저장

        const favoriteDto = {
            movieId: document.getElementById('movieId').value,
            id: document.getElementById('loginInfoId').value
        };

        console.log(favoriteDto);

        fetch('/api/v1/favorite/remove', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(favoriteDto)
        })

            .then(response => {
                if (response.ok) {
                    $this.replaceWith(
                        '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="currentColor" class="bi bi-star" viewBox="0 0 16 16" style="margin: 0px 10px">\
                        <path d="M2.866 14.85c-.078.444.36.791.746.593l4.39-2.256 4.389 2.256c.386.198.824-.149.746-.592l-.83-4.73 3.522-3.356c.33-.314.16-.888-.282-.95l-4.898-.696L8.465.792a.513.513 0 0 0-.927 0L5.354 5.12l-4.898.696c-.441.062-.612.636-.283.95l3.523 3.356-.83 4.73zm4.905-2.767-3.686 1.894.694-3.957a.56.56 0 0 0-.163-.505L1.71 6.745l4.052-.576a.53.53 0 0 0 .393-.288L8 2.223l1.847 3.658a.53.53 0 0 0 .393.288l4.052.575-2.906 2.77a.56.56 0 0 0-.163.506l.694 3.957-3.686-1.894a.5.5 0 0 0-.461 0z"/>\
                        </svg>'
                    );
                } else {
                    alert('잠시 후 다시 시도해주세요.');
                }
            });
    });

    var owl = $('.owl-carousel');
    owl.owlCarousel({
        loop: true,
        margin: 10,
        nav: false,
        responsive: {
            0: {
                items: 1
            },
            600: {
                items: 3
            },
            1000: {
                items: 5
            }
        }
    })

    owl.on('mousewheel', '.owl-stage', function (e) {
        if (e.deltaY > 0) {
            owl.trigger('next.owl');
        } else {
            owl.trigger('prev.owl');
        }
        e.preventDefault();
    });

});

document.addEventListener('DOMContentLoaded', function () {
    var dateElements = document.querySelectorAll('.commentDate');

    // 각 요소에 대해 반복 작업 수행
    dateElements.forEach(function(element) {
        var dateStr = element.innerText; // 현재 표시된 날짜 문자열 가져오기 (예: 2024-09-22T22:12:07.952)

        // 문자열을 Date 객체로 변환
        var date = new Date(dateStr);

        // 원하는 형식으로 변환
        var formattedDate =
            date.getFullYear() + '-' +
            ('0' + (date.getMonth() + 1)).slice(-2) + '-' +
            ('0' + date.getDate()).slice(-2) + ' ' +
            ('0' + date.getHours()).slice(-2) + ':' +
            ('0' + date.getMinutes()).slice(-2);

        // 변환된 날짜를 요소에 설정
        element.innerText = formattedDate;
    });
});