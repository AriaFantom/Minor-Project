document.querySelector('.back-button').addEventListener('click', () => {
    window.location.href = 'index.html';
});

// show today's date in the element with the id date
document.getElementById('date').textContent = new Date().toDateString();
