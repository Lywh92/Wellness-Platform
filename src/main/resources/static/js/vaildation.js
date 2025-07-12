document.addEventListener('DOMContentLoaded', function () {


    function applyIconStyles(icon, isValid, iconClass) {
        if (icon) {
            const iconElement = icon.querySelector('.icon i');
            if (iconElement) {
                iconElement.className = iconClass;
            } else {
                console.error('Icon element not found.');
            }
         }
     }

     function validateInput(input) {
        const value = input.value;
        const regex = new RegExp(input.getAttribute('data-regex'));
        const iconLeft = input.parentElement.querySelector('.is-left');
        const iconRight = input.parentElement.querySelector('.is-right');
        const message = input.parentElement.nextElementSibling;
        const isValid = value.trim() !== '' && (!regex || regex.test(value));

        // 왼쪽 아이콘 스타일 변경
        if (iconLeft) {
            const iconClass = isValid
                ? input.getAttribute('data-icon-valid-left')
                : input.getAttribute('data-icon-invalid-left');
            applyIconStyles(iconLeft, isValid, iconClass);
        }

        // 오른쪽 아이콘 스타일 변경
        if (iconRight) {
            const iconClass = isValid
                ? input.getAttribute('data-icon-valid-right')
                : input.getAttribute('data-icon-invalid-right');
            applyIconStyles(iconRight, isValid, iconClass);
        }

        // 입력란 스타일 변경
        input.classList.toggle('invalid', !isValid);
        // input.style.borderColor = isValid ? 'initial' : 'red';

         if (message) {
             message.classList.toggle('is-danger', !isValid);
             message.classList.toggle('is-success', isValid);
         } else {
             console.error('Message element not found.');
         }
        // input.placeholder = isValid ? input.getAttribute('data-placeholder') : '올바른 값을 입력하세요.';
    }

    const inputs = document.querySelectorAll('input');
    inputs.forEach((input) => {
        input.addEventListener('focus', () => {
            validateInput(input);
        });

        input.addEventListener('input', () => {
            validateInput(input);
        });
    });

});