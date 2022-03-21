

gsap.registerPlugin(ScrollTrigger)

gsap.from(".contact-word", {
    duration: 0.5,
    opacity: 0,
    y: -200,
    scale: 10,
    ease: "Bounce.easeOut",
    delay: 0.5,
    stagger: {
        each: 0.1,
        y: -150,
        from: "first",
        grid: "auto",
        ease: "power2.inOut"
    }
});
