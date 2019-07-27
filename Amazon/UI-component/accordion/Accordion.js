let accordionGroup = document.querySelector('.accordion-group');
let panels = document.querySelectorAll('.panel');

accordionGroup.addEventListener('click', function (event) {
    // let index = event.target.dataset.index;
    event.target.classList.toggle('active');
    // event.target.maxHeight = event.target.maxHeight ? null : event.target.scrollHeight + 'px';

    let panel = event.target.nextElementSibling;
    panel.style.display = panel.style.display === 'block' ? 'none' : 'block';
    if (panel.style.maxHeight) {
        panel.style.maxHeight = null;
    } else {
        panel.style.maxHeight = panel.scrollHeight + "px";
    }
})