function changeImg(element){
    console.log(element)
    let prev = element.parentNode.previousElementSibling.firstElementChild
    var attr = prev.getAttribute("src");
    console.log(prev);

    if (attr.indexOf("young") != -1){
        attr = attr.replace("young","old");
    } else {
           attr = attr.replace("old","young");
    }
    prev.setAttribute("src",attr);
}