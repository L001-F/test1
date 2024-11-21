document.addEventListener('DOMContentLoaded', () => {
    const buttons = document.querySelectorAll('.nav-btn');
    const tabs = document.querySelectorAll('.tab-content');

    buttons.forEach(button => {
        button.addEventListener('click', () => {
            // Remove active class from all buttons and tabs
            buttons.forEach(btn => btn.classList.remove('active'));
            tabs.forEach(tab => tab.classList.remove('active'));

            // Add active class to the clicked button
            button.classList.add('active');

            // Show the corresponding tab content
            const target = button.getAttribute('data-target');
            document.getElementById(target).classList.add('active');
        });
    });
});
