const burgerTop= document.getElementsByClassName("top");
const burgerBot= document.getElementsByClassName("bottom");
const burgerMid= document.getElementsByClassName("middle");
const burgerSidebar= document.getElementsByClassName("sidebar");
const sideText= document.getElementsByClassName("sidetext");
const burgerWhole= document.querySelectorAll(".top, .bottom, .middle");

const tl = new TimelineMax({paused:true, reversed:true});
tl.timeScale(1);
tl.to(burgerTop, 0.7, { y: 11, yoyo: true, ease: Power1.easeInOut})
    .to(burgerBot, 0.7, { y: -11, yoyo: true, ease: Power1.easeInOut}, '-=0.7')
    .to(burgerTop, 1, {rotation:585})
    .to(burgerMid, 1, {rotation:585}, '-=1')
    .to(burgerBot, 1, {rotation:675}, '-=1')
    .to(burgerWhole, 0.1, {css:{borderColor:"#000"}, ease: Power1.easeOut}, '-=1')
    .to(burgerSidebar, 1, {x:550, ease: Power2.easeOut}, '-=1')
    .staggerFrom(sideText, 0.5, {opacity: 0, y: 25, ease: Power1.easeOut}, 0.1, "-=0.7")
    .to(sideText, 0.2, {css:{color:"#000"}});

function haminate() {
    tl.reversed() ? tl.play() : tl.reverse();
}

