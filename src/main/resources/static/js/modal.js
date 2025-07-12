
document.addEventListener('DOMContentLoaded', () => {
    const $modalTrigger = document.querySelector('.js-modal-trigger'); // 모달 열기 버튼 선택
    const modalId = $modalTrigger.dataset.target; // 모달의 ID 가져오기
    const $modal = document.getElementById(modalId); // 모달 요소 선택

    // 모달 열기 함수 정의
    function openModal() {
        $modal.classList.add('is-active'); // 모달에 'is-active' 클래스 추가하여 보이도록 설정
    }

    // 모달 닫기 함수 정의
    function closeModal() {
        $modal.classList.remove('is-active'); // 모달에서 'is-active' 클래스 제거하여 숨기도록 설정
    }

    // 모달 열기 버튼에 클릭 이벤트 리스너 추가
    $modalTrigger.addEventListener('click', () => {
        openModal(); // 모달 열기 함수 호출
    });

    // 모달 배경 닫기
    document.querySelectorAll('.modal-background').forEach(($close) => {
        $close.addEventListener('click', () => {
            closeModal(); // 모달 닫기 함수 호출
        });
    });

    // ESC 키 누를 시 모달 닫기
    document.addEventListener('keydown', (event) => {
        if (event.key === 'Escape') {
            closeModal(); // 모달 닫기 함수 호출
        }
    });
});



