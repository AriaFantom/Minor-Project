window.addEventListener('scroll', function() {
    const navbar = document.querySelector('nav');
    const scrollPosition = window.scrollY;

    console.log(scrollPosition);
    if (scrollPosition > 680) {
        navbar.classList.add('scrolled');
    } else {
        navbar.classList.remove('scrolled');
    }
});