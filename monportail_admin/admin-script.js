document.addEventListener('DOMContentLoaded', () => {
    const buttons = document.querySelectorAll('.nav-btn');
    const tabs = document.querySelectorAll('.tab-content');
    const searchBar = document.getElementById('search-bar');
    const requestItems = document.querySelectorAll('.request-item');

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

    // Search bar functionality
    searchBar.addEventListener('input', () => {
        const query = searchBar.value.toLowerCase();
        requestItems.forEach(item => {
            if (item.textContent.toLowerCase().includes(query)) {
                item.style.display = 'block';
            } else {
                item.style.display = 'none';
            }
        });
    });
});
function toggleContent(button) {
    const content = button.nextElementSibling;
    if (content.style.display === "none" || content.style.display === "") {
        content.style.display = "block";
        button.textContent = button.textContent.replace('▼', '▲');
    } else {
        content.style.display = "none";
        button.textContent = button.textContent.replace('▲', '▼');
    }
}