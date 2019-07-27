let slideIndex = 1;
let slides = document.querySelectorAll('.mySlides');
let dots = document.querySelectorAll('.dot');

showSlide(slideIndex);

function changeSlide(n) {
    showSlide(slideIndex += n);
}

function currentSlide(n) {
    showSlide(slideIndex = n);
}

function showSlide(n) {
    let i;
    if (n > slides.length) slideIndex = 1;
    if (n < 1) slideIndex = slides.length;
    // clear any selected active img
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = 'none';
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(' active', '');
    }
    slides[slideIndex - 1].style.display = "block";
    dots[slideIndex - 1].className += " active";
}