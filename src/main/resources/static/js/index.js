document.addEventListener('DOMContentLoaded', function () {
    const tabLinks = document.querySelectorAll('.tabs ul li');
    const contentDivs = document.querySelectorAll('.content');
    const navbarBurgers = Array.from(document.querySelectorAll('.navbar-burger'));
    const BEST_TAB = 'best';

    let activeTab = 'recipe';
    let clickedTab = null; // 클릭한 버튼을 저장하는 변수
    let hoveredTab = null; // 마우스로 호버한 버튼을 저장하는 변수

    // 초기 선택 탭에 대한 내용을 표시합니다.
    showContent(activeTab);

    tabLinks.forEach(link => {
        const linkA = link.querySelector('a');

        // 클릭 이벤트 핸들링
        link.addEventListener('click', (event) => handleTabClick(event, linkA.getAttribute('data-target')));

        // 마우스 오버 이벤트 핸들링
        link.addEventListener('mouseover', () => {
            const target = linkA.getAttribute('data-target');
            hoveredTab = target; // 마우스로 호버한 버튼 업데이트
            if (activeTab !== BEST_TAB && clickedTab !== target) {
                link.classList.add('is-active');
                showContent(target); // 마우스로 버튼 위에 올렸을 때 내용을 보여줍니다.
            }
        });

        // 마우스 아웃 이벤트 핸들링
        link.addEventListener('mouseout', () => {
            if (clickedTab !== linkA.getAttribute('data-target')) {
                // 마우스가 버튼을 떠났을 때는 이전 활성 탭을 다시 활성화합니다.
                showContent(activeTab);
                updateButtonStyles();
            }
        });
    });

    // BEST 버튼 클릭 이벤트 핸들링
    const bestTabButton = document.querySelector('a[data-target="best-button"]');
    bestTabButton.addEventListener('click', (event) => handleTabClick(event, BEST_TAB));

    // 햄버거 버튼 클릭 이벤트 핸들링
    navbarBurgers.forEach(el => {
        el.addEventListener('click', () => {
            const target = el.dataset.target;
            const targetElement = document.getElementById(target);
            el.classList.toggle('is-active');
            targetElement.classList.toggle('is-active');
        });
    });

    function handleTabClick(event, target) {
        event.preventDefault();
        clickedTab = target;
        activeTab = target;
        showContent(activeTab);
        updateButtonStyles(); // 버튼 스타일 업데이트
    }

    function showContent(target) {
        contentDivs.forEach(div => {
            div.classList.remove('active');
        });

        const targetDiv = document.getElementById(`content-${target}`);
        if (targetDiv) { // null 체크 추가
            targetDiv.classList.add('active');
        }
    }

    function updateButtonStyles() {
        tabLinks.forEach(link => {
            link.classList.remove('is-active');
        });

        const activeTabLink = document.querySelector(`a[data-target="${activeTab}"]`).closest('li');
        if (activeTabLink) {
            activeTabLink.classList.add('is-active');
        }
    }
});
