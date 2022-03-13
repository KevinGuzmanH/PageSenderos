const autoCompleteJS = new autoComplete({
    selector: "#autoComplete",
    placeHolder: "Buscar título...",
    data: {
        src: () => {
            return fetch("/pdf/getTitles")
                .then(response => response.json())
        },
        cache: true,
    },
    submit: true,
    resultItem: {
        tag: "li",
        class: "autoComplete_result",
        element: (item, data) => {
            item.setAttribute("data-parent", "food-item");
        },
        highlight: "autoComplete_highlight",
        selected: "autoComplete_selected"
    },
    searchEngine: "loose",
    resultsList: {
        element: (list, data) => {
            if (!data.results.length) {
                // Create "No Results" message element
                const message = document.createElement("div");
                // Add class to the created element
                message.setAttribute("class", "no_result");
                // Add message text content
                message.innerHTML = `<span>Found No Results for "${data.query}"</span>`;
                // Append message element to the results list
                list.prepend(message);
            }
        },
        noResults: true,
    }
});
document.querySelector("#autoComplete").addEventListener("selection", function (event) {
    // "event.detail" carries the autoComplete.js "feedback" object
    location.href = "/pdf?titulo=" + encodeURIComponent(event.detail.selection.value)
});

gsap.registerPlugin(ScrollTrigger)

// get cards and add gsap animation to them when they are in viewport
const cards = gsap.utils.toArray('.card')

cards.forEach((card) => {

    gsap.from(card,{
        scaleY: 1,
        scrollTrigger: {
            trigger: card,
            toggleActions: "restart reverse restart reverse"
        },
        duration: 1,
        scale: 0.4,
        y: -200,
        opacity: 0,
        ease: "power1"
    })

})

gsap.from('#profileImg',{
    scale: 0.6,
    duration: 1,
    ease: "Elastic.easeOut.config(1, 0.3)",
})